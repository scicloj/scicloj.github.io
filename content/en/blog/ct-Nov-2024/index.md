---
title: "Clojurists Together project - Scicloj community building - November 2024 update"
description: ""
date: 2024-12-18
lastmod: 2024-12-19
draft: false
weight: 6
images: ["../../sci-cloj-logo-transparent.png"]
contributors: ["daslu"]
---


The [Clojurists Together](https://www.clojuriststogether.org/) organization has decided [to sponsor](https://www.clojuriststogether.org/news/q3-2024-funding-announcement/) Scicloj community building for Q3 2024, as a project by Daniel Slutsky. This is the second time the project has been selected this year. Here is Daniel's last update for this period.

This overview of November's work is extended by a few recent updates from the first half of December.

Comments and ideas would help. :pray: 

# Clojurists Together update - November 2024 - Daniel Slutsky

[Scicloj](https://scicloj.github.io/) is a Clojure group developing a stack of tools and libraries for data science. Alongside the technical challenges, community building has been an essential part of its efforts since the beginning of 2019. Our current main community-oriented goal is making the existing data science stack easy to use through the maturing of the Noj library, mentioned below. In particular, we are working on example-based documentation, easy setup, and recommended workflows for common tasks.

All these, and the tools to support them, grow organically, driven by real-world use cases.

I serve as a community organizer at Scicloj, and this project was accepted for Clojurists Together funding in 2024 Q1 & Q3. I also receive regular funding through Github Sponsors, mostly from Nubank.

As some parts of November's work have only matured during the beginning of December, I am writing this report a couple of weeks late. It overviews my involvement during November, the first half of December, and then comments about the proposed directions for the near future.

I had 31 meetings during November and 25 meetings during the first half of December. Most of them were one-on-one meetings for open-source mentoring or similar contexts.

All the projects mentioned below are done in collaboration with others. I will mention at least a few of the people involved.

## November 2024 and early December highlights

### Design discussions
This has been a thoughtful period in [the Clojurians Zulip chat](https://scicloj.github.io/docs/community/chat/). We faced a few questions regarding how we organize functionality across libraries and went through a careful thinking process to reach a common ground of understanding. A lot of the details shared below are the fruit of those discussions.

### [Noj](https://scicloj.github.io/noj/)
The Noj library is the entry point to data science with Clojure, collecting a stack of relevant libraries. During this period, it was officially announced as Beta stage. We kept extending it and mostly worked on documentation. Carsten Behring kept improving the documentation workflow, partially automating it, and creating extensive documentation for a few major Noj components. I also took part in documentation and in helping other community members contribute a few drafts.

### [Tableplot](https://scicloj.github.io/tableplot/)
Tableplot, the plotting library based on the [layered grammar of graphics](https://vita.had.co.nz/papers/layered-grammar.html) idea, was one of my main foci of development. I implemented quite a few additional types of plots and control parameters and put a lot of work into the documentation reference.

### [Tablemath](https://scicloj.github.io/tablemath/)
Tablemath is one result of our recent design discussions. It is a new library for math and statistics that composes well with [tech.ml.dataset](https://github.com/techascent/tech.ml.dataset) and [Tablecloth](https://scicloj.github.io/tablecloth) datasets and uses the functionality of [Fastmath](https://github.com/generateme/fastmath). Tablemath is highly inspired by [R](https://www.r-project.org/) and its packages and is intended to compose well with [Tableplot](https://scicloj.github.io/tableplot/) layered plotting.
During this period, I released an initial version after exploring a few directions.

### [Clay](https://scicloj.github.io/clay/)
Clay, the REPL-friendly notebook and data visualization tool, received a few updates from other community members. On my side, I explored the different ways it consumes JS and CSS dependencies. We want to make this part more modular for various use cases. At the moment, I am struggling with a few technical difficulties.

### [Kindly-render](https://github.com/scicloj/kindly-render)
Kindly-render is a tool-agnosic implementation of the [Kindly](https://scicloj.github.io/kindly/) data visualization standard. Timothy Pratley kept developing it, and it looks very promising. My involvement was not intensive, except for a few joint coding sessions and reviews of the code.

### [Scicloj open-source mentoring](https://scicloj.github.io/docs/community/groups/open-source-mentoring/)
In this period, we continued the collaboration of quite a few mentees and the current four mentors, including myself. To focus on progress with currently ongoing projects, we did slow down the growth of the project and could only accept a few new mentees.

### Meeting new community members
In the last few weeks, I did meet a few new community members: Clojurians who wish to get involved in data science and people of scientific or data background who wish to get involved in Clojure. There is a good momentum in adopting the Scicloj toolkit for various needs. With a few of the new friends, I started meeting more or less regularly and exploring their concrete use cases.

### Clojure in Academia
Following an initiative of Thomas Clark, we started an active exploration of pathways to make Clojure more present in academia. I reached out to about a dozen people who are active in academia and known to be involved in Clojure and scheduled a couple of meetings to discuss possible directions. There has been a warm response from most of the relevant people, who expressed their willingness to help explore this direction.

Three main directions were proposed: (1) Working on academic papers to discuss technical aspects of Clojure's scientific stack. (2) Collaborating with researchers on specific use cases of Clojure. (3) Demonstrating the potential of Clojure in academic teaching.

The teaching perspective, which was proposed by Blaine Mooers, will receive the highest priority in the short term.

As a first step, we are considering organizing an online conference to make one or more of the above directions more visible and encourage further interest.

### Tutorial meetings
During our work on documenting Noj, we experimented with various workflows of writing tutorials together. Recently, we converged on a format that is working. We meet quite often and write tutorial drafts together. The same draft will typically be handled by different people in different meetings. Each time, we review everything so that the session is self-contained. This way, more people learn about topics they care about, and the content we write gets to be reviewed by more people and more perspectives.

### Linear Algebra meetings
The weekly linear algebra meetings keep happening every week. They typically go by the tutorial format mentioned above.

### Website
This period has been a usual period in terms of website maintenance.

### real-world-data group
The [real-world-data group](https://scicloj.github.io/docs/community/groups/real-world-data/) is a space for Clojure data practitioners to share their experiences. It keeps going, meeting every two weeks. In the three meetings we had in November and the one we had in December so far, we mainly discussed the topics mentioned above in this report, as well as a few work experiences of group members.

## Near term goals

### Noj
In the near future, we should bring the Noj documentation to a state that is good enough to be clear and welcoming to new users.

### Tablemath
Tablemath will probably be the main experimental project on my agenda. The main goals are to combine the underlying libraries (Fastmath, dtype-next, tech.ml.dataset, Tablecloth) to benefit from the advantages of each of them in terms of ergonomics as well as performance and to provide a user-friendly API inspired by R. (2)

### Clojure in academia
This project is still in its very early stages. We should explore various directions and carefully pick those which might be promising.

### Tooling
I will join Timothy Pratley on the goal of helping different tools support the Kindly standard. Cursive, Calve, Quarto, and Clojupyter are a few of the relevant candidates.
