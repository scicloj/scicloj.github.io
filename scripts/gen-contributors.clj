#!/usr/bin/env bb
;; Generate the /contributors/ pages from the `author` field of the blog posts.
;;
;; Hugo had a `contributors` taxonomy that produced these pages automatically.
;; Quarto has no taxonomies, and its listing `include:` filter did not filter
;; on `author` here, so each contributor page instead gets an explicit
;; `contents:` list. Re-run this after adding or re-attributing a blog post:
;;
;;   bb scripts/gen-contributors.clj

(require '[clojure.string :as str]
         '[babashka.fs :as fs])

(def script-dir (-> *file* fs/absolutize fs/parent str))
(def repo-root (-> script-dir fs/parent str))
(def content-dirs ["blog" "docs"])
(def out-dir (str repo-root "/contributors"))

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

(defn -main []
  (let [ps (posts)
        by-author (reduce (fn [m p]
                            (reduce #(update %1 %2 (fnil conj []) p) m (:authors p)))
                          {} ps)
        names (sort-by str/lower-case (keys by-author))]
    (doseq [n names]
      (let [d (str out-dir "/" (slug n))]
        (fs/create-dirs d)
        (spit (str d "/index.qmd")
              (contributor-page n (sort-by :date #(compare %2 %1) (by-author n))))
        (println (format "%-16s -> /contributors/%s/  (%d posts)"
                         n (slug n) (count (by-author n))))))
    (spit (str out-dir "/index.qmd") (index-page names))
    (println "wrote" (str out-dir "/index.qmd"))))

(-main)
