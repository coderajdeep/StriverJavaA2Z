# Check if __01__Array Is Sorted and Rotated

**Source:** LeetCode #1752 — https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

## Problem Statement

Given an array `nums`, return `true` if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return `false`.

There may be duplicates in the original array.

Note: An array `A` rotated by `x` positions results in an array `B` of the same length such that `A[i] == B[(i+x) % A.length]` for every valid index `i`.

## Example

**Input:** nums = [3, 4, 5, 1, 2]
**Output:** true
**Explanation:** [1, 2, 3, 4, 5] is the original sorted array. It was rotated by 3 positions to get [3, 4, 5, 1, 2].

**Input:** nums = [2, 1, 3, 4]
**Output:** false
**Explanation:** There is no sorted array that can be rotated to obtain nums.

## Constraints

- 1 <= nums.length <= 100
- 1 <= nums[i] <= 100
