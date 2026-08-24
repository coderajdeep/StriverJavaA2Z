# Subarray Sum Equals K

**Source:** LeetCode #560 — https://leetcode.com/problems/subarray-sum-equals-k/

## Problem Statement

Given an array of integers `nums` and an integer `k`, return the total number of subarrays whose sum equals to `k`.

A subarray is a contiguous non-empty sequence of elements within an array.

## Example

**Input:** nums = [1, 1, 1], k = 2
**Output:** 2
**Explanation:** The subarrays [1,1] (indices 0-1) and [1,1] (indices 1-2) both sum to 2.

**Input:** nums = [1, 2, 3], k = 3
**Output:** 2
**Explanation:** The subarrays [1,2] and [3] both sum to 3.

## Constraints

- 1 <= nums.length <= 2 * 10^4
- -1000 <= nums[i] <= 1000
- -10^7 <= k <= 10^7
