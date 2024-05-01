---
title: "Clojurists Together project - Scicloj community building - April 2024 update"
description: ""
date: 2024-04-30
lastmod: 2024-05-01
draft: false
weight: 15
images: ["../../sci-cloj-logo-transparent.png"]
contributors: ["daslu"]
---

The [Clojurists Together](https://www.clojuriststogether.org/) organisation has decided [to sponsor](https://www.clojuriststogether.org/news/q1-2024-funding-announcement/) Scicloj community building for Q1 2024, as a project by Daniel Slutsky. The project is taking place in February, March, and April 2024. Here is Daniel's update for April.

Here are the previous ones: [Feb 2024](../clojurists-together-project-scicloj-community-building-february-2024-update/), [Mar 2024](../clojurists-together-project-scicloj-community-building-march-2024-update/)

Comments and ideas would help. :pray: 

# Clojurists Together update - April 2024 - Daniel Slutsky
April 2024 was the last of three months on the Clojurists Together project titled "Scicloj Community Building and Infrastructure".
Scicloj is an open-source group developing Clojure tools and libraries for data and science. As a community organizer at Scicloj, my current role is to help make the emerging Scicloj stack easier and more accessible for broad groups of Clojurians. I collaborate with a few Scicloj members on this. 
While this is the last update under the Clojurists Together 2024 Q1 support, the project will, of course, continue. 
Below are the sub-projects that were addressed during April 2024. They are listed by their proposed priorities for the coming month. 
The new real-world-data group is ranked highest for its impact on community growth. This means the following. Assuming this group will (hopefully) grow well and demand attention, the goals of other projects will receive less attention and will be delayed. However, some of them (e.g., required extensions or bugfixes to libraries) will receive more attention if the real-world-data group requires them.

## [The real-world-data group](https://scicloj.github.io/docs/community/groups/real-world-data/)
The real-world-data group is a space for Clojure data and science practitioners to bring their data projects, share experiences, and evolve common practices.

### April summary
- had a few one-on-one meetings with group members, discussing their goals, and helping out with the technical path
- had the second and third group meetings, which included new presentations, follow-ups on personal projects, hands-on parts, and discussions
- kept working on introductory materials to support the group

### May goals
- have more one-on-one meetings, three more group meetings, and ad-hoc small topical meetings
- help the participants take on active paths that connect their interests with community goals

## [Noj](https://scicloj.github.io/noj/)
The Noj project bundles a few recommended libraries for data and science and adds convenience layers and documentation for using them together.

### April summary
- collaborated with Kira McLean on a draft for a new data-visualization API, combining Tablecloth, Hanami, and statistical functions
- updated documentation: added a tutorial for visualizing correlation matrices (WIP); started working on an additional machine-learning tutorial
- updated the implementation to reuse existing functions of other libraries

### May goals
- implement the new data-visualization API (still in experimental stage)
- improve documentation

## [translating books](https://clojureverse.org/t/learn-data-and-science-in-clojure-by-translating-a-book-together/)
In this project, we are renewing previous efforts to systematically review data science books in other programming languages and convert them to Clojure.
The goal is twofold: figuring out what common data science needs are still missing in the Clojure stack and creating well-polished documentation of this stack. It is also an opportunity for Clojurians to get involved in the data science community and learn from books they are curious about.

### April summary
- created a list of books (to be announced soon in a tidy repo) in a discussion with community members, exploring content and licenses
- explored a Clay+Quarto workflow for a couple of the books, and created draft repos for them
- started exploring certain books with community members who may take them on as their long-term projects

### May goals
- focus on [Modern Statistics with R](https://github.com/mthulin/mswr-book) by Måns Thulin
- keep exploring other books with community members

## [visual-tools group](https://scicloj.github.io/docs/community/groups/visual-tools/)
This group's goal is to create collaborations in learning and building Clojure tools for data visualization, literate programming, and UI design.

### April summary 
- had the third ggplot study session
- had a meetup about badspreadsheet and HTMX with Adam James
- coordinated collaborations with a few group members who are working on HTMX-based dashboards (TBA)
- kept exploring options for grammar-of-graphics implementations (documented in the Scrapbook)

### May goals
- keep the collaborations around HTMX-based layers
- continue the grammar-of-graphics study sessions
- clarify a proposal and a proof-of-concept for the long-term grammar-of-graphics project

## [Clojure Data Scrapbook](https://scicloj.github.io/clojure-data-scrapbook/)
The Clojure Data Scrapbook is intended to be a community-driven collection of tutorials around data and science in Clojure. 

### April summary
- continued the "exploring ggplot" tutorials
- started tutorials (WIP): processing JSON files, analyzing transportation networks
- adapted old tutorials to ecosystem updates

### May goals
- encourage and help community contributions to the scrapbook
- keep adding content to support other projects

## [Clay](https://scicloj.github.io/clay/)
Clay is a minimalistic namespace-as-a-notebook tool for literate programming and data visualization. 

### April summary
- added an experimental version of test generation for the purpose of testable docs / literate testing
- minor bugixes and extensions
- 5 minor releases of Clay, 2 minor releases of the clay.el Emacs package

### May goals
- start working on additional visualizations, mostly Emmy.viewers integration
- explore the extraction of the HTML and Markdown generation layer as a separate library
- keep evolving by user needs

## [Kindly](https://scicloj.github.io/kindly-noted/)
Kindly is a proposed standard for requesting data visualizations in Clojure.

### April summary
- added the meta-kind `kind/fn` for user-defined display
- added the meta-kind `kind/test-last` (with `kindly/check` syntactic sugar) for test generation
- updated documentation (the Kindly-noted project)
- updated kind-clerk (Clerk adapter): plotly support

### May goals
- start working on Kindly support with the creators of new HTMX-based visual-tools
- explore the option of a standalone Kindly implementation that is reusable in different tools (an alternative to the current approach of tool-specific implementations)

## [cmdstan-clj](https://github.com/scicloj/cmdstan-clj)
Cmdstan-clj is a draft library for interop with [Stan](https://mc-stan.org/) (probabilistic modeling through Bayesian statistics).

### April summary
- gave a presentation of the library and the topic of Bayesian Statistics at the real-world-data group
- maintenance: adapted the library to related ecosystem changes

### May goals
- practice usage with community members and keep developing by need

## [ClojisR](https://github.com/scicloj/clojisr)
ClojisR is a bridge between Clojure and the R language for statistical computing.
During this Month, @generateme released the first non-beta version of the library and announced it as stable after 4.5 years of usage.

### April summary
- My role in the release was mostly migrating the old documentation to use our current literate programming workflow with Clay, test-generation, and Quarto.

### May goals
- Migrate the [clojisr-examples](https://github.com/scicloj/clojisr-examples) project to the current workflow.

## [The Scicloj website](https://scicloj.github.io/)

## April summary
- Maintenance and updates

### May goals
- minor updates reflecting current projects and events

## Your feedback would help
Scicloj is in transition. On the one hand, quite a few of the core members have been very active recently, developing the emerging stack of libraries. At the same time, new friends are joining, and soon, more people will enjoy the Clojure for common data and science needs.
If you have any thoughts about the current directions, or if you wish to discuss how the evolving platform may fit your needs, please [reach out](https://scicloj.github.io/docs/community/contact/).
