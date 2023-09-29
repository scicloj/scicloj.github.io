---
title: "Following our first five LLM meetups"
description: ""
date: 2023-09-29
lastmod: 2023-09-29
draft: false
weight: 20
images: []
contributors: ["daslu"]
---

In May 2023, Scicloj started organizing [a series of meetups](https://scicloj.github.io/docs/community/groups/llm-meetups/) around Large Language Models.

This series was inpired by a few other projects in the Clojure community, such as Rupert's [initiative](https://github.com/ruped?tab=repositories) to work on models that may work well with Clojure language tasks, the related `#clojurellm` channel that was created by John Newman and Rupert, and [the various libraries](https://scicloj.github.io/docs/resources/libs/#large-language-models-and-related-services) for LLMs and related services, that have been keep emerging mostly during 2023.

This post discusses the journey of the meetups so far, mostly the panel we had in the fifth meetup. It also anticipates some of the coming meetups in the near future.

## The first 4 meetups

Meetups 1,2,3 were a collaboration of Martynas Maciulevičius, Irfan Nurhadi Satria, Žygimantas Medelis, and Daniel Slutsky, who prepared a few topics in coordination. 

[Meetup 1](https://clojureverse.org/t/scicloj-llm-meetup-1-introduction-summary-recording/) :movie_camera: was an introductory overview to LLMs, some of the underlying algorithms, and the state of the ecosystem. On that meetup, we also had a very long unrecorded discussion on the state of the Clojure ecosystem, mostly driven by John Newman's ideas and comments.

[Meetup 2](https://clojureverse.org/t/scicloj-llm-meetup-2-prompt-engineering-managing-embeddings-summary-recording/) :movie_camera: focused on common methods of using LLMs, mostly prompt engineering and storing emeddings.

[Meetup 3](https://clojureverse.org/t/scicloj-llm-meetup-3-llmops-with-bosquet-summary-recording/) :movie_camera: presented the field of LLMOps tools, and especially the [Bosquet](https://github.com/zmedelis/bosquet) library, which connects a few of the relevant services together in a Clojury way. Bosquet has evolved since then. More on that -- below.

Then, on [Meetup 4](https://www.youtube.com/watch?v=_m-Rcz_jTGo) :movie_camera:, Dimid Dochovny added another introduction to the field of LLMs, similar to meeting 1 and with a little more focus on the history of the field.

## The 5th meetup

On September 24th we had [Meetup 5](https://www.youtube.com/watch?v=CDLao9KDduU) :movie_camera: which was different. Following the Scicloj experience in the [visual-tools group](https://scicloj.github.io/docs/community/groups/visual-tools/) and [on other occasions](https://www.youtube.com/playlist?list=PLtw0bWXdq7pNyb2NojSGBnCARRuvLxsAc), we find it enlightening to meet a panel of speakers who are active in the field, sharing the state of their projects through short presentations and discussions.

On this meeting, we had presentations and discussions with five of the people who have been active creating Clojure LLM libraries.

Daniel Szmulewicz briefly presented the [Clojure Cohere SDK](https://github.com/danielsz/cohere-clojure) and mostly talked about related use cases.

Arian Smith presented [llama.clj](https://github.com/phronmophobic/llama.clj), a Clojure wrapper of [llamma.cpp](https://github.com/ggerganov/llama.cpp) through [clong](https://github.com/phronmophobic/clong), and demonstrated how it can be used to run models locally while enjoying Clojure's idioms and simplicity.

Cameron Barre talked about [multi-gpt](https://github.com/cjbarre/multi-gpt), an interface around the GPT language model with additional layers of conversational memory and (WIP) task management. 

Rupert gave an overview of the state of the [Clojure LLM](https://github.com/ruped/clojurellm-data) project -- creating an infrastructure for models and systems to work well with the Clojure language -- and the emerging `#clojurellm` community on the Clojurians Slack.

Žygimantas gave an update on [Bosquet](https://github.com/zmedelis/bosquet), which was recently selected for [Clojurists Together](https://www.clojuriststogether.org/) funding. Bosquet's focus has been clarifying, and now it is mostly about creating [agents](https://en.wikipedia.org/wiki/Large_language_model#Agency) in an opinionated composition of curated libraries and services.

The talks by Žygimantas and Cameron had some ideas in common, mostly about the direction of agent creation, and the ways this can be done using Clojure idioms and libraries. Cameron proposed the The [Generative Agents paper](https://arxiv.org/abs/2304.03442) as an inspiring example experimenting with agent systems. Žygimantas proposed to share this [short intro](https://www.youtube.com/watch?v=3fge-zqZezw) intro by Harisson Chase, clarifying why and how memory is important in LLM applications.

After the recorded part, we had a long discussion. Among other things, we had a further dive into llama.clj's implementation and usage, and discussed possible research directions, and future topics for meetups.

## The next times

Following the discussion, here are our tentative plans for the coming meetups:

Rupert proposed a different format, focusing mostly on discussions rather than presentations. Probably, we will soon organize such a meetup. 

A few of the projects that were discussed briefly, will have their own dedicated meetups for a deeper dive. Currently, we are planning such meetups about Bosquet and llama.clj.

We will have another meetup full of short talks, but rather than focusing on libraries, it will focus on the use of models: applications, experiments, and research. There are already a few candidate topics, such as the [clj chatbot ui](https://github.com/groundedsage/clj-chatbot-ui).

One topic which is left out of this series is the concerns regarding LLMs' effect on society. A few of us find it important to address such implications, and this direction was discussed at the Scicloj organizing team. It was decided that such topics would rather be left out of Scicloj's scope, as Scicloj is a technical group. As indivduals, however, a few of us will hopefully act elsewhere in the community to explore and discussthe broader picture. 

## Epilogue

A few of the recent talks demonstrated how functional composition, simplicity, and lightweight data modeling are relevant and refreshing in the field of Large Language Models. Yet again, Clojure seems to be really shining in offering playful and daynamic ways to explore sophisticated ideas and systems.

Community collaboration is essential in creating such composable stories, and the `#clojurellm` have been fruitful in that. The Scicloj group is trying to help a bit here, and so far we have had a few pleasant experiences discussing things together. A few of the projects mentioned here are explicitly looking for contributions, and our hope is that future meetups will encourage that and help in making it accessible.
 

