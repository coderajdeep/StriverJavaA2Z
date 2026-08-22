# Largest Subarray with Sum 0

**Source:** takeUforward / GeeksforGeeks

## Problem Statement

Given an array `arr` of integers (which may include positive, negative, and zero values), find the length of the longest contiguous subarray whose elements sum to exactly `0`.

If there is no such subarray, return 0.

## Example

**Input:** arr = [15, -2, 2, -8, 1, 7, 10, 23]
**Output:** 5
**Explanation:** The subarray [-2, 2, -8, 1, 7] sums to 0 and has length 5.

**Input:** arr = [1, 2, 3]
**Output:** 0
**Explanation:** No subarray sums to 0.

## Constraints

- 1 <= arr.length <= 10^5
- -10^4 <= arr[i] <= 10^4

## Discrepancy Note

The filename `Solution_32_LargestSubArrayWithGivenSum.java` suggests this solves "longest subarray with a given sum k" for an arbitrary target, similar to `Solution_14_LargestSubArrayWithGivenSum.java`. However, the method signature is `maxLen(int[] arr)` — it takes **no** `k` parameter at all, and internally it looks up `prefixSum.get(sum)` (equivalent to target `k = 0`) instead of `prefixSum.get(sum - k)`. This matches the well-known GeeksforGeeks problem "Largest Subarray with 0 Sum" rather than a generic given-sum problem. The problem statement above reflects the code's actual behavior (target sum hardcoded to 0).
