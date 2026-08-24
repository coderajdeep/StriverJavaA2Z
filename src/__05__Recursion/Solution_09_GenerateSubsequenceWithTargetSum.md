# Generate All Subsequences With a Target Sum

**Source:** takeUforward

## Problem Statement

Given an array `nums` of integers and an integer `sum`, find and return all subsequences of the array whose elements add up to exactly `sum`.

At each index, recursively decide whether to include the current element in the running subsequence (only if it does not exceed the remaining target) or skip it, reducing the target accordingly. When the index reaches the end of the array, add the current subsequence to the result only if the running/remaining sum equals exactly `0`.

## Example

**Input:** nums = [1,2,1], sum = 2
**Output:** [[1,1],[2]]
**Explanation:** The subsequence [1,1] (indices 0 and 2) sums to 2, and the subsequence [2] sums to 2.

**Input:** nums = [1,2,3], sum = 3
**Output:** [[1,2],[3]]

## Constraints

- `1 <= nums.length <= 20`
- `0 <= nums[i] <= 1000`
- `0 <= sum <= 10000`
