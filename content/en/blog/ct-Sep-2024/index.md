---
title: "Clojurists Together project - Scicloj community building - September 2024 update"
description: ""
date: 2024-04-30
lastmod: 2024-05-01
draft: false
weight: 10
images: ["../../sci-cloj-logo-transparent.png"]
contributors: ["daslu"]
---

The [Clojurists Together](https://www.clojuriststogether.org/) organisation has decided [to sponsor](https://www.clojuriststogether.org/news/q3-2024-funding-announcement/) Scicloj community building for Q3 2024, as a project by Daniel Slutsky. This is the second time the project is selected this year. Here is Daniel's update for September.

Comments and ideas would help. :pray: 

# Clojurists Together update - April 2024 - Daniel Slutsky

[Scicloj](https://scicloj.github.io/) is a Clojure group developing a stack of tools and libraries for data science. Alongside the technical challenges, community building has been an essential part of its efforts since the beginning of 2019. Our current main community-oriented goal is making the existing data-science stack easy to use through the maturing of the Noj library, mentioned below. In particular, we are working on example-based documentation, easy setup, and recommended workflows for common tasks.

All these, and the tools to support them, grow organically, driven by real-world use cases.

I serve as a community organizer at Scicloj, and this project was accepted for Clojurists Together funding in 2024 Q1 & Q3. I also receive regular funding from Nubank.

In this post, I am reporting on my involvement during September 2024, as well as the proposed goals for October.

I had 77 meetings during September. Most of them were one-on-one meetings for open-source mentoring or similar contexts.

All the projects mentioned below are done in collaboration with others. I will mention at least a few of the main people involved.

## September 2024 highlights

### [Scicloj open-source mentoring](https://scicloj.github.io/docs/community/groups/open-source-mentoring/)
Scicloj is providing mentoring to Clojurians who wish to get involved in open-source. This initiative began in August and has been growing rapidly in September. This program is transforming Scicloj, and I believe it will influence the Clojure community as a whole.

We are meeting so many incredible people who are typically experienced, wise, and open-minded and have not been involved in the past. Making it all work is a special challenge. We have to embrace the uncertainty of working with people of varying availability and dynamically adapt to changes in the team. Building on our years-long experience in community building and open-source collaboration, we know we can support at least some of our new friends in finding impactful paths to contribute. We are already seeing some fruits of this work and still have a lot to improve.

47 people have applied so far. 34 are still active, and 10 have already made meaningful contributions to diverse projects.

I am coordinating the process, meeting all the participants, and serving as one of the mentors alongside generateme, Kira McLean, Adrian Smith, and Jeaye Wilkerson. The primary near-term goals are writing testable tutorials and docs for the [Fastmath](https://github.com/generateme/fastmath) and [Noj](https://scicloj.github.io/noj/) libraries. Quite a few participants will be working on parts of this core effort. A few other projects where people get involved are [Clay](https://scicloj.github.io/clay/), [Kindly](https://scicloj.github.io/kindly-noted/), [Jank](https://jank-lang.org/), and [ggml.clj](https://github.com/phronmophobic/ggml.clj).

A few notable contributions were by Avicenna (mavbozo), who added a lot to the Fastmath documentation and tutorials; Jacob Windle, who added printing functionality to Fastmath regression models; Muhammad Ridho, who started working on portability of [Emmy Viewers](https://github.com/mentat-collective/emmy-viewers) data visualizations; Lin Zihao, who improved the Reagent support to the Kindly standard; Epidiah Ravachol, who worked on insightful tutorials for [dtype-next](https://github.com/cnuernber/dtype-next) array-programming; Oleh Sedletskyi, who started working on statistics tutorials; Ken Huang, who've made various contributions to Clay; and Prakash Balodi, who worked on [Tablecloth](https://scicloj.github.io/tablecloth/) issues and started organizing the Scicloj weekly group (see below).

### [Noj](https://scicloj.github.io/noj/)
Noj is an entry point to data and science. It integrates a set of underlying libraries through a set of testable tutorials.
- Carsten Behring made important changes in adding integration tests and automating the dev workflow.
- I helped in gradually adapting and testing a few of the underlying libraries.
- I helped initiate a few documentation chapters that are being written by new community members.

### [Kindly](https://scicloj.github.io/kindly-noted/)
Kindly is the standard of data visualizations used by Scicloj tutorials and docs.
- Timothy Pratley has improved the way the user controls various options.
- I helped test and integrate the new features.
- We collaborated in creating a kindly-dev team, and a few of the new friends have started contributing to the stack of libraries around Kindly.

### [Kinldy-render](https://github.com/scicloj/kindly-render)
Kindly-render is a general rendering library which serves as a foundation for tools to support Kindly.
- Timothy Pratley has reinitiating this project.
- I joined in design discussions and testing.

### [Clay](https://scicloj.github.io/clay/)
Clay is a REPL-friendly tool for data visualization and literate programming.
- I worked on two new release versions. Each was a combination of bugfixes and feature requests.

### [real-world-data group](https://scicloj.github.io/docs/community/groups/real-world-data/)
The real-world-data group is a space for people to share updates on their data projects at work.

Meeting #13 was dedicated to talk runs and discussions preceding the Heart of Clojure conference.

Meeting #14 was an interactive coding session of a data science tutorial.

### Scicloj weekly
Together with Prakash Balodi, we initiated a new weekly meeting for new community members working on open-source projects.

Intentionally, we use a time slot which is more friendly to East and Central Asia time zone, unlike most Clojure meetups.

We have had three meetings so far, with 4, 15, and 6 participants.

### linear algebra meetings
We organized a new group that will collaborate on implementing and teaching applied linear algebra algorithms in Clojure.

The first meeting actually took place in October 2nd, so we will update more in the next month.

### [Heart of Clojure](https://2024.heartofclojure.eu/)
Sami Kallinen represented Scicloj at Heart of Clojure with an incredbible [talk about data modelling](https://2024.heartofclojure.eu/talks/sailing-with-scicloj-a-bayesian-adventure/).

I collaborated with Sami on preparing the talk and improving the relevant tools and libraries to support the process.

## October 2024 goals

This is the tentative plan. Comments and ideas would be welcome.

### Noj and Fastmath
- Both these libraries will recieve lots of attention in the form of (testable) tutorials and docs. I will be working with a few people on vairous chapters of that effort.
- We will keep working on stabilizing the set of libraries behind Noj and improving the integration tests.

### Open-source mentoring
We are expecting more participants to join.
- I will keep working on supporting participants in new beginnings and ongoing projects.

### [Hanamicloth](https://scicloj.github.io/hanamicloth/)
Hanamicloth is a layered grammar of graphics library.
- The goal for the coming few weeks is to bring it to beta stage and mostly improve the documentation.

### Tooling
- We will keep working on maturing kindly-render and refactoring Clay to use it internally.
- Clay will be in active development for code quality, bugixes, and user requests.

### Clojure Conj
The coming [Clojure Conj](https://2024.clojure-conj.org/) conference will feature a few Scicloj-related talks. At Scicloj, we have a habit of helping each other in talk preparations. We will do that as much as the speakers will find it helpful. We will also organize a couple more pre-conference meetings with speakers, as we did in August.
