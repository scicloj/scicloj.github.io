---
title: "Clojurists Together project - Scicloj community building - March 2024 update"
description: ""
date: 2024-03-31
lastmod: 2024-04-14
draft: false
weight: 18
images: ["../../sci-cloj-logo-transparent.png"]
contributors: ["daslu"]
---

The [Clojurists Together](https://www.clojuriststogether.org/) organisation has decided [to sponsor](https://www.clojuriststogether.org/news/q1-2024-funding-announcement/) Scicloj community building for Q1 2024, as a project by Daniel Slutsky. The project is taking place in February, March, and April 2024. Here is Daniel's update for March.

You may see the previous one - the February update - [here](../clojurists-together-project-scicloj-community-building-february-2024-update/).

Comments and ideas would help. :pray: 

# Clojurists Together update - March 2024 - Daniel Slutsky

March 2024 was the second of three months on the Clojurists Together project titled "Scicloj Community Building and Infrastructure".

Scicloj is an open-source group developing Clojure tools and libraries for data and science. 

As a community organizer at Scicloj, my current role is to help make the emerging Scicloj stack easier and more accessible for broad groups of Clojurians. I collaborate with a few Scicloj members on this. 

In March 2024, this has been mostly about the following projects. 

The projects are listed by their proposed priorities for the coming month. 

The new real-world-data group is ranked highest for its impact on community growth. This means the following. Assuming this group will (hopefully) grow well and demand attention, the goals of other projects will receive less attention and will be delayed. However, some of them (e.g., required extensions or bugfixes to libraries) will receive more attention if the real-world-data group requires them.

## [The real-world-data group](https://scicloj.github.io/docs/community/groups/real-world-data/)

The real-world-data group is a space for Clojure data and science practitioners to bring their data projects, share experiences, and evolve common practices.

### March summary
- had quite a few one-on-one meetings with group members, discussing their goals, interests, and needs
- had [the first group meeting](https://clojureverse.org/t/real-world-data-meeting-1/), including personal introductions, talks [by Kyle Passarelli](https://www.youtube.com/watch?v=oeY2_M22nEM) and [by Adham Omran](https://www.youtube.com/watch?v=iG2OF9C2FSI), a hands-on part, and discussions
- started creating introductory materials to support the group (see the Scrapbook section)

### April goals
- have more one-on-one meetings, two more group meetings, and ad-hoc small topical meetings
- help the participants take on active paths that connect their interests with community goals

## [Noj](https://scicloj.github.io/noj/)
The Noj project bundles a few recommended libraries for data and science and adds convenience layers and documentation for using them together.

### March summary
- reorganized the docs and clarified the status of different parts
- moved some parts of the experimental functionality to other libraries

### April goals
- start stabilizing important parts of the experimental API (noj.vis.*, noj.stats)
- improve documentation

## [Clojure Data Scrapbook](https://scicloj.github.io/clojure-data-scrapbook/)
The Clojure Data Scrapbook is intended to be a community-driven collection of tutorials around data and science in Clojure. 

### March summary
- created a simple contribution guide
- content updates:
  - added the [Chicago bike trips](https://scicloj.github.io/clojure-data-scrapbook/projects/geography/chicago-bikes) tutorial
  - added the noj-getting-started [notebook](https://scicloj.github.io/noj-getting-started/) & [video](https://www.youtube.com/watch?v=5GluhUmMlpM)
  - added the [exploring Observable](https://scicloj.github.io/clojure-data-scrapbook/projects/datavis/observable) draft, exploring [Observable](https://observablehq.com/) interop
  - added a few updates to the [exploring ggplot](https://scicloj.github.io/clojure-data-scrapbook/projects/datavis/ggplot) book
  - kept working on the [Seattle parks & neighborhoods](https://scicloj.github.io/clojure-data-scrapbook/projects/geography/seattle-parks) tutorial

### April goals
- encourage and help community contributions to the scrapbook
- keep adding content to support other projects

## [Clay](https://scicloj.github.io/clay/)
Clay is a minimalistic namespace-as-a-notebook tool for literate programming and data visualization. 

### March summary
- user support
- bugfixes, extensions, and performance improvements
- 7 minor releases
- shifted from Alpha to Beta stage

### April goals
- support user needs, especially in study groups
- explore adding [emmy-viewers](https://github.com/mentat-collective/emmy-viewers) support

## [Kindly](https://scicloj.github.io/kindly-noted/)
Kindly is a proposed standard for requesting data visualizations in Clojure.

### March summary
- added a couple of visualization kinds (with Clay support)
- improved documentation (especially [the catalog of kinds](https://scicloj.github.io/kindly-noted/kinds))
- shifted to Beta stage

### April goals
- discuss Kindly integration with visual tool authors

## [visual-tools group](https://scicloj.github.io/docs/community/groups/visual-tools/)

This group's goal is to create collaborations in learning and building Clojure tools for data visualization, literate programming, and UI design.

### March summary 
- had one meeting - [the second ggplot study session](https://clojureverse.org/t/visual-tools-meeting-22-ggplot-study-session-2-summary-recording/10631)
- supported some related explorations of grammar-of-graphics in Clojure (see the [exploring ggplot book](https://scicloj.github.io/clojure-data-scrapbook/projects/datavis/ggplot)), especially [connecting Clojure specs to ggplotly](https://scicloj.github.io/clojure-data-scrapbook/projects/datavis/ggplot/ggplotly)

### April goals
- continue the grammar-of-graphics exploration
- have at least one more study session

## [cmdstan-clj](https://github.com/scicloj/cmdstan-clj)

Cmdstan-clj is a draft library for interop with [Stan](https://mc-stan.org/) (probabilistic modeling through Bayesian statistics).

### March summary
- created a draft version of the library

### April goals
- practice usage with community members and keep developing by need

## Your feedback would help

Scicloj is in transition. On the one hand, quite a few of the core members have been very active recently, developing the emerging stack of libraries. At the same time, new friends are joining, and soon, more people will enjoy the Clojure for common data and science needs.

If you have any thoughts about the current directions, or if you wish to discuss how the evolving platform may fit your needs, please [reach out](https://scicloj.github.io/docs/community/contact/).
