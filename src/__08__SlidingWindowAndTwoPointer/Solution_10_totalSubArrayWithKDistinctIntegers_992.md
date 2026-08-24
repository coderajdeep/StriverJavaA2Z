# Subarrays with K Different Integers

**Source:** LeetCode #992 — https://leetcode.com/problems/subarrays-with-k-different-integers/

## Problem Statement

Given an integer array `nums` and an integer `k`, return the number of good subarrays of `nums`.

A good array is an array where the number of different integers in that array is exactly `k`.

- For example, `[1,2,3,1,2]` has 3 different integers: 1, 2, and 3.

A subarray is a contiguous part of an array.

## Example

**Input:** nums = [1,2,1,2,3], k = 2
**Output:** 7
**Explanation:** Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].

**Input:** nums = [1,2,1,3,4], k = 3
**Output:** 3
**Explanation:** Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].

## Constraints

- 1 <= nums.length <= 2 * 10^4
- 1 <= nums[i], k <= nums.length

## Notes on this implementation

`subarraysWithKDistinct` computes the answer as `(count of subarrays with at most k distinct integers) - (count of subarrays with at most k-1 distinct integers)`, using the sliding-window helper `subarraysWithAtMostKDifferentIntegers` (same "exactly k = atMost(k) - atMost(k-1)" trick used in Solution_05 and Solution_06 of this folder).
