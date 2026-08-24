# Next Permutation

**Source:** LeetCode #31 — https://leetcode.com/problems/next-permutation/

## Problem Statement

A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

The next permutation of an array of integers is the next lexicographically greater permutation of its integers. If such an arrangement is not possible, the array must be rearranged to the lowest possible order (i.e., sorted in ascending order).

Given an array of integers `nums`, find the next permutation of `nums` and rewrite it in-place, using only constant extra memory.

## Example

**Input:** nums = [1, 2, 3]
**Output:** [1, 3, 2]

**Input:** nums = [3, 2, 1]
**Output:** [1, 2, 3]
**Explanation:** [3, 2, 1] is the largest permutation of these numbers, so the next permutation wraps around to the smallest one, [1, 2, 3].

## Constraints

- 1 <= nums.length <= 100
- 0 <= nums[i] <= 100
