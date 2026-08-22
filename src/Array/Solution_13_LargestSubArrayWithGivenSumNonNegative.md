# Longest Subarray with Sum K (Non-Negative Numbers)

**Source:** takeUforward

## Problem Statement

Given an array `nums` containing only non-negative integers and an integer `k`, find the length of the longest contiguous subarray whose elements sum up to exactly `k`.

Since all elements are non-negative, this can be solved efficiently with a two-pointer / sliding window approach. If no such subarray exists, return 0.

## Example

**Input:** nums = [2, 3, 5, 1, 9], k = 10
**Output:** 3
**Explanation:** The subarray [2, 3, 5] sums to 10 and has length 3, which is the longest such subarray.

**Input:** nums = [1, 1, 1, 1, 1], k = 2
**Output:** 2
**Explanation:** Any adjacent pair like [1, 1] sums to 2; length 2 is the maximum possible.

## Constraints

- 1 <= nums.length <= 10^5
- 0 <= nums[i] <= 10^9
- 0 <= k <= 10^9
