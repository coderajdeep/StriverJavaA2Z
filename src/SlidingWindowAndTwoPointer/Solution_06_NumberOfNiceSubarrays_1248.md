# Count Number of Nice Subarrays

**Source:** LeetCode #1248 — https://leetcode.com/problems/count-number-of-nice-subarrays/

## Problem Statement

Given an array of integers `nums` and an integer `k`. A continuous subarray is called nice if there are `k` odd numbers on it.

Return the number of nice sub-arrays.

## Example

**Input:** nums = [1,1,2,1,1], k = 3
**Output:** 2
**Explanation:** The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

**Input:** nums = [2,4,6], k = 1
**Output:** 0
**Explanation:** There is no odd numbers in the array.

**Input:** nums = [2,2,2,1,2,2,1,2,2,2], k = 2
**Output:** 16

## Constraints

- 1 <= nums.length <= 5 * 10^4
- 1 <= nums[i] <= 10^5
- 1 <= k <= nums.length

## Notes on this implementation

This uses the exact same "at most" trick as Binary Subarrays With Sum (LeetCode #930): the answer is `(count of subarrays with at most k odd numbers) - (count of subarrays with at most k-1 odd numbers)`, where each odd number is treated as a 1 and each even number as a 0.
