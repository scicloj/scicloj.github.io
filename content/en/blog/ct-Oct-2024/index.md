---
title: "Clojurists Together project - Scicloj community building - October 2024 update"
description: ""
date: 2024-11-03
lastmod: 2024-11-03
draft: false
weight: 9
images: ["../../sci-cloj-logo-transparent.png"]
contributors: ["daslu"]
---

The [Clojurists Together](https://www.clojuriststogether.org/) organisation has decided [to sponsor](https://www.clojuriststogether.org/news/q3-2024-funding-announcement/) Scicloj community building for Q3 2024, as a project by Daniel Slutsky. This is the second time the project is selected this year. Here is Daniel's update for October.

Comments and ideas would help. :pray: 

# Clojurists Together update - October 2024 - Daniel Slutsky

[Scicloj](https://scicloj.github.io/) is a Clojure group developing a stack of tools and libraries for data science. Alongside the technical challenges, community building has been an essential part of its efforts since the beginning of 2019. Our current main community-oriented goal is making the existing data-science stack easy to use through the maturing of the Noj library, mentioned below. In particular, we are working on example-based documentation, easy setup, and recommended workflows for common tasks.

All these, and the tools to support them, grow organically, driven by real-world use cases.

I serve as a community organizer at Scicloj, and this project was accepted for Clojurists Together funding in 2024 Q1 & Q3. I also receive regular funding through Github Sponsors, mostly from Nubank.

In this post, I am reporting on my involvement during October 2024, as well as the proposed goals for October.

I had 57 meetings during September. Most of them were one-on-one meetings for open-source mentoring or similar contexts.

All the projects mentioned below are done in collaboration with others. I will mention at least a few of the people involved.


## October 2024 highlights

### [Scicloj open-source mentoring](https://scicloj.github.io/docs/community/groups/open-source-mentoring/)
This month, we contined working with mentees under the open-source mentoring program.
@generatem, @phronmophobic, @jeaye, and myself have been active as mentors this month. Since the program's beginning at the middle of August, 62 people have applied -- 15 of them during the last month. 39 are still actively exploring various topics, and out of them, 15 have already made important contributions.
One notable change happened during the last few months: we started working with a few mentees who are completely new to Clojure, some even to programming. This is part of Scicloj's gradual process of opening up to broader audiences.

Some of the recent experiences and insights on this project were discussed in our recent [video report](https://www.youtube.com/watch?v=STnFMpIZlkk) (2024-10-25).

### [Noj](https://scicloj.github.io/noj/)
The Noj library is the entry point to data science with Clojure, collecting a stack of relevant libraries. This month, we worked towards its release into Beta stage, which is almost complete.
At [the Zulip chat](https://scicloj.github.io/docs/community/chat/), we had quite a few insightful discussions with important feedback by community members about the scope and the organization of the project.
One of the main parts of the efforts has been into writing additional tutorials. A broad group of people are working on these, and a few promosing tutorials are currently in draft stage. See some details below in the Tutorials section.
@behrica has made additional improvements to the automation and whole workflow of Noj in Github Pages.
I worked on clarifying many details and improving the main documentation pages.

### [Tableplot](https://scicloj.github.io/tableplot/) (previously called Hanamicloth)
Towards reaching Beta stage, our acively-developed plotting library recieved a new name: Tableplot.
I continued working on extending its features, adding flexibility to the way data can be specified throughout the pipelines, and integrating [metamorph.ml](https://github.com/scicloj/metamorph.ml) to allow for a more flexible smoothing functionality, where the user can specify the model details and the design matrix.

### Composing [Fastmath](https://github.com/generateme/fastmath) with [Tablecloth](https://scicloj.github.io/tablecloth)
During this month, a few substantial design discussions took place in the Zulip chat, with quite a few community members helping with their insights. One of the important realizations was that we should integrate Fastmath (the math library) into Tablecloth (the user-friendly table-processing library). This will allow for better composability, ergonomics, and performance in various cases where data processing meets math and statistics.

### [Scittle](https://github.com/babashka/scittle) [Emmy-viewers](https://github.com/mentat-collective/emmy-viewers) plugin
Recently, @reedho has made some progress in the Scittle plugin that supports Emmy-viewers data visualizations. I was helping in testing and figuring out some of the details. This progress is expected to extend the reach of Emmy-viewers to a broader set of use cases and integrate it better into Scicloj workflows.

### [Clay](https://scicloj.github.io/clay/)
Clay, the REPL-friendly notebook and data visualation tool, recieved a few new features:
- initial Emmy-viewers support
- support for nesting of special visualization kinds
- support for live-reload on file save by @whatacold

Additionally, @a13 and I are working on improving the process of reading Clojure code, building on previous work by @timothypratley at the [read-kinds](https://github.com/scicloj/read-kinds) project.

### [Kindly-advice](https://github.com/scicloj/kindly-advice)
Kindly-advice is a small library that helps tools know how certain values should be visualized.
Following the developments with Emmy-viewers, it can now recognize these automatically, so that tools can handle them appropriately.

### tutorials
Documenting and demonstrating the use of the Scicloj stack is one of the main goals at the moment, and quite a few of us are working on various tutorials. This is often a slow process that involved introspection and discussion of the recommended ways to explain certain notions and perform certain tasks.
I was involved in writing some tutorials and in reviewing a few others.
A few of the current drafts people have been working on can already be shared:
- [intro to probability and statistics](https://mavbozo.github.io/clj-probstat-tutorial/clay/) by @mavbozo
- [intro to linear algebra with Fastmath](https://scicloj.github.io/noj/noj_book.linear_algebra_intro.html) by @radovanne
- [2d and 3d geometry with Fastmath](https://scicloj.github.io/noj/noj_book.linear_algebra_intro.html) by @radovanne
- [intro to datavis with Apache Echarts](https://scicloj.github.io/noj/noj_book.echarts) by @zuzhi and @whatacold
- [analysing Chicago bike times](https://scicloj.github.io/noj/noj_book.chicago_bike_times.html) by myself
- [Bayesian statistics with PyMC](https://scicloj.github.io/clojure-data-tutorials/projects/stats/pymc/intro.html) by myself

### Website
This month has been a usual month in terms of website maintenance.

### real-world-data group
The [real-world-data group](https://scicloj.github.io/docs/community/groups/real-world-data/) is a space for Clojure data practitioners to share their experiences. During October, the group had two meetings. We decided to share some parts of the recordings publicly:
- Oct 4th 2024 - meeting 15:
  - [Kyle Passarelli: OAuth2 with Clojure and Temporal](https://www.youtube.com/watch?v=mmOh5fYkX7Q)
  - [Adham Omram: Experience Conducting a Clojure Training](https://www.youtube.com/watch?v=G1vpz_43YpI)
- Oct 16th 2024 - meeting 16:
  - [Jarkko Saltiola: tools for pipelines, bb-glitchtip](https://www.youtube.com/watch?v=nC86hEglyLQ)

### Scicloj weekly catchup
During October, we tried the approach of weekly group meetings for the open-source-mentoring program, in addition to the small and 1-1 meetings.
We had four group meetings of this kind. A few people have shared their work, and we explored some topics as a group. Eventually, we realized that the timing and format were not optimal for most people, so this series is currently on hold.

### Linear Algebra meetings
A few of use are working on tutorials related to linear algebra and vector processing, and have started meeting weekly on these topics. We had four meetings of this kind.

### Clojure Conj
Eventually, we organized only one talk run before the Clojure Conj conference. This was an early run of the talk by Thomas Clark. The actual talk has already been published [online](https://www.youtube.com/watch?v=_D5d6Ls6pBw). It is a fantastic overview of the Clojure stack for scientific computing.
On my side, I helped a little bit in the preparations for the talk.

## November 2024 goals

### Noj
- Annouce Beta stage for Noj.
- Continue the current efforts on documenting the libraries.

### Fastmath
- Continue the documetation effort.

### Tableplot
- Annouce Beta stage after a minor changes.
- Keep extending and documenting the library.

### Tooling
- Return to the work on [kindly-render](https://github.com/scicloj/kindly-render), the tool-agnosic implementation of the [Kindly](https://scicloj.github.io/kindly/) standard.
- Explore improving the support of various tools for scientific Clojure. Most importantly: VSCode, Quarto, and Jupyter.
- Continue Clay maintenance.

