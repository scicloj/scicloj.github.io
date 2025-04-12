---
title: "Opening up - Clojure in new fields"
description: ""
date: 2025-04-12
lastmod: 2025-04-13
draft: false
weight: 4
images: ["../../sci-cloj-logo-transparent.png"]
contributors: ["daslu"]
---

Around the end of November 2024, we had a couple of small [meetings](https://scicloj.github.io/blog/scicloj-scientific-papers-initial-planning-meeting/) around the presence of Clojure in academia, one of the areas where we are looking to make Clojure gradually mode present

The meetings back then did affect our actions and followup conversations at the [Clojurians Zulip Chat](/docs/community/chat/), but for various reasons, we have not been maintaining broader continuous communucation on the topic.

The goal of this post is to clarify our current activity in this area and help reinitiate more systematic collaboration.

## TL;DR

* We are now more ready than earlier to explore the relevance of Clojure in academia, thanks to recent progress around tooling, libraries, beginner resources, and community building.

* We propose proceeding in small steps through ad-hoc meetings, lightweight conferences, and short-term research projects.

* One space to support that is the new [macroexpand gatherings](https://scicloj.github.io/docs/community/groups/macroexpand/) series. We encourage you to mark you availability and preferences: <a class="btn btn-primary px-4 mb-2" href="https://forms.gle/6JYyCdLfwsgvV8fC7" role="button">Poll</a>.

* If you have any thoughts or ideas, <a class="btn btn-primary px-4 mb-2" href="/docs/community/contact/" role="button">Please reach out</a>.

Now, let us dive more into the details.

## Why

There are many "Why Clojure" blog posts out there, and we will not try to reproduce their arguments here.

Let us just recognize that the serious efforts we are discussing here are not without a reason. 

Many of us face various technical challenges in our research or teaching work, in academia and elsewhere. Sometimes, programming is necessary. Often, programming can bother us with complexity, conceptual obstacles, and various kinds of friction. Some of us hope for a relief through simplicity, conceptual elegance, and lightweight exploration. 

Some of us believe this can be achieved with Clojure, and this justifies our efforts here.

## Clojure in academia

Clojure is not very common in academic teaching, but throughout the years there have been some beautiful projects that used Clojure in university courses. Some well-known courses were taught by [Lee Spector](https://github.com/lspector/clojinc), [Elena Machkasova](https://personal.morris.umn.edu/~elenam/#clojure), [The University of Helsinki](https://moocfi.github.io/courses/2014/clojure/), and [Attila Egri-Nagy](https://egri-nagy.github.io/popbook/). Some of these projects are still active.

While Clojure is not commonly cited in academic papers, during the last few years we have met many researchers who are curious about Clojure's relevance to their work. Quite a few of them actively use it. Others avoid using it as it is considered too far from the mainstream and thus difficult to communicate with colleagues.

This is a bootstrap problem. In certain fields, Clojure is still perceived as a niche. Some of the relevant people act alone and are not so visible to each other. 

Arguably, we can improve the situation a lot by making communication easier, providing spaces to sync up and think, and making the various projects, groups, and individuals more visible.

## Community, continuity, and communication

In our coming expansion to new fields, let us recognize a few of our usual open-source challenges. Arguably, knowing them is going to be even more important now.

Scicloj is a group of people who collaborate and support each other. Throughout the years, a few hundred people have been involved in various ways, but at any given point in time, typically a few dozens are actually involved, and only a few are active in library maintenance and essential activities.

The group of people involved changes frequently. All of us need to stop sometimes, then return after a few weeks or months. Such pauses are often unplanned. Free time is inherently variable, and that is always felt in volunteer-based communities.

Our goals, however, are long-term. We need to maintain continuity and see beyond those waves. 

During the last year or so, this has been especially challenging. For a mix of reasons -- global, local, and personal -- this has not been the easiest time for a few of us. Alongside the beautiful progress in libraries, tooling, and community building, many of us had to slow down and focus on life challenges. 

Whatever we have manage to do in the past, present, and future, is based on embracing this uncertainty. 

Our processes need to be loose enough and stable enough. It is a delicate balance. We need to decouple dependencies across projects, recognize bottlenecks and readapt. We need to communicate frequently, and use our [everyday communication](/docs/community/contact/) as a form of lightweight knowledge management. We need to support each other and help each other find comfort.

Of all the above, let us repeat the importance of communication. This is a recommendation and a request of anybody involved: let us keep chatting frequently so we can be together in those fluctuations.

## The November meetings

Here we share a few notes from the discussions we had in November, where a few Clojure-friendly academics could meet and think together for a while.

See also the [#data-science>scicloj paper - initial meeting](https://clojurians.zulipchat.com/#narrow/channel/151924-data-science/topic/scicloj.20paper.20-.20initial.20meeting) topic thread at the [Clojurians Zulip Chat](/docs/community/chat/) and following topic threads on related topics.

Here are some observations and insights by a few of the people involved.
* We should learn from what other language community did when they were smaller. See the paper about Matplotlib, for example. The Tidyverse (and the publishing around it) can be a source of inspiration.
* Making Clojure **easy** is essential. For better reach to academic groups, tooling is important (Jupyter? Jupyter alternatives? etc.). Also, a cohesive stack of libraries.
* Possible technical aspects of the Clojure ecosystem stack could be documented in the form of academic papers: extending the grammar of graphics, nontrivial interop solutions, and perspectives on the history of Lisp in AI are some examples.
* At some point, we may initiate new implementation projects on certain topics that look promising nowadays. Two possible examples are Applied Category Theory and Topological Data Analysis.
* Alongside (1) technical aspects and (2) applications, a third type of academic writing can be: (3) uses in education.
* Finding reviewers for a Clojure paper might be a challenge. At some point, we may try to assemble a list of potential reviewers.
* Conference talks are a quicker and easier path than papers. We can organize our own online conferences. Our own conference proceedings would take more effort (and will mainly need a decent group of reviewers).
* Applications of Clojure in education (point (3) above) -- this path seems to be in consensus as a preferred and accessible way to make Clojure visible in academia. A few of the people involved have been putting lots of thought into teaching Clojure for years.
* We need to create more visible spaces to share and discuss these observations and insights.

## Relevant progress

Recently, we have had some progress in a few relevant directions.

1. **A cohesive stack of libraries.** The [Noj](https://scicloj.github.io/noj/) toolkit for data science has been maturing. Its documentation and integration tests have received quite a few contributions by Carsten Behring and a few other contributors. 
2. **Beginner resources and workshops.** The Noj getting started [repo](https://github.com/scicloj/noj-v2-getting-started) and :movie_camera: [video](https://www.youtube.com/watch?v=vnvcKtHHMVQ) provides a welcoming way for people who know some Clojure but are new to Noj. Kira Howe's [workshop](https://bobkonf.de/2025/howe.html) at the [BobKonf 2025 conference](https://bobkonf.de/2025/) introduced Clojure for data analysis to people who are new to Clojure. We are working on additional workshops of this kind for [May 10th](https://scicloj.github.io/blog/data-analyis-with-clojure-free-workshop-may-10th-initial-survey/).
3. **Beginner-friendly tooling.** Our growing set of tutorials uses the [Kidnly](https://scicloj.github.io/kindly/) standard for data-visualization and notebooking. In addition to the existing support in [Clay](https://scicloj.github.io/clay/), Timothy Pratley and Carsten Behring have been working on the [kindly-render](https://github.com/scicloj/kindly-render) engine, that is now almost complete and allows various Clojure tools to support the standard. They have been working with a few Clojure tool makers, and the result is that a few tools now offer decent support for Kindly visualizations (and thus Noj). A few notable examples are [Clojupyter](https://github.com/clojupyter/clojupyter), [VSCode Calva Webview](https://calva.io/flares/), and [Intellij Cursive inline HTML](https://cursive-ide.com/blog/cursive-2025.1-eap3.html). We have been also working on beginner-friendly minimal-setup modes for Clay using a live-reload feature by Ken Huang. See a few recent video demos: [#1](https://www.youtube.com/watch?v=tDz1x2d65C0), [#2](https://www.youtube.com/watch?v=gHwFCOkBb_o), [#3](https://www.youtube.com/watch?v=WiOUiHsq_dc).
4. **Meetups.** We have moved more of the Scicloj activity at the various [dev & study groups](/docs/community/groups) to the public sphere. Most recent meetups have been focusing on workflow demos and AI systems. You can follow them at the :movie_camera: [video channel](https://www.youtube.com/@SciCloj), [Clojureverse announcements](https://clojureverse.org/c/community-center/meetups-and-events/), and [Caldendar feed](https://scicloj.github.io/docs/community/events/).
5. **Conferences.** The [SciNoj Light](/docs/community/groups/scinoj-light) online conference in May 16-17 is a first attempt to explore our current conference-organizing approach. We use the conference mostly to drive new collaborations around research, writing, speaking, and we support the speakers throughout the process of proposing and preparing the talks. It is already safe to say that the method works, and soon we will announce the amazing list of speakers. More events will follow later this year.

## How we continue

5. gatherings
- meetups

