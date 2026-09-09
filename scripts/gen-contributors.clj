#!/usr/bin/env bb
;; Generate the /contributors/ pages from the `author` field of the blog posts.
;;
;; Hugo had a `contributors` taxonomy that produced these pages automatically.
;; Quarto has no taxonomies, and its listing `include:` filter did not filter
;; on `author` here, so each contributor page instead gets an explicit
;; `contents:` list.
;;
;;   bb scripts/gen-contributors.clj
;;
;; Run automatically before every render, via `pre-render:` in _quarto.yml, so
;; adding or re-attributing a page is enough — these pages follow on their own.
;; It runs after gen-libs.clj, whose generated page also carries an `author`.

(require '[clojure.string :as str]
         '[babashka.fs :as fs])

(def script-dir (-> *file* fs/absolutize fs/parent str))
(def repo-root (-> script-dir fs/parent str))
(def content-dirs ["blog" "docs"])
(def out-dir (str repo-root "/contributors"))

(defn write-if-changed!
  "Write only when the content actually differs. This runs before every render,
   and rewriting these files each time would make `quarto preview` see its own
   output and re-render in a loop."
  [f content]
  (when-not (and (fs/exists? f) (= content (slurp f)))
    (spit f content)
    true))

(defn front-matter
  "Return the YAML front-matter lines of a qmd file."
  [f]
  (let [lines (str/split-lines (slurp f))]
    (when (= "---" (str/trim (first lines)))
      (take-while #(not= "---" (str/trim %)) (rest lines)))))

(defn field [fm k]
  (some (fn [line]
          (when-let [[_ v] (re-matches (re-pattern (str "\\s*" k "\\s*:\\s*(.*?)\\s*")) line)]
            v))
        fm))

(defn parse-list [s]
  (if-let [[_ inner] (some->> s (re-matches #"\[(.*)\]"))]
    (->> (str/split inner #",")
         (map #(-> % str/trim (str/replace #"^\"(.*)\"$" "$1")))
         (remove str/blank?)
         vec)
    (if (str/blank? s) [] [s])))

(defn slug [name]
  (-> name str/lower-case (str/replace #"\s+" "-")))

(defn yaml-str [s]
  (str \" (-> s (str/replace "\\" "\\\\") (str/replace "\"" "\\\"")) \"))

(defn posts
  "Every page carrying an `author` field, across blog and docs, mirroring the
   Hugo `contributors` taxonomy, which spanned all content."
  []
  (->> content-dirs
       (mapcat #(fs/glob (str repo-root "/" %) "**/index.qmd"))
       (map str)
       sort
       (keep (fn [f]
               (let [fm (front-matter f)
                     authors (parse-list (field fm "author"))]
                 (when (seq authors)
                   {:path (str (fs/relativize repo-root f))
                    :title (-> (field fm "title") (str/replace #"^\"(.*)\"$" "$1"))
                    :date (field fm "date")
                    :authors authors}))))))

(defn contributor-page [name posts]
  (str/join
   "\n"
   (concat
    ["---"
     (str "title: " (yaml-str name))
     (str "description: " (yaml-str (str "Scicloj pages contributed by " name)))
     "listing:"
     "  - id: posts"
     "    contents:"]
    (for [p posts] (str "      - \"../../" (:path p) "\""))
    ["    type: default"
     "    sort: \"date desc\""
     "    fields: [date, title, description]"
     "    page-size: 100"
     "toc: false"
     "---"
     ""
     (str "Pages contributed by " name ".")
     ""
     "::: {#posts}"
     ":::"
     ""])))

(defn index-page [names]
  (str/join
   "\n"
   (concat
    ["---"
     "title: \"Contributors\""
     "description: \"People who have written for the Scicloj blog\""
     "toc: false"
     "---"
     ""
     "Scicloj pages are written by members of the community."
     ""]
    (for [n names] (str "- [" n "](/contributors/" (slug n) "/)"))
    [""])))

(defn prune-stale!
  "Remove contributor directories that no page attributes any more, so dropping
   or renaming an `author:` does not leave an orphan page behind. Only
   directories directly under contributors/ are considered, so the generated
   contributors/index.qmd is never touched.

   Refuses to run on an empty author list: that means something went wrong
   upstream, not that every contributor was legitimately removed."
  [names]
  (when (seq names)
    (let [wanted (set (map slug names))]
      (doseq [d (fs/list-dir out-dir)
              :when (and (fs/directory? d)
                         (not (contains? wanted (fs/file-name d))))]
        (fs/delete-tree d)
        (println "removed stale contributor page:" (fs/file-name d))))))

(defn -main []
  (let [ps (posts)
        by-author (reduce (fn [m p]
                            (reduce #(update %1 %2 (fnil conj []) p) m (:authors p)))
                          {} ps)
        names (sort-by str/lower-case (keys by-author))]
    (doseq [n names]
      (let [d (str out-dir "/" (slug n))]
        (fs/create-dirs d)
        (write-if-changed!
         (str d "/index.qmd")
         (contributor-page n (sort-by :date #(compare %2 %1) (by-author n))))))
    (write-if-changed! (str out-dir "/index.qmd") (index-page names))
    (prune-stale! names)
    (println (format "contributors: %d pages from %d authored pages"
                     (count names) (count ps)))))

(-main)
