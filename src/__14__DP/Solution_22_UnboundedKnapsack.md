# Unbounded Knapsack

**Source:** takeUforward

## Problem Statement

Given `n` items, each with a weight `wt[i]` and a value `val[i]`, and a knapsack with maximum weight capacity `W`, determine the maximum value that can be obtained by putting items into the knapsack. Unlike the classic 0/1 Knapsack, here an unlimited number of copies of each item is available (i.e., an item can be picked multiple times).

## Example

**Input:** wt = [1, 3, 4, 5], val = [10, 40, 50, 70], W = 8
**Output:** 110
**Explanation:** Taking one copy of item 3 (weight 5, value 70) plus one copy of item 1 (weight 3, value 40) uses weight 5 + 3 = 8 and yields value 70 + 40 = 110, which is the maximum achievable within capacity 8.

## Constraints

- 1 <= n <= 1000
- 1 <= wt[i], val[i] <= 1000
- 1 <= W <= 1000
