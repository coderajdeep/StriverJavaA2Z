# Power Set

**Source:** takeUforward

## Problem Statement

Given an integer array `nums` of distinct (or possibly non-distinct) elements, return the power set — all possible subsets (the set of all subsets), including the empty subset and the array itself.

For every index in the array, recursively branch into two choices: "do not take" the current element and move on, or "take" the current element, add it to the running subset, recurse, and then remove it (backtrack) before returning. When the index reaches the end of the array, the currently built subset is a valid subset to add to the answer.

## Example

**Input:** nums = [1,2,3]
**Output:** [[],[3],[2],[2,3],[1],[1,3],[1,2],[1,2,3]]
**Explanation:** All 2^3 = 8 subsets of {1,2,3} are generated (order of subsets/elements may vary by implementation).

**Input:** nums = [0]
**Output:** [[],[0]]

## Constraints

- `1 <= nums.length <= 10`
- `-10 <= nums[i] <= 10`
