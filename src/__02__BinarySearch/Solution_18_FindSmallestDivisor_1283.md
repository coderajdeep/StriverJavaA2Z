# Find the Smallest Divisor Given a Threshold

**Source:** LeetCode #1283 — https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

## Problem Statement

Given an array of integers `nums` and an integer `threshold`, choose a positive integer `divisor`, divide all the array by it, and sum the division's result. Find the **smallest** divisor such that the result mentioned above is less than or equal to `threshold`.

Each result of the division is rounded to the nearest integer greater than or equal to that element (i.e. `ceil`, e.g. `7/3 = 3`).

It is guaranteed that there will be an answer.

## Example

**Input:** nums = [1,2,5,9], threshold = 6
**Output:** 5
**Explanation:** With divisor 5: [1,1,1,2] sums to 5, which is <= threshold. Divisor 4 gives sum 7 which is too large.

**Input:** nums = [44,22,33,11,1], threshold = 5
**Output:** 44

## Constraints

- `1 <= nums.length <= 5 * 10^4`
- `1 <= nums[i] <= 10^6`
- `nums.length <= threshold <= 10^6`
