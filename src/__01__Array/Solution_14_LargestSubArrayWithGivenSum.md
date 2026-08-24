# Longest Subarray with Sum K (Positive and Negative Numbers)

**Source:** takeUforward

## Problem Statement

Given an array `nums` that may contain positive, negative, and zero values, and an integer `k`, find the length of the longest contiguous subarray whose elements sum up to exactly `k`.

Because the array can contain negative numbers, a sliding window approach does not work directly; a prefix-sum with hashing approach is required. If no such subarray exists, return 0.

## Example

**Input:** nums = [10, 5, 2, 7, 1, 9], k = 15
**Output:** 4
**Explanation:** The subarray [5, 2, 7, 1] sums to 15 and has length 4.

**Input:** nums = [-1, 1, 1], k = 1
**Output:** 3
**Explanation:** The entire array [-1, 1, 1] sums to 1, giving the longest subarray of length 3.

## Constraints

- 1 <= nums.length <= 10^5
- -10^5 <= nums[i] <= 10^5
- -10^9 <= k <= 10^9
