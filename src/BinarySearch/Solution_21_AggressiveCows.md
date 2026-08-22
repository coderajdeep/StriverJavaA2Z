# Aggressive Cows

**Source:** takeUforward (originally from SPOJ)

## Problem Statement

Given an array `nums` where each element represents the position of a stall, and an integer `k` representing the number of aggressive cows, assign the cows to the stalls such that the minimum distance between any two cows is as large as possible.

Return the largest possible minimum distance between any two cows when `k` cows are placed optimally among the given stalls.

## Example

**Input:** nums = [0, 3, 4, 7, 10, 9], k = 4
**Output:** 3
**Explanation:** Placing 4 cows at positions 0, 3, 7, 10 gives a minimum distance of 3 between any two adjacent cows, which is the maximum possible.

**Input:** nums = [1, 2, 4, 8, 9], k = 3
**Output:** 3
**Explanation:** Placing cows at positions 1, 4, 8 (or similar) gives a minimum distance of 3.

## Constraints

- `2 <= nums.length <= 10^5`
- `0 <= nums[i] <= 10^9`
- `2 <= k <= nums.length`
