---
title: "Launching Columns for Tablecloth"
description: ""
date: 2024-04-13
lastmod: 2024-04-15
draft: false
weight: 16
images: ["../../sci-cloj-logo-transparent.png"]
contributors: ["Ethan Miller"]
---

This is a cross-post of [a recent post](https://humanscode.com/columns-for-tablecloth-launch) by Ethan Miller at [his blog](https://humanscode.com/), announcing the release of a substantial addition to the [Tablecloth](https://scicloj.github.io/tablecloth/) library.

--------------------

## The New `Column` API

Today we at [scicloj](https://scicloj.github.io) deployed a new Column
 API (`tablecloth.column.api`) into the data processing library
 [Tablecloth](https://gitub.com/scicloj/tablecloth) (available as of
 version `7.029.1`). This new API adds a new primitive to the
 Tablecloth system: the `column`. Here's how we use it:

```
(require '[tablecloth.column.api :as tcc])

(tcc/column [1 2 3 4 5])
;; => #tech.v3.dataset.column<int64>[5]
null
[1, 2, 3, 4, 5]
```

The new `column` is the same as the columns that comprise a `dataset`.
It is a one-dimensional typed sequence of values. Underneath the hood,
the column is just the `column` defined in
[tech.ml.dataset](https://techascent.github.io/tech.ml.dataset/tech.v3.dataset.column.html),
the library that backs Tablecloth.

The difference is that now when you are using Tablecloth you have the
option of interacting directly with a `column` using an API that
provides a set of operations that always take and return a column.

## Basic Usage

Let's go through a simple example. Let's say we have some test scores
that we need to analyze:

```
(def test-scores (tcc/column [85 92 78 88 95 83 80 90]))

test-scores
;; => #tech.v3.dataset.column<int64>[8]
null
[85, 92, 78, 88, 95, 83, 80, 90]
```

Now that we have these values in a column, we can easily perform
operations on them:

```
(tcc/mean test-scores)
;; => 86.375

(tcc/standard-deviation test-scores)
;; => 5.926634795564849
```

There are a many operations that one can perform. At the moment, the
available operations are those that you would have previously accessed
by importing the
[`tech.v3.datatype.functional`](https://cnuernber.github.io/dtype-next/tech.v3.datatype.functional.html)
namespace from dtype-next.

To get a fuller picture of the Column API and how it works, please
consult the [Column API section in the Tablecloth
documentation](https://scicloj.github.io/tablecloth/#column-api).

## Easier Column Operations on the Dataset

The changes we've deployed also improve the expressive power of
Tablecloth's standard Dataset API. Previously, if you needed to do
something simple like a group by and aggregation on a column in a
dataset, the code could become unnecessarily verbose:

```
(defonce stocks
  (tc/dataset "https://raw.githubusercontent.com/techascent/tech.ml.dataset/master/test/data/stocks.csv" {:key-fn keyword}))


(tc/column-names stocks)

(-> stocks
    (tc/group-by [:symbol])
    (tc/aggregate (fn [ds]
                    (-> ds
                        :price
                        tech.v3.datatype.functional/mean))))
;; => _unnamed [5 2]:

| :symbol |      summary |
|---------|-------------:|
|    MSFT |  24.73674797 |
|    AMZN |  47.98707317 |
|     IBM |  91.26121951 |
|    GOOG | 415.87044118 |
|    AAPL |  64.73048780 |
```

With the new column operations within for datasets, you can now simply write: 

```
(-> stocks
    (tc/group-by [:symbol])
    (tc/mean [:price]))
```

The same set operations available to be run on the `column` can be
called on columns in the datasest. However, when operating a dataset,
functions that would return a scalar value act as aggregator
functions, as seen above.

Functions that would return a new column allow the user to specify a
target column to be added to the dataset, as in this example where we
first use the method above to add a column with the mean back to
stocks:

```
(def stocks-with-mean
  (-> stocks
      (tc/group-by [:symbol])
      (tc/mean [:price])
      (tc/rename-columns {"summary" :mean-price})
      (tc/inner-join stocks :symbol)))


stocks-with-mean
;; => inner-join [560 4]:
;;    | :symbol | :mean-price |      :date | :price |
;;    |---------|------------:|------------|-------:|
;;    |    MSFT | 24.73674797 | 2000-01-01 |  39.81 |
;;    |    MSFT | 24.73674797 | 2000-02-01 |  36.35 |
;;    |    MSFT | 24.73674797 | 2000-03-01 |  43.22 |
;;    |    MSFT | 24.73674797 | 2000-04-01 |  28.37 |
```
Then we use a dataset column operation that returns a column -- column division, in this case -- to add a new column holding the relative daily price of the stock:

```
(-> stocks-with-mean
    (tc// :relative-daily-price [:price :mean-price]))
;; => inner-join [560 5]:
;;    | :symbol | :mean-price |      :date | :price | :relative-daily-price |
;;    |---------|------------:|------------|-------:|----------------------:|
;;    |    MSFT | 24.73674797 | 2000-01-01 |  39.81 |            1.60934655 |
;;    |    MSFT | 24.73674797 | 2000-02-01 |  36.35 |            1.46947368 |
;;    |    MSFT | 24.73674797 | 2000-03-01 |  43.22 |            1.74719814 |
;;    |    MSFT | 24.73674797 | 2000-04-01 |  28.37 |            1.14687670 |
```

For more information, on these operations, please consult the
documentation
[here](https://scicloj.github.io/tablecloth/pr-preview/pr-100/#column-operations).

## Thanks to Clojurist Together

This contribution to Tablecloth was supported by [Clojurists
Together](https://www.clojuriststogether.org) through their [Quarterly
Fellowships](https://www.clojuriststogether.org/open-source/) for open
source development.
