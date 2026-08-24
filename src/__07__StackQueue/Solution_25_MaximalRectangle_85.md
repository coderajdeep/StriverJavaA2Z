# Maximal Rectangle

**Source:** LeetCode #85 — Maximal Rectangle

## Problem Statement

Given a `rows x cols` binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

## Example

**Input:** matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
**Output:** 6
**Explanation:** The maximal rectangle is shown in the above picture, formed by rows 1–2 and columns 2–4, with an area of 6.

**Input:** matrix = [["0"]]
**Output:** 0

## Constraints

- rows == matrix.length
- cols == matrix[i].length
- 1 <= row, cols <= 200
- matrix[i][j] is '0' or '1'.

**Approach note:** This is solved by treating each row as the base of a histogram (accumulating consecutive 1's column-wise as bar heights) and repeatedly applying the Largest Rectangle in Histogram (LeetCode #84) algorithm on each row's histogram.
