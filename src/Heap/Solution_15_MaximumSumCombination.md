# Maximum Sum Combination

**Source:** takeUforward / GeeksforGeeks — "Maximum Sum Combination"

## Problem Statement

Given two equally-sized arrays `nums1` and `nums2` and an integer `k`, find `k` maximum sum combinations from all possible sum combinations, where a sum combination is formed by adding one element from `nums1` and one element from `nums2` (i.e., `nums1[i] + nums2[j]`). Return the `k` largest such sums in decreasing order.

The solution sorts both arrays in descending order, then uses a max-heap over pairs of indices `(i, j)` starting from `(n1-1, n2-1)` (the largest element of each sorted array), pushing neighboring index pairs `(i-1, j)` and `(i, j-1)` as each pair is popped, using a visited-set to avoid processing the same index pair twice.

## Example

**Input:** nums1 = [3, 2], nums2 = [1, 4], k = 2
**Output:** [7, 6]
**Explanation:** All possible sums are 3+1=4, 3+4=7, 2+1=3, 2+4=6. The 2 largest sums are 7 and 6.

## Constraints

- 1 <= nums1.length == nums2.length <= 10^5
- 1 <= k <= nums1.length
- 1 <= nums1[i], nums2[i] <= 10^5

## Complexity

- Time complexity: O(k log k)
- Space complexity: O(k)
