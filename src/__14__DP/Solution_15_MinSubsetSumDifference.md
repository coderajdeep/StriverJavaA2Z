# Minimum Subset Sum Difference

**Source:** takeUforward

## Problem Statement

Given an array `arr` of `n` non-negative integers, partition the array into two subsets `S1` and `S2` such that every element belongs to exactly one subset, and the absolute difference between the sum of elements of `S1` and the sum of elements of `S2` is minimized.

Return the minimum possible absolute difference.

This is solved using the Subset Sum __14__DP: find all achievable subset sums `s` in the range `[0, totalSum/2]`, and for each achievable sum, the corresponding difference is `abs(totalSum - 2*s)`. The minimum such difference is the answer.

## Example

**Input:** arr = [1, 6, 11, 5]
**Output:** 1
**Explanation:** Total sum = 23. Partition {1, 5, 6} (sum = 12) and {11} (sum = 11) gives a difference of |12 - 11| = 1, which is the minimum possible.

**Input:** arr = [1, 2, 3, 9]
**Output:** 3
**Explanation:** Partition {1, 2, 3} (sum = 6) and {9} (sum = 9) gives a difference of |9 - 6| = 3, the minimum possible.

## Constraints

- 1 <= arr.length <= 100
- 0 <= arr[i] <= 100
