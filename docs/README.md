# Battle_of_Sexes

## Outline

Evolution simulator in Java based on the 1976 book ”The Selfish Gene” (chapter 9) by Richard Dawkins, using multithreading to achieve a non deterministic result.

## Introduction

The project builds upon the **Adaptation** and **Natural Selection** theory as a way of expressing the gene-centered view of evolution. The chapter describes "the battle of the sexes", where a model is provided of a population featuring two male types, the faithful (F) and the philanderers (P), and two female types, the coy (C) and the fast (S).

The latter are the players of Dawkins' Game Theory based study in which we have a mathematical model of conflict and cooperation between rational decision-makers, where:

- a: the evolutionary benefit for having a baby
- b: the cost of parenting a baby
- c: the cost of courtship

Each type of Individual has different strategy of survival:

- Faithful men: They are willing to engage in a long courtship and participate in rearing their children.
- Philanderers: Reckless men, they don’t waste time in courting women: if not immediately accepted, they move away and try somewhere else; moreover, if accepted, they mate and then leave anyway, ignoring the destiny of their children.
- Coy women: They accept a partner only after a long courtship.
- Fast women: If they feel so, they don’t mind copulating with whoever they like, even if they just met.

## Goal

The goal of our software is to perform non-deterministic simulations that are parametric to the a, b, c values taking into account the behavior of male and female types and returning the percentages of the four categories of people at the end of the simulation, analyzing the system’s equilibrium state.

## Authors

![](./README_images/CONTRIBUTORS.svg)

## License

Battle_of_Sexes is released under the [MIT License](../LICENSE).
