# Binary Subarrays With Sum

**Source:** LeetCode #930 — https://leetcode.com/problems/binary-subarrays-with-sum/

## Problem Statement

Given a binary array `nums` and an integer `goal`, return the number of non-empty subarrays with a sum equal to `goal`.

A subarray is a contiguous part of the array.

## Example

**Input:** nums = [1,0,1,0,1], goal = 2
**Output:** 4
**Explanation:** The 4 subarrays are bolded and underlined below:
[**1,0,1**,0,1], [**1,0,1,0**,1], [1,**0,1,0,1**], [1,0,**1,0,1**]

**Input:** nums = [0,0,0,0,0], goal = 0
**Output:** 15

## Constraints

- 1 <= nums.length <= 3 * 10^4
- nums[i] is either 0 or 1.
- 0 <= goal <= nums.length

## Notes on this implementation

`numSubArraysWithSum` computes the answer as `(count of subarrays with sum <= goal) - (count of subarrays with sum <= goal-1)`, using the sliding-window helper `numOfSubArraysWithAtMostGivenSum` twice (this only works because array elements are non-negative). A second method, `numSubArraysWithSumUsingHashMap`, uses a prefix-sum + HashMap approach that works for arrays containing negative integers as well.
