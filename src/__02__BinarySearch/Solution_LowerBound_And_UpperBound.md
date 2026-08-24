# Lower Bound and Upper Bound

**Source:** takeUforward

## Problem Statement

Given a sorted array `nums` of `n` integers and an integer `x`, implement two functions:

- **lowerBound(nums, x):** Returns the index of the first element in `nums` that is greater than or equal to `x`. If no such element exists, return `nums.length`.
- **upperBound(nums, x):** Returns the index of the first element in `nums` that is strictly greater than `x`. If no such element exists, return `nums.length`.

Both should be implemented using binary search in `O(log n)` time.

## Example

**Input:** nums = [1, 2, 2, 3, 5, 8], x = 2
**Output:** lowerBound = 1, upperBound = 3
**Explanation:** Index 1 is the first index with a value `>= 2`. Index 3 is the first index with a value `> 2`.

**Input:** nums = [1, 2, 2, 3, 5, 8], x = 9
**Output:** lowerBound = 6, upperBound = 6
**Explanation:** No element is `>= 9`, so both bounds return the array length.

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i], x <= 10^9`
- `nums` is sorted in non-decreasing order.
