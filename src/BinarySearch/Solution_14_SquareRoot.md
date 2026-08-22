# Find Square Root of a Number in log n Time

**Source:** takeUforward

## Problem Statement

Given a non-negative integer `n`, find and return its square root. If `n` is not a perfect square, return the floor value of `sqrt(n)`, i.e. the greatest integer whose square is less than or equal to `n`.

Solve it using binary search in `O(log n)` time, without using any built-in square root function.

## Example

**Input:** n = 36
**Output:** 6
**Explanation:** sqrt(36) = 6, which is a perfect square.

**Input:** n = 28
**Output:** 5
**Explanation:** sqrt(28) = 5.29..., so the floor value is 5.

## Constraints

- `0 <= n <= 2^31 - 1`
