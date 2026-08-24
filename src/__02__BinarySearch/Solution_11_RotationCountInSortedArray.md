# Find Out How Many Times an __01__Array Has Been Rotated

**Source:** takeUforward

## Problem Statement

Given an array `arr` of `n` distinct integers that was originally sorted in ascending order and has been rotated between `1` and `n` times, find how many times the array has been rotated.

The number of rotations equals the index at which the minimum element of the array is located.

## Example

**Input:** arr = [4, 5, 6, 7, 0, 1, 2, 3]
**Output:** 4
**Explanation:** The original sorted array [0,1,2,3,4,5,6,7] has been rotated 4 times, and the minimum element (0) is at index 4.

**Input:** arr = [1, 2, 3, 4, 5]
**Output:** 0
**Explanation:** The array has not been rotated; the minimum element (1) is at index 0.

## Constraints

- `1 <= arr.size() <= 10^5`
- `-10^9 <= arr[i] <= 10^9`
- All elements of `arr` are distinct.
