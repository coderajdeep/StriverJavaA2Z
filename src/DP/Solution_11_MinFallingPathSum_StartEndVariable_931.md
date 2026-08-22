# Minimum Falling Path Sum

**Source:** LeetCode #931 — https://leetcode.com/problems/minimum-falling-path-sum/

## Problem Statement

Given an `n x n` array of integers `matrix`, return the minimum sum of any falling path through `matrix`.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position `(row, col)` will be `(row + 1, col - 1)`, `(row + 1, col)`, or `(row + 1, col + 1)`.

## Example

**Input:** matrix = [[2,1,3],[6,5,4],[7,8,9]]
**Output:** 13
**Explanation:** There are two falling paths with a minimum sum: [1,4,7] and [1,5,7]. Both sum to 13.

**Input:** matrix = [[-19,57],[-40,-5]]
**Output:** -59
**Explanation:** The falling path with a minimum sum is [-19,-40].

## Constraints

- n == matrix.length == matrix[i].length
- 1 <= n <= 100
- -100 <= matrix[i][j] <= 100
