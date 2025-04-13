---
title: "Clojure in new fields - opening up"
description: ""
date: 2025-04-12
lastmod: 2025-04-13
draft: false
weight: 4
images: ["../../sci-cloj-logo-transparent.png"]
contributors: ["daslu"]
---

Around the end of November 2024, we had a couple of small [meetings](https://scicloj.github.io/blog/scicloj-scientific-papers-initial-planning-meeting/) around the presence of Clojure in academia, one of the areas where we are looking to make Clojure gradually more present.

The meetings back then did affect our actions and followup conversations at the [Clojurians Zulip Chat](/docs/community/chat/). A broader and more general process has been initiated: shifting our attention to growth -- the growth of Clojure into new fields and use cases.

In this post, we seek to clarify our current activity to help reinitiate more systematic collaboration in that direction.

As usual, it is a personal perspective. Hopefully, more people will use this blog to share their thoughts on the topic.

## TL;DR

* We are now more ready than earlier to explore the relevance of Clojure in new fields, thanks to recent progress around tooling, libraries, beginner resources, and community building.

* We propose proceeding in small steps through ad-hoc meetings, lightweight conferences, and short-term research projects.

* One space to support that is the new [macroexpand gatherings](https://scicloj.github.io/docs/community/groups/macroexpand/) series. We encourage you to mark you availability and preferences: <a class="btn btn-primary px-4 mb-2" href="https://forms.gle/6JYyCdLfwsgvV8fC7" role="button">Poll</a>.

* If you have any thoughts or ideas, <a class="btn btn-primary px-4 mb-2" href="/docs/community/contact/" role="button">Please reach out</a>.

Now, let us dive more into the details.

## Why

There are many "Why Clojure" blog posts out there, and we will not try to reproduce their arguments here.

Let us just recognize that the efforts we are discussing here are not without a reason.

Many of us face technical challenges at work, and not only in engineering work. In research, teaching, and data exploration; in academia, and elsewhere; sometimes, programming is necessary. Often, programming can bother us with complexity, conceptual obstacles, and various kinds of friction. 

Some of us believe that Clojure can offer a relief through simplicity, conceptual elegance, and lightweight exploration. Arguably, this can be relevant to anybody who has some data and is open-minded and curious to enjoy new ways of thinking. 

## Growth

In many business situations, this might not be the best time for non-mainstream engineering choices, which are percieved too risky. For this and other reasons, it is not the easiest time to work on Clojure growth.

However, that is what we are actively working on now.

The first reason is that it is necessary. Without new and diverse fields and use cases, our open-source efforts cannot be made sustainable.

The second reason is that we are ready. As discussed below, a few parts of the solution have matured enough to proceed and finally meet more diverse crowds.

We will keep looking inward and outward at the same time: creating small collaborations, helping each other, and reflecting, while reaching out to new crowds and acting more in the public sphere.

## Community, collaboration, continuity, and communication

In our coming expansion to new fields, let us recognize a few of our usual open-source challenges. Arguably, knowing them is going to be even more important now.

Scicloj is a group of people who collaborate and support each other. Throughout the years, a few hundred people have been lightly involved in various ways. However, at any given point in time, typically a few dozens are actually involved, and only a few people are active in library maintenance and essential activities.

The people involved change frequently. All of us need to stop sometimes, then return after a few weeks or months. Such pauses are often unplanned. Free time is inherently variable, and that is always felt in volunteer-based communities.

Our goals, however, are long-term. We need to maintain continuity, and see beyond those waves by embracing uncertainty.

During the last year or so, this has been especially challenging. For a mix of reasons -- global, local, and personal -- it has not been the easiest time for a few of us. Alongside the beautiful progress in libraries, tooling, and community building, many of us had to slow down and focus on life challenges. 

Our processes need to be loose enough and stable enough. It is a delicate balance. While we often collaborate tightly, we should avoid depending on each other's tasks. We need to decouple dependencies across project timelines, recognize bottlenecks and readapt. We need to communicate frequently, and use our [everyday communication](/docs/community/contact/) as a form of light touch knowledge management. We need to support each other and help each other find comfort.

Of all the above, let us repeat the importance of communication. Let us keep chatting frequently so we can be together in those fluctuations.

## Clojure in academia

One space we will address more in 2025 is academia.

Clojure is not very common in academic teaching, but throughout the years there have been some beautiful projects that used Clojure in university courses. Some well-known courses were taught by [Lee Spector](https://github.com/lspector/clojinc), [Elena Machkasova](https://personal.morris.umn.edu/~elenam/#clojure), [The University of Helsinki](https://moocfi.github.io/courses/2014/clojure/), and [Attila Egri-Nagy](https://egri-nagy.github.io/popbook/). Some of these projects are still active.

While Clojure is not commonly cited in academic papers, during the last few years we have met many researchers who are curious about Clojure. Quite a few of them actively use it. Others avoid using it as it is considered too far from the mainstream and thus difficult to communicate with colleagues.

In certain fields, Clojure is still perceived as a niche. Some of the relevant people act alone and are not so visible to each other. 

Hopefully, we can improve the situation by making communication easier, providing spaces to sync up and think, and helping the various projects, groups, and individuals become more visible.

## The November meetings

Here we share a few notes from the discussions we had in November, where a few Clojure-friendly academics met and thought together for a while.

See also the [#data-science>scicloj paper - initial meeting](https://clojurians.zulipchat.com/#narrow/channel/151924-data-science/topic/scicloj.20paper.20-.20initial.20meeting) topic thread at the [Clojurians Zulip Chat](/docs/community/chat/) and following topic threads on related topics.

Here are some observations and insights by a few of the people involved.
* We should learn from what other tech communities did when they were smaller. See the paper about Matplotlib, for example. The Tidyverse (and the publishing around it) can be a source of inspiration.
* Making Clojure **easy** is essential. For better reach to academic groups, tooling is important. Also, a cohesive stack of libraries.
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

2. **Beginner resources and workshops.** The Noj getting started [repo](https://github.com/scicloj/noj-v2-getting-started) and :movie_camera: [video](https://www.youtube.com/watch?v=vnvcKtHHMVQ) provides a welcoming way for people who know some Clojure but are new to Noj. Kira Howe's [workshop](https://bobkonf.de/2025/howe.html) at the [BobKonf 2025 conference](https://bobkonf.de/2025/) introduced Clojure for data analysis to people who are new to Clojure. We are working on additional workshops of this kind for [May 10th](https://scicloj.github.io/blog/data-analyis-with-clojure-free-workshop-may-10th-initial-survey/). Additional [tutorials](https://scicloj.github.io/clojure-data-tutorials/) are evolving too, again thanks to Carsten and others.

3. **Beginner-friendly tooling.** Our growing set of tutorials uses the [Kindly](https://scicloj.github.io/kindly/) standard for data-visualization and notebooking. In addition to the existing support in [Clay](https://scicloj.github.io/clay/), Timothy Pratley and Carsten Behring have been working on the [kindly-render](https://github.com/scicloj/kindly-render) engine, that is now almost complete and allows various Clojure tools to support the standard. They have been working with a few Clojure tool makers, and the result is that a few tools now offer decent support for Kindly visualizations (and thus Noj). A few notable examples are [Clojupyter](https://github.com/clojupyter/clojupyter), [VSCode Calva Webview](https://calva.io/flares/), and [Intellij Cursive inline HTML](https://cursive-ide.com/blog/cursive-2025.1-eap3.html). We have been also working on beginner-friendly minimal-setup modes for Clay using a live-reload feature by Ken Huang. See a few recent video demos: [#1](https://www.youtube.com/watch?v=tDz1x2d65C0), [#2](https://www.youtube.com/watch?v=gHwFCOkBb_o), [#3](https://www.youtube.com/watch?v=WiOUiHsq_dc).

4. **Meetups.** We have moved more of the Scicloj activity at the various [dev & study groups](/docs/community/groups) to the public sphere. Most recent meetups have been focusing on workflow demos and AI systems. You can follow them at the :movie_camera: [video channel](https://www.youtube.com/@SciCloj), [Clojureverse announcements](https://clojureverse.org/c/community-center/meetups-and-events/), and [Caldendar feed](https://scicloj.github.io/docs/community/events/).

5. **Conferences.** The [SciNoj Light](/docs/community/groups/scinoj-light) online conference in May 16-17 is a first attempt to explore our current conference-organizing approach. The conference is mostly a way to drive new collaborations in preceeding moths around research, writing, and speaking. We support the speakers throughout the process of proposing and preparing the talks **and* the accompanying notes. It is already safe to say that the method works, and soon we will announce the amazing list of speakers. It is not a small effort, but we have now verified that it is doable. More events will follow later this year.

6. **Communication.** The [Clojurians Zulip Chat](/docs/community/chat/) Zulip is an essential building block in both our communication and our knowledge management. We are thankful to Gert Goet who has been nurturing it throughout the years, and to the broader team of admins that has grown recently. During the last few months, we put even more care into helping people join the platform and settle in. We organized [Zulip study sessions](https://clojureverse.org/t/intro-to-the-clojurians-zulip-chat/) and discussed it [in additional meetups](https://clojureverse.org/t/visual-tools-meeting-27-workflow-demos-1-emacs-cider-vscode-calva-zulip-summary-recording/). We are gradually shifting some of our announcements and discussions to a [web-public](https://zulip.com/help/channel-permissions#web-public-channels) channel: :tada: [#scicloj-webpublic](https://clojurians.zulipchat.com/#narrow/channel/488851-scicloj-webpublic), to make things more accessible to people who we not logged in.

## How we continue

With our currently limited resources, we will have to focus on lightweight small steps in the short term.

SciNoj Light can serve as a model for following projects. We will have a few additional target dates later this year. Toward those days, people can work on small research, on writing tutorials, and preparing talks. As usual, we will work together and create spaces to conveniently brainstorm and share progress.

At the new [macroexpand gatherings](https://scicloj.github.io/docs/community/groups/macroexpand/) series, we will maintain broader discussions on Cloure's expansion to new fields. Academia, research, education, data analysis, and art, are a few of the directions we will explore. Community members will share past experiences, discuss pain points, and come up with actionable ways to collaborate.

-------

As usual, we are hoping to hear your thoughts. If you have any comments or wish to propose anything, let us talk. 
