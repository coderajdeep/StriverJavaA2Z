# Partition Equal Subset Sum

**Source:** takeUforward (equivalent to LeetCode #416)

## Problem Statement

Given an array `arr` of non-negative integers, determine whether the array can be partitioned into two subsets such that the sum of the elements in both subsets is equal.

Return `true` if such a partition is possible, otherwise return `false`.

This is solved by observing that if the total sum of the array is odd, an equal partition is impossible. Otherwise, the problem reduces to checking whether a subset exists whose sum equals `sum / 2` (the Subset Sum Equal to Target problem).

## Example

**Input:** arr = [1, 5, 11, 5]
**Output:** true
**Explanation:** The array can be partitioned as [1, 5, 5] and [11], both summing to 11.

**Input:** arr = [1, 2, 3, 5]
**Output:** false
**Explanation:** The array cannot be partitioned into equal sum subsets.

## Constraints

- 1 <= arr.length <= 200
- 0 <= arr[i] <= 100
