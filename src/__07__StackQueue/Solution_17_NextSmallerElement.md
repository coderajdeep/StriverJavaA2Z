# Next Smaller Element

**Source:** takeUforward

## Problem Statement

Given an array `arr` of `n` integers, find the Next Smaller Element for every element of the array. The Next Smaller Element for an element `x` is the first element to the right of `x` in the array that is smaller than `x`. If no such element exists (i.e., `x` is the smallest among all elements to its right, or it is the last element), the next smaller element for `x` is `-1`.

Return an array `result` of size `n` where `result[i]` is the next smaller element for `arr[i]`.

This is efficiently solved using a monotonic stack traversed from right to left: for each element, pop all stack elements greater than or equal to the current element, then the new stack top (if any) is the next smaller element; finally push the current element.

## Example

**Input:** arr = [4, 5, 2, 10, 8]
**Output:** [2, 2, -1, 8, -1]
**Explanation:**
- For 4, the next smaller element to its right is 2.
- For 5, the next smaller element to its right is 2.
- For 2, there is no smaller element to its right, so -1.
- For 10, the next smaller element to its right is 8.
- For 8, there is no element to its right, so -1.

## Constraints

- 1 <= arr.length <= 10^5
- -10^9 <= arr[i] <= 10^9
