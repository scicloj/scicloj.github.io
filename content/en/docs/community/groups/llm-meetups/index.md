---
title : "scicloj-llm-meetups: public meetings exploring the princples and use of large language models"
description: "Scicloj LLM meetups"
lead: ""
date: 2022-05-23
lastmod: 2023-06-21
draft: false
images: []
---

![gpt pretending to be joyful](joy.jpg)

The goal of this series of meetups is to support our learning, as a community, of the new landscape of ideas around large language models.

Some of the content here is specific to the Clojure ecosystem (e.g., discussing the use of LLMs from Clojure), but many parts of it could be helpful and interesting to broader audiences.

## Meetings
Most meetings will be recorded and shared publicly (:movie_camera: [Playlist](https://www.youtube.com/watch?v=sap3Z-LpNjY&list=PLb_VRZPxjMADf8-NcCfMzp6mq8N2xwhem)).

* #1 2023-05-26, Intro to LLMs - :movie_camera: [summary & recording](https://clojureverse.org/t/scicloj-llm-meetup-1-introduction-summary-recording/10098)
  * Martynas Maciulevičius provided an overview of the topic, introducing a few of the basic ideas behind LLM.

* #2 2023-06-16, Intro to prompt engineering - :movie_camera: [summary & recording](https://clojureverse.org/t/scicloj-llm-meetup-2-prompt-engineering-managing-embeddings-summary-recording/)
  * Irfan Nurhadi Satria demonstrated some of the common methods of prompt engineering from Clojure.
  * Daniel Slutsky added a brief introduction to the use of embeddings and vector databases.

* #3 2023-06-17, LLMOps with [Bosquet](https://github.com/zmedelis/bosquet) - :movie_camera: [summary & recording](https://clojureverse.org/t/scicloj-llm-meetup-3-llmops-with-bosquet-summary-recording/)
  * Žygimantas Medelis discussed the currently emerging tooling ecosystem and then presented Bosquet, dived in a bit into its internals (e.g., the use of Slemer and Pathom), and discussed future directions.

* #4 2023-07-14, Architectures and ideas behind transformer-based generative LLMs - :movie_camera: [recording](https://www.youtube.com/watch?v=_m-Rcz_jTGo)
  * Dimid Duchovny briefly overviewed the history of LLM models and explained some of the core ideas behind them..
  * Then, he demisntrated using LLMs locally from Python, as well as through the OpenAI API.

* #5 2023-09-24, Library overviews and selected discussions - :movie_camera: [recording](https://www.youtube.com/watch?v=CDLao9KDduU) (summary coming soon)
  * Projects on the agenda:
    * Clojure LLM Project Update
    * [multi-gpt](https://github.com/cjbarre/multi-gpt)
    * [Cohere Clojure SDK](https://github.com/danielsz/cohere-clojure)
    * [llama.clj](https://github.com/phronmophobic/llama.clj)
    * [Bosquet](https://github.com/zmedelis/bosquet) updates

* Upcoming meetups:
  * Selected discussion topics
  * Use cases and experiments -- short talks
  * Bosquet deep-dive
  * llamma.clj deep-dive

## Playlist



## Clojure activity around LLMs
Here we list a few exciting projects that various Clojure groups and individuals have been working on.

* At the [#clojurellm](https://clojurians.slack.com/archives/C054XC5JVDZ) channel in the Clojurians Slack, a group of Clojurians is working on helping LLMs understand Clojure. This channel has been very active in sharing various relevant updates about the LLMs landscape.
* [Ryan Robitaille](https://twitter.com/ryrobes) has been sharing experiments connecting LLMs to dataflow UIs (Rabbit Remix).
* Matthew Downey has created [rendergpt](https://github.com/matthewdowney/rendergpt), a Chrome extension for rendering structured output from ChatGPT interactively.

## Related past meetups

* Use of LLMs
  * 2023-04-01, [a short demo](https://www.youtube.com/watch?v=OwcoAbsJP8g&t=3095) in [meeting 17](https://clojureverse.org/t/visual-tools-meeting-17-various-updates-summary-recording/9928) of the [visual-tools group](https://scicloj.github.io/docs/community/groups/visual-tools/)
     * Matthew Downey presented [rendergpt](https://github.com/matthewdowney/rendergpt).
* NLP (not LLMs)
  * 2022-09-10, NLP study session 1 - :movie_camera: [summary & video](https://clojureverse.org/t/nlp-in-clojure-session-1-summary-recording/)
    * Dimid Duchovny gave an intro to Linguistics.
    * Daniel Slutsky demosntrated using [spaCy](https://spacy.io/) from Clojure for text classification.
    * Carsten Behring added some comments about the broader picture of interop and machine learning in Clojure.
  * 2022-10-30, NLP study session 2: Predict real vs. fake disaster tweets with DVC, Clojure and Python - :video: :movie_camera: [summary & video](https://clojureverse.org/t/nlp-in-clojure-session-2-summary-recording-clojure-python-dvc-metamorph/)
    * João Santiago gave a short intro intro to [DVC](https://dvc.org/).
    * Carsten Behring demonstrated of a real-world NLP pipeine and discussed some promising directions in building machine-learning pipelines with DVC, Clojure, Python, and [Metamorph](https://github.com/scicloj/metamorph) / [scicloj.ml](https://github.com/scicloj/scicloj.ml).

