#!/usr/bin/env bb

;; Idea -- move towards data driven representation of libraries.
;;
;; Goals:
;;
;;   - Simplify editing
;;   - Enable others to play with alternate representations of the data.
;;
;; Plan:
;;
;;   - Endgame: Autogenerate libs.md from libs.edn
;;   - Intermediate step: hardcode some stuff in here.
;;
;; Status 2022-07-18 16:49
;; =======================
;;
;; - Tags are generated from data
;; - Library text is just typed out

;; Copypaste / ideas from Teodor's publishing tooling:
;;
;;   https://github.com/teodorlu/play.teod.eu/tree/a6b2a039323d60e7fed57c13bbc7e61a1295fbd0/play.clj

(require '[babashka.deps :as deps])
(deps/add-deps '{:deps {org.babashka/cli {:mvn/version "0.3.31"}}})
(require '[babashka.cli :as cli]
         '[babashka.fs :as fs]
         '[clojure.java.shell]
         '[clojure.string :as str]
         '[clojure.edn :as edn]
         '[clojure.pprint :refer [pprint]])


(defn str-lines
  "Like (str a b c), but adds newlines and trims.

  Makes it easier to generate plaintext like Markdown."
  [& xs]
  (str/trim (str/join "\n" (map str xs))))

(defn tags-list [model]
  (str/join "\n" (for [{:tag/keys [id description]} (:tags model)]
                   (str "* `" id "` - " description))))

(def tags-whitelist
  "Extracted with ./gen.clj alltags"
  #{:act :array :cljs :csv :data :df :dnn :exp :for :future :geo :gpu :graph :hiccup :interop :json
    :linalg :lit :lt :math :ml :native :nlp :opt :pmap :prob :py :r :rand :stat :tensor :ts :ui :vega
    :vis :xform :xl})

(defn unwords [& words]
  (str/join " " (filter some? words)))

(defn lib-line
  "Show a lib line nicely

  Example:

- [fastmath](https://github.com/generateme/fastmath) :star: (`act`): `math`,`stat`,`rand`,`ml` - a collection of functions for mathematical and statistical computing, machine learning, etc., wrapping several JVM libraries
  "
  [lib]
  (str "- [" (:lib/name lib) "](" (:lib/url lib) ")"
       (when (:star lib) ;; todo star check
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

(defn libs-str
  "Generate libs.md content as string"
  [{}]
  (let [model (edn/read-string (slurp "model.edn"))
        category-libs (fn [category]
                        (->> (:libs model)
                             (apply concat)
                             (filter (fn [lib]
                                       (= category (:lib/category lib))))))]
    ;; for now, hard-code the whole thing
    (str-lines
     "
---
title : \"Tools and libraries\"
description: \"Clojure tools and libraries for data-centric computing\"
lead: \"Clojure tools and libraries for data-centric computing\"
date: 2022-02-14
lastmod: 2022-07-09
draft: false
weight: 31
images: []
contributors: [\"daslu\"]
---

---------------------------------------------------------------------------------------
To supplement our opinionated discussions of the ecosystem, here is a less-opinionated, plain list of relevant libraries written by Clojurians. Not all libraries mentioned here are affiliated with Scicloj, but we seek to be in dialogue with library authors as much as possible.

Do you know about anything relevant that is missing here? - [Let us talk](../../community/contact)!

For every library, we mark whether it is actively developed (`act`), and whether it is still experimental (`exp`).
A star (:star:) means that we know the library to be actively used and useful.

We tag libraries with the field they are relevant to.
"
     ;; probably a good idea to sort these tags
     ;;
     ;; But I'm keeping 1-1 compatibility with the published stuff for now,
     ;; don't want to refactor + change spec at the same time.
     (tags-list model)
     ;; we simply print the other links
     "
## Other lists :link:
These other lists of libraries are very relevant to the emerging Clojure data science stack:
- [Clojurelog](https://clojurelog.github.io/) :star: by the XTDB team - a comparison of various Clojure-Datalog databases
- [Clojure DSL resources](https://github.com/simongray/clojure-dsl-resources) :star: by Simon Gray - a curated list of mostly mature and/or actively developed Clojure resources relevant for dealing with domain-specific languages, in particular parsing and data transformation with/of DSLs.
- [Clojure graph resources](https://github.com/simongray/clojure-graph-resources) :star: by Simon Gray - a curated list of mostly mature and/or actively developed Clojure resources relevant for dealing with graph-like data
"
     "## Diverse toolsets"
     (->> (category-libs :div-tools)
          (map lib-line)
          (str/join "\n"))

     "\n## Optimization"
     (->> (category-libs :optimization)
          (map lib-line)
          (str/join "\n"))

     "\n## Visual tools: literate programming and data visualization"
     (->> (category-libs :visual-tools)
          (map lib-line)
          (str/join "\n"))

     "\n### Vega rendering
In addition to a few of the tools mentioned above, here is a list of dedicated tools dedicated mainly to handling [Vega](https://Vega.github.io/Vega/)/[Vega-lite](https://Vega.github.io/Vega-lite/) specifications. See [this conversation](https://clojurians.zulipchat.com/#narrow/stream/151924-data-science/topic/rendering.20charts.20in.20notespace) for some discussion of the differences and tradeoffs across these tools. "
     (->> (category-libs :vega-rendering)
          (map lib-line)
          (str/join "\n"))

     "\n## Data visualization libraries"
     (->> (category-libs :data-visualization-libraries)
          (map lib-line)
          (str/join "\n"))

     "\n## Data processing"
     (->> (category-libs :data-processing)
          (map lib-line)
          (str/join "\n"))

     "\n## Geospatial processing"
     (->> (category-libs :geospatial-processing)
          (map lib-line)
          (str/join "\n"))

     "\n## Dataframe-like structures"
     (->> (category-libs :dataframe-like-structures)
          (map lib-line)
          (str/join "\n"))
     "- see also geni :star: under the Spark sub category below"

     "\n## Spreadsheets"
     (->> (category-libs :spreadsheets)
          (map lib-line)
          (str/join "\n"))

     "\n## Array programming, linear algebra"
     (->> (category-libs :arrays-and-linalg)
          (map lib-line)
          (str/join "\n"))

     "\n### Deep learning"
     (->> (category-libs :deep-learning)
          (map lib-line)
          (str/join "\n"))


     "\n## Statistics"
     (->> (category-libs :statistics)
          (map lib-line)
          (str/join "\n"))

     "\n## Time series analysis"
     (->> (category-libs :time-series-analysis)
          (map lib-line)
          (str/join "\n"))

     "\n## Bayesian computing & probabilistic programming"
     (->> (category-libs :bayesian-computing-probabilistic-programming)
          (map lib-line)
          (str/join "\n"))

     #_
     "
- [inferme](https://github.com/generateme/inferme) :star: (`act`): `prob`,`rand`,`vis` - extensible probabilistic programming in Clojure itself (rather than a language variation), with support for visualizations
- [clj-stan](https://github.com/thomasathorne/clj-stan) :star:
- [bayadera](https://github.com/uncomplicate/bayadera): `stat`, `rand`, `prob`,`gpu` - Bayesian computing using the GPU
- [sampling](https://github.com/bigmlcom/sampling): `rand` - support srandom sampling of different kinds
- [distributions](https://github.com/michaellindon/distributions): `rand`,`prob` - random sampling and some basic Bayesian computing for certain families of distributions
- [metaprob](https://github.com/probcomp/metaprob) (`exp`): `prob`,`rand`,`cljs` - an embedded languages for probabilistic programming and metaprogramming
- [daphne](https://github.com/plai-group/daphne) (`exp`): `prob` - a probabilisic programming compiler from Clojure syntax to Pytorch
- [anglican](http://probprog.ml/anglican/index.html): `prob`,`rand`,`cljs` - a probabilistic programming language written in clojure, that supports a subset of clojure
"



     "
## Random sampling and simulations
- [masonclj](https://github.com/mars0i/masonclj) :star: (`act`): `rand` - a Clojure wrapper of [MASON](https://cs.gmu.edu/~eclab/projects/mason/), which is a Java library for discrete-event multiagent simulation and agent-based modeling.
- [dsim.cljc](https://github.com/dvlopt/dsim.cljc) :star: (`act`): `rand`,`cljs` - an event-driven engine for Clojure(script) heavily borrowing ideas from discrete-event simulation and hybrid dynamical systems
- [date-gen](https://github.com/conjunctive/date-gen) (`act`): `rand` - randomized date generation supporting CSV output
- [drand](https://github.com/jimpil/drand-clj): `rand` - a client to the [Drand](https://drand.love) randomness service

## Science
- [sicmutils](https://github.com/sicmutils/sicmutils) :star: (`act`) - a library for algebra, calculus, differential geometry and physics based on the [SICM](mitpress.mit.edu/books/structure-and-interpretation-classical-mechanics) book by Sussman & Wisdom
- [cljbox2d](https://github.com/lambdaisland/cljbox2d) :star: (`act`): `cljs` - a Clojure/Clojurescript wrapper of the Box2D physics engine API

## Machine learning
- [scicloj.ml](https://github.com/scicloj/scicloj.ml) :star: (`act`): `ml` - A machine learning platform supporting a large collection of algorithms and pipeline ergonomics
- [clj-ml](https://github.com/joshuaeckroth/clj-ml/): `ml` - machine learning based on wrapping libraries such as the Weka Java library
- [clj-boost](https://gitlab.com/alanmarazzi/clj-boost): `ml` - a wrapper for XGBoost
- [propaganda](https://github.com/tgk/propaganda): `ml` - an implementation of the propagator computational model
- [dvc](https://dvc.org/): `ml` - A programming language independent tool for ML experiment tracking,  Clojure fully supported

### Genetic programming
- [Propeller](https://github.com/lspector/propeller) :star: (`act`): `ml` - \"Yet another Push-based genetic programming system in Clojure\"
- [Clojush](https://github.com/lspector/Clojush) (`act`): `ml` - an implementation of the Push programming language for genetic programming

## Natural Language Processing
- [DataLinguist](https://github.com/simongray/datalinguist) :star: (`act`): `nlp` - a Clojure wrapper for Stanford CoreNLP

## Interop
- [Libpython-clj](https://github.com/clj-python/libpython-clj) :star: (`act`): `interop` - interop with Python
- [clj-python-trampoline](https://github.com/tristanstraub/clj-python-trampoline) :star: (`act`): `interop` - using libpython-clj from an already running python process, without needing any special python builds
- [Libjulia-clj](https://github.com/cnuernber/libjulia-clj) :star: (`act`): `interop` - Julia bindings for Clojure
- [ClojisR](https://github.com/scicloj/clojisr) :star: (`act`): `interop` - interop with R and Renjin (R on the JVM)
- [graalvm-interop](https://github.com/davidpham87/graalvm-rinterop): `interop` - interop with FastR (GraalVM's R)
- [rdata](https://github.com/appliedsciencestudio/rdata/) - A Renjin (pure-JVM R) wrapper to allow Clojure programs to easily read R's RData file format
- [other R interop libraries](https://github.com/scicloj/clojisr/blob/master/doc/existing_libraries.md)
- [from-scala](https://github.com/t6/from-scala): `interop` - interop with Scala
- [Interop template project](https://github.com/behrica/clj-py-r-template): `interop` - A project template which configure several interop libraries automaticaly using Docker

## Parralel computing
- [claypoole](https://github.com/TheClimateCorporation/claypoole) :star: (`act`) - threadpool-based parallel versions of Clojure functions such as `pmap`, `future`, and `for`
- [parallel](https://github.com/reborg/parallel) :star: - parallel-enabled functions, addditional transducers and supporting utilities
- [tesser](https://github.com/aphyr/tesser) :star: - a library for concurrent & commutative folds, including some statistical tasks and Hadoop support
- [tech.parallel](https://github.com/techascent/tech.parallel) :star: (`act`) - parallelization and threading primitives

## Distributed computing
- [titanoboa](https://www.titanoboa.io) :star: (`act`) - a fully distributed, highly scalable and fault tolerant workflow orchestration platform
- [onyx](http://www.onyxplatform.org/) :star: - a library for distributed computation in the cloud
- [overseer](https://github.com/framed-data/overseer) - a library for building and running data pipelines

### Hadoop
- [Parkour](https://github.com/damballa/parkour) - Hadoop MapReduce in idiomatic Clojure

### Spark
- [geni](https://github.com/zero-one-group/geni) :star: (`act`) - `df`: a Spark wrapper
- [sparkling](https://github.com/gorillalabs/sparkling) - a Spark wrapper
- [flambo](https://github.com/sorenmacbeth/flambo) - a Spark wrapper

## Stream processing
### Kafka
- [jackdaw](https://github.com/FundingCircle/jackdaw) :star:  (`act`) - a wrapper for Kafka and Kafka Streams
- [kafka.clj](https://github.com/dvlopt/kafka.clj) :star: (`act`) - a wrapper for Kafka and Kafka Streams
- [ksml](https://github.com/cddr/ksml) :star: (`act`) - representing kafka streams topologies as data
- [rp-jackdaw-clj](https://github.com/rentpath/rp-jackdaw-clj) - various components for interacting with Kafka using Jackdaw
"))
  )

(defn libs-md
  "Generate libs.md"
  [opts]
  (spit "libs.md" (libs-str opts)))

(defn libs-show
  "Show generated libs.md"
  [opts]
  (println (libs-str opts)))

(defn sanitize
  "Read some text into EDN"
  [{}]
  (pprint
   (->> (slurp "plain.txt")
        (str/split-lines)
        (map #(str/split % #" - "))
        (map (fn [[tag-id tag-description]]
               {:tag/id tag-id :tag/description tag-description}))
        (into []))))

(defn find-description [line]
  (-> line
      (str/split #" - ")
      last
      str/trim))

(defn find-tags
  "Find tags in a line"
  [line]
  (->> line
       (re-seq #"`([a-zA-Z_]+)`" )
       (map (fn [[_ tag]]
              (keyword tag)))
       (into #{})))

(defn find-name
  "Names can have a-z, A-Z, _, - and / in them"
  [line]
  (let [[_ match] (re-find #"\[([\w/_\. -]+)\]" line)]
    match))

(defn find-url [line]
  (let [[_ match] (re-find #"\[[\w/_\. -]+\]\(([\w:/\.\-_]+)" line)]
    match))

(defn find-star [line]
  (when (re-find #":star:" line)
    :star))

(defn parse-line
  [raw-line opts]
  (let [line (str/replace raw-line #"^- " "")
        line (str/replace line #": " " - ")]
    (-> {}
        (assoc :lib/name (find-name line))
        (assoc :lib/url (find-url line))
        (merge opts)
        (assoc :tags (find-tags line))
        (assoc :star (find-star raw-line))
        (assoc :description (find-description raw-line))
        )))

(defn str-trim-lines [s]
  (str/split-lines (str/trim s)))

(defn parse-stuff [{:keys [opts]}]
  (let [big (str-trim-lines "
- [inferme](https://github.com/generateme/inferme) :star: (`act`): `prob`,`rand`,`vis` - extensible probabilistic programming in Clojure itself (rather than a language variation), with support for visualizations
- [clj-stan](https://github.com/thomasathorne/clj-stan) :star:
- [bayadera](https://github.com/uncomplicate/bayadera): `stat`, `rand`, `prob`,`gpu` - Bayesian computing using the GPU
- [sampling](https://github.com/bigmlcom/sampling): `rand` - support srandom sampling of different kinds
- [distributions](https://github.com/michaellindon/distributions): `rand`,`prob` - random sampling and some basic Bayesian computing for certain families of distributions
- [metaprob](https://github.com/probcomp/metaprob) (`exp`): `prob`,`rand`,`cljs` - an embedded languages for probabilistic programming and metaprogramming
- [daphne](https://github.com/plai-group/daphne) (`exp`): `prob` - a probabilisic programming compiler from Clojure syntax to Pytorch
- [anglican](http://probprog.ml/anglican/index.html): `prob`,`rand`,`cljs` - a probabilistic programming language written in clojure, that supports a subset of clojure
")
        small (str-trim-lines "
- [tech.ml.dataset](https://github.com/techascent/tech.ml.dataset) :star: (`act`): `df`,`stat`,`vis`,`csv` - abstractions for dataframe-like structures in clojure, based on dtype-next infrastructure
")]
    (pprint
     (->> big
          (map (fn [line]
                 (parse-line line {:lib/category (:category opts)})))))))

(defn alltags
  "Identify all the tags"
  [{}]
  (pprint
   (sort (find-tags (slurp "libs.md")))))

(defn print-help [{}]
  (println (str/trim "
Usage: ./gen.clj <subcommand>

Useful subcommands:

libs-show   - Generate libs.md as string

libs.md     - Generate libs.md


Subcommands for data cleaning:

sanitize    - Helper for building data

alltags     - Extract tags from libs.md

parse-stuff - Helper for building data
")))

(defn main [& args]
  (cli/dispatch [{:cmds ["libs-show"] :fn libs-show}
                 {:cmds ["libs.md"] :fn libs-md}
                 {:cmds ["sanitize"] :fn sanitize}
                 {:cmds ["alltags"] :fn alltags}
                 {:cmds ["parse-stuff"] :fn parse-stuff}
                 {:cmds [] :fn print-help}]
                args
                {:coerce {:category :keyword}}))

(apply main *command-line-args*)
