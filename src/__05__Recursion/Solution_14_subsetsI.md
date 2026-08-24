# Subset Sums I

**Source:** takeUforward

## Problem Statement

Given an array `nums` of `N` integers, print all the possible sums of every subset of the array (including the empty subset, whose sum is `0`, and the full array).

For each index, recursively branch into "take" the current element (adding it to a running sum) and "not take" it. When the index reaches the end of the array, add the accumulated running sum to the result list. Note that this problem asks only for the **sums** of subsets, not the subsets themselves, so the result may contain duplicate sums.

## Example

**Input:** nums = [3,1,2]
**Output:** [6,4,5,3,3,1,2,0]
**Explanation:** The 2^3 = 8 subsets of [3,1,2] are {}, {3}, {1}, {3,1}, {2}, {3,2}, {1,2}, {3,1,2}, with sums 0,3,1,4,2,5,3,6 respectively (order depends on the traversal order used).

**Input:** nums = [2,3]
**Output:** [5,2,3,0]

## Constraints

- `1 <= N <= 15`
- `0 <= nums[i] <= 10^4`
