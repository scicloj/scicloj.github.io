#!/usr/bin/env bb
;; Render notebooks/**.clj to .qmd via Clay, writing only what changed.
;; A pre-render hook in _quarto.yml.
;;
;;   bb scripts/clay-make.clj [--show]
;;
;; Staged first because Clay spits unconditionally, which would loop preview.

(require '[babashka.fs :as fs]
         '[babashka.process :as process]
         '[clojure.string :as str])

(def script-dir (-> *file* fs/absolutize fs/parent str))
(def repo-root (-> script-dir fs/parent str))
(def staging (str repo-root "/.clay-staging"))

(defn staged-files []
  (->> (fs/glob staging "**")
       (remove fs/directory?)
       (map str)
       sort))

(defn write-pages! [show]
  (let [files   (staged-files)
        changed (atom 0)]
    (doseq [f files]
      (let [rel     (str (fs/relativize staging f))
            target  (str repo-root "/" rel)
            content (slurp f)]
        (when-not (and (fs/exists? target) (= content (slurp target)))
          (swap! changed inc)
          (if show
            (println "would write" rel)
            (do (fs/create-dirs (fs/parent target))
                (spit target content)
                (println "wrote" rel))))))
    (println (format "clay: %d notebook page(s), %d changed"
                     (count (filter #(str/ends-with? % ".qmd") files))
                     @changed))))

(defn -main [& args]
  (fs/delete-tree staging)
  (process/shell {:dir repo-root} "clojure" "-M:clay" "-A:markdown")
  (write-pages! (= "--show" (first args)))
  (fs/delete-tree staging))

(apply -main *command-line-args*)
