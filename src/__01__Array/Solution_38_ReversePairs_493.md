# Reverse Pairs

**Source:** LeetCode #493 — https://leetcode.com/problems/reverse-pairs/

## Problem Statement

Given an integer array `nums`, return the number of reverse pairs in the array.

A reverse pair is a pair `(i, j)` where `0 <= i < j < nums.length` and `nums[i] > 2 * nums[j]`.

## Example

**Input:** nums = [1, 3, 2, 3, 1]
**Output:** 2
**Explanation:** The reverse pairs are (1, 4) with nums[1] = 3 > 2*nums[4] = 2, and (3, 4) with nums[3] = 3 > 2*nums[4] = 2.

**Input:** nums = [2, 4, 3, 5, 1]
**Output:** 3

## Constraints

- 1 <= nums.length <= 5 * 10^4
- -2^31 <= nums[i] <= 2^31 - 1
