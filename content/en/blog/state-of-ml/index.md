---
title: "The Current State of ML in Clojure"
description: ""
date: 2024-04-04
lastmod: 2024-04-15
draft: false
weight: 17
images: []
contributors: ["Kira McLean"]
---

This is a cross-post of [a recent post](https://codewithkira.com/2024-04-04-state-of-clojure-ml.html) by Kira McLean at [her blog](https://codewithkira.com/), that has encouraged a few discussions over the web.

--------------------

Recently, a few of us at Scicloj have had enlightening discussions of of current state of the machine learning landscape in Clojure. This post is my attempt to distill it into a summary for the community's benefit, so more people can understand where things are at and what the active developers in this space are working on.

It's no secret I love Clojure and especially working with data in Clojure, but it's fair to say that the Clojure for data science ecosystem is not anywhere near as easy to use or understand as reasonable potential users might expect. This is the main problem I'm focusing on this year, and there is significant effort being put into refining our tools to make them more accessible to a wider audience.

There are already people doing "real" machine learning work in Clojure, though, and below is an overview of what the current state of our libraries and tools are in that area, as of April 2024.

_Update: It's worth mentioning that deep learning and LLM libraries have been intentionally left out of this post in order to keep it a "reasonable" length. There is enough separate work happening in that space that it warrants its own, separate overview._

## Summary

There are a lot of links in this post. This table is an attempt to aggregate and summarize them. There are more details worth reading below, but in case you don't have time, this is the gist of it. To make a very long story short, current efforts are heavily focused on consolidating all of these amazing libraries into one (or at least a small number of clearly delineated ones) that is/are easy-to-use, providing a comphrehensive toolkit for doing machine learning in Clojure.

| Category | Library | Description | License |
| --- | --- | --- | --- |
| **Java ML Libraries** | [Tribuo](https://tribuo.org/) | A comprehensive Java ML framework, preferred library for ML workflows | Apache 2.0 |
|  | [Smile 2.x](https://github.com/haifengl/smile) | Currently being phased out of main Clojure ML libraries | LGPL |
|  | [Smile 3.x](https://github.com/haifengl/smile) | Avoided due to licensing | GPL |
|  | [XGBoost for JVM](https://xgboost.readthedocs.io/en/stable/jvm/index.html) | Implements gradient boosting algorithms, can be used through Tribuo | Apache 2.0 |
| **Clojure Wrappers** | [fastmath 2.4.0+](https://github.com/generateme/fastmath) | Clojure ML/stats library, dependency on Smile 2.x | MIT |
|  | [fastmath 3.x](https://github.com/generateme/fastmath) | Fastmath with no Smile dependency | MIT |
|  | [fastmath-clustering](https://github.com/generateme/fastmath-clustering) | Fastmath wrapper around Smile clustering, dependency on Smile 2.x | EPL-2.0 |
|  | [scicloj.ml.tribuo](https://github.com/scicloj/scicloj.ml.tribuo) | Clojure wrapper for Tribuo, likely to become the main source for ML algorithms | EPL-1.0 |
|  | [scicloj.ml.smile](https://github.com/scicloj/scicloj.ml.smile) | Clojure wrapper for more of Smile (than fastmath), likely to be deprecated due to licensing | EPL-2.0 |
|  | [scicloj.ml.xgboost](https://github.com/scicloj/scicloj.ml.xgboost) | Clojure wrapper for XGBoost directly | EPL-1.0 |
| | [tech.ml.dataset](https://github.com/techascent/tech.ml.dataset) | Core dataframe/dataset library in Clojure, incorporates some Tribuo functionality | EPL-1.0 |
| | [tech.ml](https://github.com/techascent/tech.ml) | Early Clojure ML library, superceded by various scicloj.ml libraries | EPL-1.0 |
| **Clojure ML Pipelines** | [metamorph](https://github.com/scicloj/metamorph) | Clojure function composition library | EPL-2.0 |
|  | [metamorph.ml](https://github.com/scicloj/metamorph.ml) | Clojure library for composing ML pipelines based on metamorph | EPL-2.0 |
| **Collections/Frameworks** | [scicloj.ml](https://github.com/scicloj/scicloj.ml) | Collection of Clojure ML libraries and documentation, being deprecated in favour of noj | EPL-2.0 |
|  | [noj](https://github.com/scicloj/noj) | **Consolidated Clojure data science toolkit, likely to become the main, unified entry-point for Clojure's data science stack** | EPL-1.0 |
| **Interop** | [libpython-clj](https://github.com/cnuernber/libpython-clj) | Python bindings for Clojure, enabling use of Python code and libraries directly from Clojure | EPL-2.0 |
|  | [sklearn-clj](https://github.com/scicloj/sklearn-clj) | Utilizes libpython-clj for access to scikit-learn estimators and models from Clojure | EPL-1.0 |
|  | [clojisr](https://github.com/scicloj/clojisr) | Bridge from Clojure to R, less relevance for ML compared to Python interop | EPL-2.0 |

In addition to all of these libraries, the post mentions the [Clojurians Zulip](https://scicloj.github.io/docs/community/chat/), the main Clojure-for-data-science community discussion forum, where main contributors to the ecosystem are active daily.

## Java ML Libraries

There are two (sort of four) popular Java libraries that implement many of the main algorithms and tools used in machine learning today (e.g. classification, regression, clustering, model development, etc.): [Tribuo](https://tribuo.org/) (including XGBoost, more on that in a second) and [Smile](https://haifengl.github.io/). We count Smile as two libraries because Smile 2.x is LGPL-licensed, and Smile 3.x is GPL-licensed, which poses some potential conflicts for some end users. The community consensus is converging around moving away from Smile due to the GPL-relicensing issue, focusing instead on Tribuo and hand-rolled solutions.

There is also [XGBoost](https://xgboost.readthedocs.io/en/stable/jvm/index.html) for the JVM, mentioned above, which is an implementation of gradient boosting. XGBoost is a collection of algorithms whereas Tribuo is a more comprehensive framework (including things like data management, model evaluation, and experiment tracking). XGBoost can be used from Tribuo, so I don't exactly count it as a standalone library, although it can also be used in that way.

## Clojure wrappers

There are two main "families" of libraries that wrap these Java ML libraries in Clojure.

[Fastmath](https://github.com/generateme/fastmath) includes statistical as well as machine learning tools for Clojure. Fastmath 2.4.0+ depends on Smile 2, and the forthcoming fastmath 3.x will have no Smile dependency at all. The clustering functionality in fastmath 2.x that depended on smile has been moved to the [fastmath-clustering](https://github.com/generateme/fastmath-clustering) library, which will have a Smile 2.x dependency going forward. There is a strong preference in the community to avoid introducing GPL-licensed libraries into the ecosystem.

Clustering functionality will mostly be provided by [scicloj.ml.tribuo](https://github.com/scicloj/scicloj.ml.tribuo) going forward which, as you might expect, wraps the Tribuo Java library, and is likely to become the main source of ML algorithms for the ecosystem. This is one of a few libraries in the second family of libraries that wrap the Java libraries mentioned above. Other (self-explanatory) ones include [scicloj.ml.smile](https://github.com/scicloj/scicloj.ml.smile), which wraps more of Smile than fastmath did (does), and [scicloj.ml.xgboost](https://github.com/scicloj/scicloj.ml.xgboost).

It's also worth mentioning [tech.ml.dataset](https://github.com/techascent/tech.ml.dataset) (the core dataframe/dataset library underlying tablecloth), which [incorporates some of the functionality of tribuo](https://github.com/techascent/tech.ml.dataset/blob/master/src/tech/v3/libs/tribuo.clj), with the API centred around individual datasets. There also used to be a library called [tech.ml](https://github.com/techascent/tech.ml), which implements some machine learning tools, but has been deprecated in favour of the various libraries discussed above.

The concept of orienting an API around individual datasets vs something else leads me to the next group of libraries. 

## Clojure ML Pipelines

[Metamorph](https://github.com/scicloj/metamorph) is a library that implements a function composition mechanism for composing ML pipelines. It arises from the common ML practice of repeatedly running the same set of functions with varied parameters. You might, for example, try many different test/train splits to see how that affects your results, or fit the same data using many different algorithms, or try training your model using different sets of features. This leads to an explosion of pipeline combinations, so it's useful to have machinery to encapsulate the variable components of your ML pipeline into a single function. This is where metamorph.ml comes in. 

[Metamorph.ml](https://github.com/scicloj/metamorph.ml) is based on this concept of meta-functions and pipelines. It is currently the central library for orchestrating ML pipelines in Clojure. The API is stable, but there are currently [many ways (10+)](https://clojurians.zulipchat.com/#narrow/stream/321125-noj-dev/topic/ols.20interaction.20tutorial/near/422408507) to achieve the same outcomes. This is great for power users who have complex needs and a clear understanding of the metamorph mental model, but it can be a bit daunting for newcomers, making it more challenging to pick a clear place to start. The community is actively discussing the best approach for consolidating and/or documenting these different approaches in the interest of making Clojure's ML stack more accessible.

## Collections/Frameworks

The community is well aware that it is difficult to know where to get started and several efforts have been made in an attempt to make the path more clear for people who want tools that Just Work. [scicloj.ml](https://github.com/scicloj/scicloj.ml) is one such project. It's a collection of libraries (mostly the ones mentioned above) with some lightweight wrappers and efforts in creating documentation.

The community is heading toward deprecating this library, though, in favour of [noj](https://github.com/scicloj/noj), which we are hoping to stabilize in the near future. The goal is to have a single entry-point into the Clojure data science stack, gathering all the tools one would need to work with data consolidated in one place, with seamless interoperability akin to R's tidyverse of libraries.

## Interop

It wouldn't be a complete roundup of the state of ML in Clojure without a mention of [libpython-clj](https://github.com/clj-python/libpython-clj). This is a library that provides Python bindings for Clojure, so you can call Python code directly from Clojure if necessary. [sklearn-clj](https://github.com/scicloj/sklearn-clj) makes use of this bridge to provide direct access to all of the estimators and models from Python [scikit-learn](https://scikit-learn.org/) in Clojure, so for cases where something is truly only available in Python, we can still access it.

It's worth also briefly mentioning [clojisr](https://github.com/scicloj/clojisr) here, which is a similar kind of bridge from Clojure to R (and there exist libraries for Julia and Wolframite, too), but these are all less relevant for the specific area of ML, where Python is the overwhelmingly most popular current tool of choice.

## More updates

These discussions all happen in the open, on the [Clojurian's Zulip instance](https://scicloj.github.io/docs/community/chat/), which has become the main gathering place of the Clojure-for-data-science community. The `#data-science` and `#noj-dev` streams are the most active on these topics at the time of this writing. You can follow along with developments in the trenches over there, or follow the key libraries on github for updates ([scicloj.ml.tribuo](https://github.com/scicloj/scicloj.ml.tribuo), [metamorph.ml](https://github.com/scicloj/metamorph.ml), [noj](https://github.com/scicloj/noj)). I will also post periodic updates here and all the other corners of the internet where I lurk. Thank you for reading!

**Discuss this post on [Hacker News](https://news.ycombinator.com/item?id=39947045) or [Reddit](https://www.reddit.com/r/Clojure/comments/1bxamkm/clojure_for_ml_update/)**
