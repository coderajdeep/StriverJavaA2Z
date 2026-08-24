# Subset Sum Equal to Target

**Source:** takeUforward

## Problem Statement

Given an array `arr` of non-negative integers and an integer `target`, determine whether there exists a subset of the elements of `arr` whose sum is exactly equal to `target`.

Return `true` if such a subset exists, otherwise return `false`.

## Example

**Input:** arr = [1, 2, 3, 4], target = 6
**Output:** true
**Explanation:** The subset {2, 4} (or {1, 2, 3}) sums to 6.

**Input:** arr = [1, 2, 7, 3], target = 6
**Output:** true
**Explanation:** The subset {1, 2, 3} sums to 6.

**Input:** arr = [3, 4], target = 10
**Output:** false
**Explanation:** No subset of {3, 4} sums to 10.

## Constraints

- 1 <= arr.length <= 100
- 0 <= arr[i] <= 1000
- 0 <= target <= 10^4
