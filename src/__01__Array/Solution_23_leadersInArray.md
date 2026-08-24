# Leaders in an __01__Array

**Source:** takeUforward

## Problem Statement

Given an array `nums`, an element is called a "leader" if it is strictly greater than all the elements to its right side. The last element of the array is always a leader.

Find and return all the leaders in the array, in the order they appear in the original array (from left to right).

## Example

**Input:** nums = [16, 17, 4, 3, 5, 2]
**Output:** [17, 5, 2]
**Explanation:** 17 is greater than all elements to its right (4, 3, 5, 2). 5 is greater than all elements to its right (2). 2 is the last element, so it is trivially a leader.

**Input:** nums = [1, 2, 3, 4, 0]
**Output:** [4, 0]
**Explanation:** Only 4 (greater than everything after it) and 0 (the last element) qualify as leaders.

## Constraints

- 1 <= nums.length <= 10^5
- -10^9 <= nums[i] <= 10^9
