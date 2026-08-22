# Move Zeroes

**Source:** LeetCode #283 — https://leetcode.com/problems/move-zeroes/

## Problem Statement

Given an integer array `nums`, move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

## Example

**Input:** nums = [0, 1, 0, 3, 12]
**Output:** [1, 3, 12, 0, 0]
**Explanation:** All zeroes are moved to the end while [1, 3, 12] keep their relative order.

**Input:** nums = [0]
**Output:** [0]
**Explanation:** A single zero stays as is.

## Constraints

- 1 <= nums.length <= 10^4
- -2^31 <= nums[i] <= 2^31 - 1
