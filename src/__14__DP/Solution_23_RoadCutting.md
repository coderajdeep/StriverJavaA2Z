# Rod Cutting

**Source:** takeUforward

## Problem Statement

Given a rod of length `n` and an array `prices` where `prices[i]` denotes the price of a rod piece of length `i+1`, determine the maximum value obtainable by cutting the rod into pieces (a piece can also be the whole rod itself, i.e., no cut) and selling those pieces.

Each length of rod piece can be cut and sold any number of times (this is equivalent to Unbounded Knapsack where the "weight" of a piece of length `i+1` is `i+1` and its "value" is `prices[i]`, and the "capacity" is `n`).

## Example

**Input:** prices = [2, 5, 7, 8, 10], n = 5
**Output:** 12
**Explanation:** Cut the rod into two pieces of length 2 each and one piece of length 1: 2 + 2 + 1 = 5. Value = 5 + 5 + 2 = 12. Alternatively, cutting into pieces of length 2 and 3 gives 5 + 7 = 12 as well, which is the maximum.

**Input:** prices = [1, 5, 8, 9], n = 4
**Output:** 10
**Explanation:** Cut the rod into two pieces of length 2 each: value = 5 + 5 = 10.

## Constraints

- 1 <= n <= 1000
- prices.length == n
- 1 <= prices[i] <= 1000
