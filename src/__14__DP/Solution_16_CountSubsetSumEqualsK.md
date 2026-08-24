# Count Subsets with Sum K (Perfect Sum Problem)

**Source:** takeUforward

## Problem Statement

Given an array `arr` of non-negative integers and an integer `target`, find the total number of subsets of `arr` whose elements sum up to `target`. Since the answer may be large, return it modulo `10^9 + 7`.

Note: When the array contains zeros, subsets that differ only by inclusion/exclusion of a zero element are counted as distinct subsets (e.g., if `target = 0` and `arr[0] = 0`, both the empty subset and the subset `{0}` count separately).

## Example

**Input:** arr = [1, 2, 2, 3], target = 3
**Output:** 3
**Explanation:** The subsets that sum to 3 are: {1, 2} (using first 2), {1, 2} (using second 2), and {3}.

**Input:** arr = [1, 1, 4, 5], target = 5
**Output:** 3
**Explanation:** The subsets summing to 5 are: {1, 4} (two ways using either 1) and {5}.

## Constraints

- 1 <= arr.length <= 100
- 0 <= arr[i] <= 1000
- 0 <= target <= 10^4
