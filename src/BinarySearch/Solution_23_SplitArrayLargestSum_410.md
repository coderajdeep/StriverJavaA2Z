# Split Array Largest Sum

**Source:** LeetCode #410 — https://leetcode.com/problems/split-array-largest-sum/

## Problem Statement

Given an integer array `nums` and an integer `k`, split `nums` into `k` non-empty contiguous subarrays such that the largest sum among these subarrays is **minimized**.

Return the minimized largest sum of the split.

Note: A subarray is a contiguous part of the array.

## Example

**Input:** nums = [7,2,5,10,8], k = 2
**Output:** 18
**Explanation:** There are four ways to split nums into two subarrays. The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

**Input:** nums = [1,2,3,4,5], k = 2
**Output:** 9
**Explanation:** The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.

## Constraints

- `1 <= nums.length <= 1000`
- `0 <= nums[i] <= 10^6`
- `1 <= k <= min(50, nums.length)`
