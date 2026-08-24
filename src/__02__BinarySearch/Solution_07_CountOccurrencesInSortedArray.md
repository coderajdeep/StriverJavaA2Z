# Count Occurrences of a Number in a Sorted __01__Array

**Source:** takeUforward

## Problem Statement

Given a sorted array `arr` of `n` integers (which may contain duplicates) and a `target` value, find the total number of occurrences of `target` in the array.

Solve it in `O(log n)` time using binary search (by finding the lower bound and upper bound of `target`).

## Example

**Input:** arr = [2, 4, 6, 8, 8, 8, 11, 13], target = 8
**Output:** 3
**Explanation:** 8 occurs 3 times in the array.

**Input:** arr = [2, 4, 6, 8, 8, 8, 11, 13], target = 5
**Output:** 0
**Explanation:** 5 does not occur in the array.

## Constraints

- `1 <= arr.length <= 10^5`
- `1 <= arr[i], target <= 10^9`
- `arr` is sorted in non-decreasing order.
