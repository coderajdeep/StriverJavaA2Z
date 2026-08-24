# Longest Subarray with XOR Equal to K

**Source:** takeUforward

## Problem Statement

Given an array of integers `nums` and an integer `k`, find the length of the longest contiguous subarray whose XOR of all its elements equals `k`.

## Example

**Input:** nums = [4, 2, 2, 6, 4], k = 4
**Output:** 3
**Explanation:** The subarray [4, 2, 2] has XOR = 4 ^ 2 ^ 2 = 4, and its length is 3, which is the longest contiguous subarray whose XOR equals 4.

**Input:** nums = [4, 2, 2, 6, 4], k = 6
**Output:** 5
**Explanation:** The XOR of the entire array is 4 ^ 2 ^ 2 ^ 6 ^ 4 = 6, so the whole array itself is the longest subarray whose XOR equals 6.

## Constraints

- 1 <= nums.length <= 10^5
- 0 <= nums[i] <= 10^9
- 0 <= k <= 10^9
