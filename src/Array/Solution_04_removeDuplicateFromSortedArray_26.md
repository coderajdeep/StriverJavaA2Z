# Remove Duplicates from Sorted Array

**Source:** LeetCode #26 — https://leetcode.com/problems/remove-duplicates-from-sorted-array/

## Problem Statement

Given an integer array `nums` sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in `nums`.

Consider the number of unique elements of `nums` to be `k`. To get accepted, you need to do the following:
- Change the array `nums` such that the first `k` elements of `nums` contain the unique elements in the order they were present originally.
- Return `k`.

## Example

**Input:** nums = [1, 1, 2]
**Output:** 2, nums = [1, 2, _]
**Explanation:** The function returns k = 2, with the first two elements being 1 and 2 respectively.

**Input:** nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
**Output:** 5, nums = [0, 1, 2, 3, 4, _, _, _, _, _]
**Explanation:** The function returns k = 5, with the first five elements being 0, 1, 2, 3, and 4 respectively.

## Constraints

- 1 <= nums.length <= 3 * 10^4
- -100 <= nums[i] <= 100
- nums is sorted in non-decreasing order.
