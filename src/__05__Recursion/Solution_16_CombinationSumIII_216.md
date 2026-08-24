# Combination Sum III

**Source:** LeetCode #216 — Combination Sum III

## Problem Statement

Find all valid combinations of `k` numbers that sum up to `n` such that the following conditions are true:

- Only numbers `1` through `9` are used.
- Each number is used **at most once**.

Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

## Example

**Input:** k = 3, n = 7
**Output:** [[1,2,4]]
**Explanation:** 1 + 2 + 4 = 7. There are no other valid combinations.

**Input:** k = 3, n = 9
**Output:** [[1,2,6],[1,3,5],[2,3,4]]
**Explanation:** These are the valid combinations of size 3 summing to 9.

**Input:** k = 4, n = 1
**Output:** []
**Explanation:** No combination of 4 distinct digits from 1-9 sums to 1.

## Constraints

- `2 <= k <= 9`
- `1 <= n <= 60`
