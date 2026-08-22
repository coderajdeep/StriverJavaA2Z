# Fractional Knapsack

**Source:** takeUforward (also on GeeksforGeeks — "Fractional Knapsack")

## Problem Statement

Given the weights and values of `N` items, put these items in a knapsack of capacity `W` to get the maximum total value in the knapsack. In Fractional Knapsack, we can break items — i.e., we are allowed to take a fraction of an item instead of taking the whole item. Return the maximum total value that can fit in the bag, as a double, up to a certain decimal precision.

Greedy approach: compute the value/weight ratio for every item, sort items in decreasing order of this ratio, and greedily pick items (taking a fraction of the last item if it doesn't fully fit) until the knapsack capacity is exhausted.

## Example

**Input:** N = 3, W = 50, values = [60, 100, 120], weight = [10, 20, 30]
**Output:** 240.00
**Explanation:** By taking items of weight 10 and 20 fully (value 60 + 100 = 160) and 20/30 = 2/3 fraction of the third item (2/3 * 120 = 80), the total value becomes 160 + 80 = 240.00.

## Constraints

- 1 <= N <= 10^5
- 1 <= W <= 10^5
- 1 <= weight[i] <= 10^5
- 1 <= value[i] <= 10^5
