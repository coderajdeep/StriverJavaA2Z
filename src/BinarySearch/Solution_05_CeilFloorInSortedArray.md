# Floor and Ceil in a Sorted Array

**Source:** takeUforward

## Problem Statement

Given a sorted array of `n` integers (which may contain duplicates) and an integer `x`, find the floor and ceil of `x` in the array.

- **Floor** of `x` is the largest element in the array that is less than or equal to `x`.
- **Ceil** of `x` is the smallest element in the array that is greater than or equal to `x`.

If the floor or the ceil does not exist (i.e. no element satisfies the condition), return `-1` for that value.

## Example

**Input:** nums = [3, 4, 4, 7, 8, 10], x = 5
**Output:** floor = 4, ceil = 7
**Explanation:** 4 is the largest element `<= 5`, and 7 is the smallest element `>= 5`.

**Input:** nums = [3, 4, 4, 7, 8, 10], x = 2
**Output:** floor = -1, ceil = 3
**Explanation:** No element in the array is `<= 2`, so floor doesn't exist. 3 is the smallest element `>= 2`.

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i], x <= 10^9`
- `nums` is sorted in non-decreasing order.
