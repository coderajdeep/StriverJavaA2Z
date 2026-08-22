# Maximum Product Subarray

**Source:** LeetCode #152 — https://leetcode.com/problems/maximum-product-subarray/

## Problem Statement

Given an integer array `nums`, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

## Example

**Input:** nums = [2, 3, -2, 4]
**Output:** 6
**Explanation:** [2, 3] has the largest product 6.

**Input:** nums = [-2, 0, -1]
**Output:** 0
**Explanation:** The result cannot be 2, because [-2, -1] is not a contiguous subarray (0 is between them).

## Constraints

- 1 <= nums.length <= 2 * 10^4
- -10 <= nums[i] <= 10
- The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
