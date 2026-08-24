# Find the Repeating and Missing Number

**Source:** takeUforward

## Problem Statement

You are given a read-only array `nums` of size `n` containing numbers from `1` to `n`. Exactly one number from the range `[1, n]` appears twice in the array, and exactly one number from the range is missing from the array.

Find the repeating number and the missing number, and return them as a two-element array `[repeating, missing]`.

## Example

**Input:** nums = [3, 1, 2, 5, 3]
**Output:** [3, 4]
**Explanation:** 3 occurs twice in the array, and 4 is missing from the range [1, 5].

**Input:** nums = [1, 2, 2, 4]
**Output:** [2, 3]
**Explanation:** 2 occurs twice, and 3 is missing from the range [1, 4].

## Constraints

- 2 <= n <= 10^5
- 1 <= nums[i] <= n
- Exactly one value in [1, n] repeats, and exactly one is missing.
