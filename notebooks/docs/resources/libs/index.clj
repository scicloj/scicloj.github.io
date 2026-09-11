^:kindly/hide-code
^{:clay
  {:quarto {:title         "Tools and libraries"
            :description   "Clojure tools and libraries for data and science"
            :date          "2022-02-14"
            ;; Bump when the data changes; drives the sitemap's <lastmod>.
            :date-modified "2025-03-18"
            :author        ["daslu"]}}}
(ns docs.resources.libs.index
  "https://scicloj.github.io/docs/resources/libs/

  Content is in scripts/model.edn; this is formatting only. A top-level comment
  here would be published as page prose.

  Inspired by https://github.com/teodorlu/play.teod.eu/tree/a6b2a039323d60e7fed57c13bbc7e61a1295fbd0/play.clj"
  (:require [clojure.edn :as edn]
            [clojure.string :as str]
            [scicloj.kindly.v4.kind :as kind]))

^:kindly/hide-code
(def model
  (edn/read-string (slurp "scripts/model.edn")))

^:kindly/hide-code
(defn tags-list
  "The tag legend."
  [{:keys [tags]}]
  (str/join "\n" (for [{:tag/keys [id description]} tags]
                   (str "* `" id "` - " description))))

^:kindly/hide-code
(defn lib-line
  "- [fastmath](url) :star: (`act`): `math`,`ml` - a collection of ..."
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

^:kindly/hide-code
(defn section-str
  "Heading, optional intro, libraries, trailing lines. No :category is prose only."
  [libs-by-category {:keys [heading intro category after]}]
  (->> [heading
        intro
        (str/join "\n" (map lib-line (libs-by-category category)))
        after]
       (remove str/blank?)
       (str/join "\n")))

^:kindly/hide-code
(defn page-body [model]
  (let [libs-by-category (group-by :lib/category (apply concat (:libs model)))]
    (->> (concat [(:preamble model)
                  (tags-list model)]
                 (map (partial section-str libs-by-category) (:sections model)))
         (str/join "\n\n")
         str/trim)))

^:kindly/hide-code
(kind/md (page-body model))
