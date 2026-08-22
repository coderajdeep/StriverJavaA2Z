# Search in Rotated Sorted Array II

**Source:** LeetCode #81 — https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

## Problem Statement

There is an integer array `nums` sorted in non-decreasing order (not necessarily with distinct values). Prior to being passed to your function, `nums` is possibly rotated at an unknown pivot index `k` such that the resulting array is `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]` (0-indexed).

Given the array `nums` after the possible rotation and an integer `target`, return `true` if `target` is in `nums`, or `false` if it is not.

You must decrease the overall operation steps as much as possible.

## Example

**Input:** nums = [2,5,6,0,0,1,2], target = 0
**Output:** true

**Input:** nums = [2,5,6,0,0,1,2], target = 3
**Output:** false

## Constraints

- `1 <= nums.length <= 5000`
- `-10^4 <= nums[i] <= 10^4`
- `nums` is guaranteed to be rotated at some pivot.
- `-10^4 <= target <= 10^4`
