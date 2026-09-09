#!/usr/bin/env bb

;; Generates docs/resources/libs/index.qmd — the "Tools and libraries" page —
;; from scripts/model.edn.
;;
;; The page is a build product: never edit it by hand, it will be overwritten.
;; Everything on it lives in model.edn, so adding a library, retagging one,
;; rewording the intro or adding a whole new section are all data edits and
;; none of them need a change here.
;;
;;   bb scripts/gen-libs.clj          write the page (only if it changed)
;;   bb scripts/gen-libs.clj --show   print it to stdout instead
;;
;; Run automatically before every render, via `pre-render:` in _quarto.yml.
;;
;; Idea: move towards data driven representation of libraries.
;;
;; Goals:
;;
;;   - Allow editing library data as plain data
;;   - Allow others to build alternative views of the library data
;;
;; Inspired by metadata management on play.teod.eu:
;;
;;   https://github.com/teodorlu/play.teod.eu/tree/a6b2a039323d60e7fed57c13bbc7e61a1295fbd0/play.clj

(require '[babashka.fs :as fs]
         '[clojure.string :as str]
         '[clojure.edn :as edn])

(def script-dir
  (-> *file* fs/absolutize fs/parent str))

(def repo-root
  (-> script-dir fs/parent str))

(def model-file
  (str script-dir "/model.edn"))

(def out-file
  (str repo-root "/docs/resources/libs/index.qmd"))

(defn tags-list
  "The tag legend, one bullet per tag."
  [{:keys [tags]}]
  (str/join "\n" (for [{:tag/keys [id description]} tags]
                   (str "* `" id "` - " description))))

(defn lib-line
  "One library as a Markdown bullet. `act` is pulled out of the tag set and
  shown on its own; the rest are listed alphabetically. For example:

  - [fastmath](https://github.com/generateme/fastmath) :star: (`act`): `math`,`ml`,`rand`,`stat` - a collection of functions for ..."
  [lib]
  (str "- [" (:lib/name lib) "](" (:lib/url lib) ")"
       (when (:star lib)
         " :star:")
       (when (contains? (:tags lib) :act)
         " (`act`)")
       ": "
       (str/join "," (->> (disj (:tags lib) :act)
                          sort
                          (map (fn [tag]
                                 (str "`" (name tag) "`")))))
       " - "
       (:description lib)))

(defn section-str
  "A section's heading, its optional intro, its libraries, and any hand-written
  lines that follow them. A section with no :category is prose only."
  [libs-by-category {:keys [heading intro category after]}]
  (->> (concat [heading]
               (when intro [intro])
               (map lib-line (libs-by-category category))
               after)
       (str/join "\n")))

(defn page-str
  "The whole page: prose, tag legend, then every section in order."
  [model]
  (let [libs-by-category (group-by :lib/category (apply concat (:libs model)))]
    (str (->> (concat [(str/join "\n" (:preamble model))
                       (tags-list model)]
                      (map (partial section-str libs-by-category) (:sections model)))
              (str/join "\n\n")
              str/trim)
         "\n")))

(defn -main [& args]
  (let [page (page-str (edn/read-string (slurp model-file)))]
    (if (= "--show" (first args))
      (print page)
      ;; Written only when it actually changed: this runs before every render,
      ;; and rewriting the file each time would make `quarto preview` see its
      ;; own output and re-render in a loop.
      (if (= page (when (fs/exists? out-file) (slurp out-file)))
        (println "up to date:" out-file)
        (do (spit out-file page)
            (println "wrote" out-file))))))

(apply -main *command-line-args*)
