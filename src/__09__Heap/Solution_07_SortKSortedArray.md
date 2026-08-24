# Sort a K Sorted (Nearly Sorted) __01__Array

**Source:** takeUforward / GeeksforGeeks — https://www.geeksforgeeks.org/problems/k-sorted-array1610/1

## Problem Statement

Given an array of `n` elements, where each element is at most `k` positions away from its target position in the sorted array (i.e., the array is "k-sorted" or "nearly sorted"), sort the array in linear-ish time using a min-heap of size `k+1`.

The idea: since every element is guaranteed to be at most `k` positions away from where it should be, maintaining a min-heap of the next `k+1` elements is enough — the minimum of that window is guaranteed to be the next element in sorted order.

This file also includes a helper `isKSortedArray(nums, k)` that checks whether a given array actually satisfies the k-sorted property, i.e., for the array sorted normally, no element has moved more than `k` positions away from its original index.

## Example

**Input:** nums = [6, 5, 3, 2, 8, 10, 9], k = 3
**Output:** [2, 3, 5, 6, 8, 9, 10]
**Explanation:** Every element in the input is at most 3 positions away from its position in the sorted output, so a min-heap of size k+1 = 4 is sufficient to produce the sorted array in a single pass.

## Constraints

- 1 <= n <= 10^6
- 0 <= k < n
- 1 <= nums[i] <= 10^6

## Complexity

- Time complexity: O(n log k)
- Space complexity: O(k)
