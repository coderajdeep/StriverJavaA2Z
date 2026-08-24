# Rotate __01__Array by One Place

**Source:** takeUforward

## Problem Statement

Given an array of integers `nums`, rotate the array to the left by one position in-place. The element at index 0 should move to the last index, and every other element shifts one position to the left.

## Example

**Input:** nums = [1, 2, 3, 4, 5]
**Output:** [2, 3, 4, 5, 1]
**Explanation:** Every element shifts one place to the left, and the first element (1) wraps around to the end.

**Input:** nums = [7]
**Output:** [7]
**Explanation:** A single-element array is unchanged by rotation.

## Constraints

- 1 <= nums.length <= 10^5
- -10^9 <= nums[i] <= 10^9
- The rotation must be performed in-place with O(1) extra space.
