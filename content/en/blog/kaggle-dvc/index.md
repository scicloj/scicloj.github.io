---
title: "Predict real vs. fake disaster tweets"
description: ""
lead: "Predict real vs. fake disaster tweets with dvc, Clojure and python "
date: 2022-09-10
lastmod: 2022-09-10
draft: false
weight: 50
images: []
contributors: ["behrica"]
---

Any a little bit more serious machine learning,
like participating in a Kaggle competition, requires in my view a form
of ML experiment tracking.


As ML requires a lot of different trying of code,
models and hyper-parameters, we need to have a tools which keeps track of this.

These type of tools can be programming language independent,
as they see the code (whatever code) such as one of the assets 
to **track** (among hyper-parameters, performance metrics and data)

One such open source tool is
[DVC - Data Version Control](http://dvc.org)

In my view this tools is very relevant for ML in Clojure, due to its main
characteristics:

**A DVC pipeline is based on steps , where each step is a shell script
(so can be written in Clojure as well)**

It therefore allows a different form of `interop`, in which certain steps
are written in Python / R (the modeling step for example) while
preprocessing is done in Clojure.
This makes a lot of sense, as the pure modeling is often a few lines only 
and is tricky to use via interop (due to multithreading, GPU usage, long
running). We can reduce the python code to the concrete single-line
call to "train(...)" if we want.



The different steps can then communicate via data files on disk.
(arrow is a good format for this, as supported by Clojure via 
tablecloth/dataset, python and R.

DVC takes care of these inter-step-dependencies, and only reruns what has changed.
The details of this are in the DVC documentation.

In the following DVC pipeline I have 3 steps, 2 in Clojure, 
one in Python.

* preprocess: Done in pure Clojure using [tablecloth](https://scicloj.github.io/tablecloth/index.html)
* train: Done in pure python with [simpletransformers](https://simpletransformers.ai/), reading the data files produced in preprocess and train the model
* predict_kaggle: Done in Clojure, but using `simpletransformers`
python library via [libpython-clj](https://github.com/clj-python/libpython-clj)

```yaml
stages:
  preprocess:
    cmd: clj preprocess.clj
    deps:
      - preprocess.clj
      - train.csv
      - test.csv
    outs:
      - train.arrow
      - test.arrow


  train:
    cmd: python train.py
    deps:
      - train.py
      - train.arrow
      - test.arrow
    outs:
      - outputs
    metrics:
      - eval.json
    params:
      - train.num_train_epochs
      - train.model_type
      - train.model_name
      - train.train_batch_size


  predict_kaggle:
     cmd: clj predict_kaggle.clj
     deps:
       - outputs
       - predict_kaggle.clj
     outs:
       - kaggle_submission.csv
```

The reason why I did step 2 in pure python is stability. 
I did not want to use `libpython-clj` for eventually very long running training runs.
It has some issues with [simpletransformers](https://simpletransformers.ai/) based on PyTorch

Using a pre-trained [roberta](https://huggingface.co/roberta-base) model from the huggingface hub,
and a bit of preprocessing
gave me a score of 0.82 and position 119 in the leader board.

So even though that Kaggle does not support Clojure
(in the web notebook interface),
we can use Clojure to participate in Kaggle competitions.

We could of course implement the "train" step in Clojure as well,
in case we want to use a model from:

* Clojure (using [scicloj.ml](https://github.com/scicloj/scicloj.ml) for example)
* Java (via Clojure interop)
* python (using [libpython-clj](https://github.com/clj-python/libpython-clj))
* R (using [clojisr](https://github.com/scicloj/clojisr))

I suggest to use dvc and a multi-step pipeline even in a pure JVM (Clojure + Java) setup.
It nicely structures the work and is able to track all assets.

References:

* [Kaggle  competition](https://www.kaggle.com/competitions/nlp-getting-started)
* [full code](https://github.com/behrica/predict_disaster_tweet/tree/prepareDemo)
