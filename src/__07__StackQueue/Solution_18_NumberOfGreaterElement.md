# Number of Greater Elements on the Right Side

**Source:** takeUforward / GFG-style

## Problem Statement

Given an array `arr` of `n` integers and a list of `indices` (query indices into `arr`), for each queried index `idx` count how many elements to the **right** of `arr[idx]` (i.e., at positions greater than `idx`) are strictly **greater** than `arr[idx]`.

Return a list of answers, one per query index, in the same order as the queries.

A brute-force approach would scan rightward from each queried index in O(n) per query. The efficient approach precomputes, for **every** index in the array in a single pass, the count of greater elements to its right using a modified merge sort: during the merge step, whenever a left-half element is smaller than a right-half element being merged in, all remaining elements in the right half's current run are greater than it, so their count is added at once, giving an overall O(n log n) preprocessing and O(1) per query.

## Example

**Input:** arr = [3, 4, 2, 7, 5, 8], indices = [0, 2, 5]
**Output:** [4, 3, 0]
**Explanation:**
- Index 0 (value 3): to its right are [4, 2, 7, 5, 8]; elements strictly greater than 3 are 4, 7, 5, 8 → 4.
- Index 2 (value 2): to its right are [7, 5, 8], all three are greater than 2 → 3.
- Index 5 (value 8): no elements to its right → 0.

## Constraints

- 1 <= arr.length <= 10^5
- -10^9 <= arr[i] <= 10^9
- 1 <= indices.length <= arr.length
- 0 <= indices[i] < arr.length

**Note:** This is not a standard, single canonical LeetCode problem — the filename has no LeetCode number. The problem statement above is written to match the code's actual behavior (`Solution_18_NumberOfGreaterElement.count_NGE`, using a merge-sort-based inversion count), which counts, per queried index, the number of strictly greater elements to the right.
