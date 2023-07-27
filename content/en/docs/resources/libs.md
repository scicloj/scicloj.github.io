---
title : "Tools and libraries"
description: "Clojure tools and libraries for data and science"
lead: "Clojure tools and libraries for data and science"
date: 2022-02-14
lastmod: 2022-07-09
draft: false
weight: 31
images: []
contributors: ["daslu"]
---

---------------------------------------------------------------------------------------
To supplement our opinionated discussions of the ecosystem, here is a less-opinionated, plain list of relevant libraries written by Clojurians. Not all libraries mentioned here are affiliated with Scicloj, but we seek to be in dialogue with library authors as much as possible.

Do you know about anything relevant that is missing here? - [Let us talk](../../community/contact)!

For every library, we mark whether it is actively developed (`act`), and whether it is still experimental (`exp`).
A star (:star:) means that we know the library to be actively used and useful.

We tag libraries with the field they are relevant to.

* `array` - array programming
* `tensor` - tensor programming
* `linalg` - linear algebra
* `native` - interop with native-optimized libraries
* `gpu` - gpu support
* `vis` - data visualization and visual art
* `vega` - visualization using [Vega](https://vega.github.io/vega/)/[Vega-lite](https://vega.github.io/vega-lite/) specifications
* `lit` - literate programming
* `ui` - building UIs for data exploration
* `geo` - geographical and geometrical data processing
* `df` - dataframe-like data structures and abstractions
* `data` - general data processing
* `csv` - csv import/export
* `xl` - Excel spreadsheets interaction
* `json` - json import/export
* `xform` - transducers support
* `math` - diverse math functions
* `stat` - statistics
* `ts` - time series analysis
* `rand` - simulation and random sampling
* `prob` - Bayesian computing and probabilistic programming
* `ml` - machine learning
* `dnn` - deep learning
* `opt` - optimization
* `graph` - graph algorithms and network analysis
* `interop` - general libraries for interop
* `cljs` - supports not only Clojure but also Clojurescript
* `nlp` - natural language processing
* `llm` - large language models and related services

## Other lists :link:
These other lists of libraries are very relevant to the emerging Clojure data science stack:
- [Clojurelog](https://clojurelog.github.io/) :star: by the XTDB team - a comparison of various Clojure-Datalog databases
- [Clojure DSL resources](https://github.com/simongray/clojure-dsl-resources) :star: by Simon Gray - a curated list of mostly mature and/or actively developed Clojure resources relevant for dealing with domain-specific languages, in particular parsing and data transformation with/of DSLs.
- [Clojure graph resources](https://github.com/simongray/clojure-graph-resources) :star: by Simon Gray - a curated list of mostly mature and/or actively developed Clojure resources relevant for dealing with graph-like data

## Diverse toolsets
- [fastmath](https://github.com/generateme/fastmath) :star: (`act`): `math`,`ml`,`rand`,`stat` - a collection of functions for mathematical and statistical computing, machine learning, etc., wrapping several JVM libraries
- [spork](https://github.com/joinr/spork): `df`,`graph`,`opt`,`rand`,`ui`,`vis` - a toolbox for data-science and operation research
- [Incanter](https://github.com/incanter/incanter): `csv`,`df`,`rand`,`stat`,`vis` - an R-like data-science platform built on top of the core.matrix abstractions
- [huri](https://github.com/sbelak/huri): `df`,`stat`,`vis` - a toolbox for data-science using plain sequences of maps

## Optimization
- [matlib](https://github.com/atisharma/matlib) :star: (`act`): `opt` - optimisation and control theory tools and convenience functions based on Neanderthal.

## Visual tools: literate programming and data visualization
- [Saite](https://github.com/jsa-aerial/saite) :star: (`act`): `cljs`,`hiccup`,`lit`,`ui`,`vega`,`vis` - data exploration, dashboards, and interactive documents
- [Oz](https://github.com/metasoarous/oz) :star: (`act`): `lit`,`vega`,`vis` - data visuzliation using Vega/Vega-Lite and Hiccup, and a live-reload platform for literate-programming
- [Clerk](https://github.com/nextjournal/clerk) :star: (`act`): `cljs`,`lit`,`vega`,`vis` - local-first notebooks for Clojure
- [Clay](https://github.com/scicloj/clay) :star: (`act`): `cljs`,`lit`,`vega`,`vis` - a small tool for compatible dynamic experience over some of the other visual tools
- [rmarkdown-clojure](https://github.com/genmeblog/rmarkdown-clojure) :star:: `lit`,`vis` - rendering Clojure code in various format using [Rmarkdown](https://rmarkdown.rstudio.com/)
- [Pink-Gorilla/Goldly](https://github.com/pink-gorilla/goldly) :star: (`act`): `cljs`,`exp`,`lit`,`ui`,`vis` - a port of the Gorilla REPL project using a Clojurescript (Reagent) frontend
- [Org-babel-clojure](https://orgmode.org/worg/org-contrib/babel/languages/ob-doc-clojure.html) :star:: `lt` - executing Clojure inside Emacs Org-mode documents
- [Devcards](https://github.com/bhauman/devcards) :star:: `cljs`,`lit` - visual repl exprience for Clojurescript
- [Notespace](https://github.com/scicloj/notespace) :star: (`act`): `exp`,`lit` - notebook experience with Clojure namespaces edited at any editor
- [Reveal](https://vlaaad.github.io/reveal/) :star: (`act`):  - browser-based data navigation GUI
- [Portal](https://github.com/djblue/portal) :star: (`act`):  - desktop data navigation GUI
- [Gorilla-REPL](http://gorilla-repl.org/): `lit` - a notebook application written in Clojure and Javascript
- [proto-repl-charts](https://github.com/jasongilman/proto-repl-charts): `vis` - an Atom plugin for displaying tables and graphs
- [Maria](https://github.com/mhuebert/maria): `cljs`,`lit`,`vis` - a Clojurescript coding environment for beginners

### Vega rendering
In addition to a few of the tools mentioned above, here is a list of dedicated tools dedicated mainly to handling [Vega](https://Vega.github.io/Vega/)/[Vega-lite](https://Vega.github.io/Vega-lite/) specifications. See [this conversation](https://clojurians.zulipchat.com/#narrow/stream/151924-data-science/topic/rendering.20charts.20in.20notespace) for some discussion of the differences and tradeoffs across these tools. 
- [darkstar](https://github.com/appliedsciencestudio/darkstar) :star:: `vega`,`vis` - a minimal wrapper over Vega/Vega-lite as a single JVM-only Clojure library, using the GraalJS javascript runtime, which [does not require GraalVM runtime](https://github.com/graalvm/graaljs/blob/master/docs/user/RunOnJDK.md) to run.
- [xvsy](https://github.com/dvdt/xvsy): `cljs`,`vega`,`vis` - grammer of graphics over Vega
- [Vegan](https://github.com/cnuernber/Vegan/) (`act`): `vega`,`vis` - a nodejs clojurescript library designed to validate and render Vega and Vega-lite files, supports docker-based setup
- [Vega-clj](https://github.com/behrica/vg-cli) (`act`): `vega`,`vis` - a clojure wrapper for the (node-based) Vega-cli and Vega-lite standalone scrips
- [Optikon](https://github.com/stathissideris/optikon): `vega`,`vis` - a command line tool that wraps Vega and Vega-lite, using GraalVM polyglot programming
- [Vegafx](https://github.com/joinr/Vegafx): `vega`,`vis` - a static-site viewer using javafx that renders Vega specs
- [VL example gallery as EDN](https://behrica.github.io/vl-galery/convert):  - The vega lite example in EDN format, ready to be copy/pasted into Clojure code

## Data visualization libraries
- [cljplot](https://github.com/generateme/cljplot) :star: (`act`): `exp`,`vis` - a data visualization platform written in Clojure and inspired by R's ggplot2 and lattice libraries
- [Hanami](https://github.com/jsa-aerial/hanami) :star: (`act`): `cljs`,`hiccup`,`ui`,`vega`,`vis` - a template system for creating interactive data visualizations using Vega/Vega-lite, Reagent and Re-Com
- [darkstar](https://github.com/appliedsciencestudio/darkstar) :star: (`act`): `cljs`,`vega`,`vis` - simple data visualization for Clojure/Clojurescript that using vega and [darkstar](https://github.com/appliedsciencestudio/darkstar) for rendering
- []() :star: (`act`): `exp`,`vega`,`vis` - a data visualization library for beginners (WIP)
- [Clojure2D](https://github.com/Clojure2D/clojure2d) :star: (`act`): `vis` - Java2D wrapper + creative coding supporting functions (based on Processing and openFrameworks)
- [Quil](https://github.com/quil/quil) :star:: `vis` - a clojure/clojuresctit wrapper for Processing
- [thi-ng/geom](https://github.com/thi-ng/geom) :star:: `cljs`,`vis` - 2d/3d geometry toolkit
- [Gorilla-plot](https://github.com/JonyEpsilon/gorilla-plot) :star:: `vega`,`vis` - plotting functions using Vega for Gorilla-REPL
- [gg4clj](https://github.com/JonyEpsilon/gg4clj): `r`,`vis` - a clojure DSL for creating ggplot2 plots using R
- [gg4clj port](https://github.com/pink-gorilla/gg4clj):  - by the [Pink Gorilla](https://pink-gorilla.github.io) project
- [Analemma](https://liebke.github.io/analemma/): `cljs`,`exp`,`vis` - generating charts and SVG with a syntax similar to Incanter's and a visual theme similar to ggplot2.
- [emacs-Vega-view](https://github.com/appliedsciencestudio/emacs-Vega-view) (`act`): `vega`,`vis` - an emacs mode to facilitate interactive data visualization using Vega from within emacs. Supports elisp, json and clojure notations

## Data processing
- [Specter](https://github.com/redplanetlabs/specter) :star: (`act`): `cljs`,`data` - declarative navigation of nested data structures for selection and transformation in Clojure and Clojurescript
- [Meander](https://github.com/noprompt/meander) :star: (`act`): `cljs`,`data` - transforming neseted data structures by declaratively declaring the shape of source and target datastructures
- [xforms](https://github.com/cgrand/xforms) :star:: `cljs`,`data`,`xform` - a collection of transduces and reducing functions
- [Odin](https://github.com/halgari/odin): `data` - processing nested data structures by extensible logic programming
- [Charred](https://github.com/cnuernber/charred) :star: (`act`): `csv`,`json` - zero dependency efficient read/write of json and csv data.
- [Semantic Csv](https://github.com/metasoarous/semantic-csv): `cljs`,`csv` - higher level csv parsing/processing

## Geospatial processing
- [geo](https://github.com/Factual/geo) :star: (`act`): `geo` - unifying several JVM libraries for geoprocessing with a Clojure API
- [ovid](https://github.com/willcohen/ovid) :star: (`act`): `exp`,`geo` - protocols for geospatial concepts
- [aurelius](https://github.com/willcohen/aurelius) :star: (`act`): `exp`,`geo`,`xform` - transducible analysis of geospatial features
- [geo-clj](https://github.com/r0man/geo-clj) :star: (`act`): `cljs`,`geo` - encoding/decoding of geographic datatypes

## Dataframe-like structures
- [tech.ml.dataset](https://github.com/techascent/tech.ml.dataset) :star: (`act`): `csv`,`df`,`stat`,`vis` - abstractions for dataframe-like structures in clojure, based on dtype-next infrastructure
- [tablecloth](https://github.com/scicloj/tablecloth) :star: (`act`): `csv`,`df` - a dataframe grammar wrapping tech.ml.dataset, inspired by serveral R libraries
- [clojask](https://clojure-finance.github.io/clojask-website/) :star: (`act`): `df` - a library for parallel computing of larger-than-memory datasets.
- [Panthera](https://github.com/alanmarazzi/panthera): `df`,`py` - a Clojure API wrapping Python's Pandas library
- [koala](https://github.com/aria42/koala): `csv`,`df`,`exp` - Pandas-like data-processing for clojure with some I/O functionality (experimental)
- [dataframe](https://github.com/ghl3/dataframe): `df` - Pandas-like data processing for clojure
- [danzig](https://github.com/ribelo/wombat) (`act`): `df`,`exp`,`xform` - Pandas-like data processing using transducers (danzig was formerly named wombat)
- [bamboo](https://github.com/kjothen/bamboo): `df` - a minimal data processing library for Clojure, with some of the capabilities of pandas and numpy
- see also geni :star: under the Spark sub category below

## Spreadsheets
- [Docjure](https://github.com/mjul/docjure) :star: (`act`): `xl` - making it easy to read and write Excel spreadsheets as Clojure data
- [kixi.large](https://github.com/MastodonC/kixi.large) :star: (`act`): `exp`,`xl` - a tech.ml.dataset-friendly fork of Docjure, providing clear entry point at the workbook and sheet level and a way to insert images
- [Excel-clj](https://github.com/matthewdowney/excel-clj) :star: (`act`): `xl` - building Excel spreadsheets from Clojure data in various forms such as trees, tables, and more
- [fxl](https://github.com/zero-one-group/fxl) :star: (`act`): `exp`,`xl` - manipulating spreadsheets with a versatile API for handling various spreadsheet constructs
- [Excel-templates](https://github.com/tomfaulhaber/excel-templates): `exp`,`xl` - building Excel spreadsheets from Clojure data combined with an Excel sheet serving as a template

## Array programming, linear algebra
- [dtype-next](https://github.com/cnuernber/dtype-next) :star: (`act`): `array`,`native`,`stat`,`tensor` - abstractions and foundations for working with array-like structures and sequential structures
- [Neanderthal](https://neanderthal.uncomplicate.org/) :star: (`act`): `array`,`gpu`,`linalg`,`native` - matrix and linear algebra in Clojure
- [tvm-clj](https://github.com/techascent/tvm-clj) (`act`): `array`,`exp`,`gpu`,`linalg`,`native` - bindings to [tvm](https://github.com/apache/incubator-tvm)
- [jutsu.matrix](https://github.com/hswick/jutsu.matrix): `array`,`gpu`,`linalg`,`native` - bindigs to [ND4J](https://deeplearning4j.org/docs/latest/nd4j-overview)
- [core.matrix](https://github.com/mikera/core.matrix): `array`,`cljs`,`linalg`,`native` - matrix abstractions, supporting diffent backends
- [denisovan](https://github.com/cailuno/denisovan): `array`,`gpu`,`linalg`,`native` - Neanderthal backend for core.matrix

### Deep learning
- [Deep Diamond](https://github.com/uncomplicate/deep-diamond) :star: (`act`): `dnn`,`gpu`,`native`,`tensor` - infrastructure for tensor computation and deep learning
- [clj-djl](https://github.com/scicloj/clj-djl) :star: (`act`): `dnn`,`gpu`,`native`,`tensor` - a wrapper for the Deep Java Library
- [MXNet](https://mxnet.apache.org/api/clojure): `dnn` - bindings to Apache MXNet, a part of the MXNet project
- [jutsu.ai](https://github.com/hswick/jutsu.ai): `dnn` - a wrapper for deeplearning4j
- [Cortex](https://github.com/originrose/cortex): `dnn` - a deep learning library written in Clojure
- [Flare](https://github.com/aria42/flare): `dnn` - dynamic neural networks in Clojure

## Statistics
- [kixi.stats](https://github.com/MastodonC/kixi.stats) :star: (`act`): `rand`,`stat`,`xform` - statistics and random sampling using transducers
- [fitdistr](https://github.com/generateme/fitdistr) :star: (`act`): `stat` - fitting distributions

## Time series analysis
- [tide](https://github.com/sbelak/tide): `ts` - STL and FastDTW algorithms

## Bayesian computing & probabilistic programming
- [inferme](https://github.com/generateme/inferme) :star: (`act`): `prob`,`rand`,`vis` - extensible probabilistic programming in Clojure itself (rather than a language variation), with support for visualizations
- [clj-stan](https://github.com/thomasathorne/clj-stan) :star::  - A library for calling the Stan language from Clojure (by shelling out to cmdstan).
- [bayadera](https://github.com/uncomplicate/bayadera): `gpu`,`prob`,`rand`,`stat` - Bayesian computing using the GPU
- [sampling](https://github.com/bigmlcom/sampling): `rand` - support srandom sampling of different kinds
- [distributions](https://github.com/michaellindon/distributions): `prob`,`rand` - random sampling and some basic Bayesian computing for certain families of distributions
- [metaprob](https://github.com/probcomp/metaprob): `cljs`,`exp`,`prob`,`rand` - an embedded languages for probabilistic programming and metaprogramming
- [daphne](https://github.com/plai-group/daphne): `exp`,`prob` - a probabilisic programming compiler from Clojure syntax to Pytorch
- [anglican](http://probprog.ml/anglican/index.html): `cljs`,`prob`,`rand` - a probabilistic programming language written in clojure, that supports a subset of clojure

## Random sampling and simulations
- [masonclj](https://github.com/mars0i/masonclj) :star: (`act`): `rand` - a Clojure wrapper of [MASON](https://cs.gmu.edu/~eclab/projects/mason/), which is a Java library for discrete-event multiagent simulation and agent-based modeling.
- [dsim.cljc](https://github.com/dvlopt/dsim.cljc) :star: (`act`): `cljs`,`rand` - an event-driven engine for Clojure(script) heavily borrowing ideas from discrete-event simulation and hybrid dynamical systems
- [date-gen](https://github.com/conjunctive/date-gen) (`act`): `rand` - randomized date generation supporting CSV output
- [drand](https://github.com/jimpil/drand-clj): `rand` - a client to the [Drand](https://drand.love) randomness service

## Science
- [sicmutils](https://github.com/sicmutils/sicmutils) :star: (`act`):  - a library for algebra, calculus, differential geometry and physics based on the [SICM](mitpress.mit.edu/books/structure-and-interpretation-classical-mechanics) book by Sussman & Wisdom
- [cljbox2d](https://github.com/lambdaisland/cljbox2d) :star: (`act`): `cljs` - a Clojure/Clojurescript wrapper of the Box2D physics engine API

## Machine learning
- [scicloj.ml](https://github.com/scicloj/scicloj.ml) :star: (`act`): `ml` - A machine learning platform supporting a large collection of algorithms and pipeline ergonomics
- [clj-ml](https://github.com/joshuaeckroth/clj-ml/): `ml` - machine learning based on wrapping libraries such as the Weka Java library
- [clj-boost](https://gitlab.com/alanmarazzi/clj-boost): `ml` - a wrapper for XGBoost
- [propaganda](https://github.com/tgk/propaganda): `ml` - an implementation of the propagator computational model
- [dvc](https://dvc.org/): `ml` - A programming language independent tool for ML experiment tracking,  Clojure fully supported

### Genetic programming
- [Propeller](https://github.com/lspector/propeller) :star: (`act`): `ml` - "Yet another Push-based genetic programming system in Clojure"
- [Clojush](https://github.com/lspector/Clojush) (`act`): `ml` - an implementation of the Push programming language for genetic programming

## Natural Language Processing
- [DataLinguist](https://github.com/simongray/datalinguist) :star: (`act`): `nlp` - a Clojure wrapper for Stanford CoreNLP

## Large Language Models and related services
- [Bosquet](https://github.com/zmedelis/bosquet) :star: (`act`): `llm` - LLMOps for Large Language Model based applications
- [llama.clj](https://github.com/phronmophobic/llama.clj) :star: (`act`): `llm` - A wrapper of [llama.cpp](https://github.com/ggerganov/llama.cpp)
- [openai-clojure](https://github.com/wkok/openai-clojure) :star: (`act`): `llm` - A wrapper of the [OpenAI API](https://platform.openai.com/docs/introduction) and [Azure OpenAI API](https://learn.microsoft.com/en-us/azure/ai-services/openai/reference)
- [openai-api](https://github.com/pmatiello/openai-api) :star: (`act`): `llm` - A wrapper of the [OpenAI API](https://platform.openai.com/docs/introduction)
- [multi-gpt](https://github.com/cjbarre/multi-gpt) :star: (`act`): `llm` - A wrapper of the Open AI GPT Chat API with conversational memory and WIP agents support
- [vald-client-clj](https://github.com/vdaas/vald-client-clj) :star: (`act`): `llm` - A gRPC client library for the [Vald](https://github.com/vdaas/vald) distributed vector database
- [chroma-clj](https://github.com/TristeFigure/chroma-clj) :star: (`act`): `llm` - An interface to the [ChromaDB](https://docs.trychroma.com/) vector database
- [clojurellm-data](https://github.com/ruped/clojurellm-data) :star: (`act`): `llm` - Dataset curation for fine tuning an LLM for Clojure

## Interop
- [Libpython-clj](https://github.com/clj-python/libpython-clj) :star: (`act`): `interop` - interop with Python
- [clj-python-trampoline](https://github.com/tristanstraub/clj-python-trampoline) :star: (`act`): `interop` - using libpython-clj from an already running python process, without needing any special python builds
- [Libjulia-clj](https://github.com/cnuernber/libjulia-clj) :star: (`act`): `interop` - Julia bindings for Clojure
- [ClojisR](https://github.com/scicloj/clojisr) :star: (`act`): `interop` - interop with R and Renjin (R on the JVM)
- [graalvm-interop](https://github.com/davidpham87/graalvm-rinterop): `interop` - interop with FastR (GraalVM's R)
- [rdata](https://github.com/appliedsciencestudio/rdata/):  - A Renjin (pure-JVM R) wrapper to allow Clojure programs to easily read R's RData file format
- [from-scala](https://github.com/t6/from-scala): `interop` - interop with Scala
- [Interop template project](https://github.com/behrica/clj-py-r-template): `interop` - A project template which configure several interop libraries automaticaly using Docker
- [other R interop libraries](https://github.com/scicloj/clojisr/blob/master/doc/existing_libraries.md)

## Parallel computing
- [claypoole](https://github.com/TheClimateCorporation/claypoole) :star: (`act`): `for`,`future`,`pmap` - threadpool-based parallel versions of Clojure functions such as `pmap`, `future`, and `for`
- [parallel](https://github.com/reborg/parallel) :star::  - parallel-enabled functions, addditional transducers and supporting utilities
- [tesser](https://github.com/aphyr/tesser) :star::  - a library for concurrent & commutative folds, including some statistical tasks and Hadoop support
- [tech.parallel](https://github.com/techascent/tech.parallel) :star: (`act`):  - parallelization and threading primitives

## Distributed computing
- [titanoboa](https://www.titanoboa.io) :star: (`act`):  - a fully distributed, highly scalable and fault tolerant workflow orchestration platform
- [onyx](http://www.onyxplatform.org/) :star::  - a library for distributed computation in the cloud
- [overseer](https://github.com/framed-data/overseer):  - a library for building and running data pipelines

## Hadoop
- [Parkour](https://github.com/damballa/parkour):  - Hadoop MapReduce in idiomatic Clojure

## Spark
- [geni](https://github.com/zero-one-group/geni) :star: (`act`): `df` - a Spark wrapper
- [sparkling](https://github.com/gorillalabs/sparkling):  - a Spark wrapper
- [flambo](https://github.com/sorenmacbeth/flambo):  - a Spark wrapper

## Stream processing
### Kafka
- [jackdaw](https://github.com/FundingCircle/jackdaw) :star: (`act`):  - a wrapper for Kafka and Kafka Streams
- [kafka.clj](https://github.com/dvlopt/kafka.clj) :star: (`act`):  - a wrapper for Kafka and Kafka Streams
- [ksml](https://github.com/cddr/ksml) :star: (`act`):  - representing kafka streams topologies as data
- [rp-jackdaw-clj](https://github.com/rentpath/rp-jackdaw-clj):  - various components for interacting with Kafka using Jackdaw