# Count Inversions in an Array

**Source:** takeUforward

## Problem Statement

Given an array `nums` of `n` integers, count the number of inversions in the array. An inversion is a pair of indices `(i, j)` such that `i < j` and `nums[i] > nums[j]`.

Return the total number of such pairs, computed efficiently (better than the O(n^2) brute force) using a merge-sort based approach.

## Example

**Input:** nums = [2, 4, 1, 3, 5]
**Output:** 3
**Explanation:** The inversions are (2,1), (4,1), and (4,3) — i.e., pairs (index 0,2), (index 1,2), and (index 1,3).

**Input:** nums = [1, 2, 3, 4, 5]
**Output:** 0
**Explanation:** The array is already sorted, so there are no inversions.

## Constraints

- 1 <= nums.length <= 5 * 10^4
- -10^9 <= nums[i] <= 10^9
