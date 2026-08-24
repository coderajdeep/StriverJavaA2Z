# N-th Root of a Number Using Binary Search

**Source:** takeUforward

## Problem Statement

Given two positive integers `N` and `M`, find the `N`-th root of `M`, i.e. find a positive integer `x` such that `x^N = M`.

If such an integer `x` exists, return `x`; otherwise, return `-1` (there is no integer N-th root of `M`).

Solve it in `O(log M)` time using binary search, without using library power/root functions.

## Example

**Input:** N = 3, M = 27
**Output:** 3
**Explanation:** 3^3 = 27.

**Input:** N = 4, M = 69
**Output:** -1
**Explanation:** There is no integer x such that x^4 = 69.

## Constraints

- `1 <= N <= 30`
- `1 <= M <= 10^9`
