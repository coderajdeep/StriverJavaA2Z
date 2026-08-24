# Union of Two Sorted Arrays

**Source:** takeUforward

## Problem Statement

Given two sorted arrays `nums1` and `nums2` (each may contain duplicate elements within itself), find their union, i.e., the set of all distinct elements present in either array, returned as a sorted array.

## Example

**Input:** nums1 = [1, 2, 2, 3, 4], nums2 = [2, 3, 5]
**Output:** [1, 2, 3, 4, 5]
**Explanation:** The distinct elements present in either array, in sorted order, are 1, 2, 3, 4, and 5.

**Input:** nums1 = [1, 1, 1, 1], nums2 = [2, 2, 2, 2]
**Output:** [1, 2]
**Explanation:** The only distinct elements across both arrays are 1 and 2.

## Constraints

- 0 <= nums1.length, nums2.length <= 10^5
- -10^9 <= nums1[i], nums2[i] <= 10^9
- Both nums1 and nums2 are individually sorted in non-decreasing order.
