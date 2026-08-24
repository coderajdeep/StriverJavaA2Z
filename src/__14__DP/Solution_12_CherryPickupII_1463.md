# Cherry Pickup II

**Source:** LeetCode #1463 — https://leetcode.com/problems/cherry-pickup-ii/

## Problem Statement

You are given a `rows x cols` matrix `grid` representing a field of cherries where `grid[i][j]` represents the number of cherries that you can collect from the `(i, j)` cell.

You have two robots that can collect cherries for you:
- Robot #1 is located at the top-left corner `(0, 0)`.
- Robot #2 is located at the top-right corner `(0, cols - 1)`.

Return the maximum number of cherries collection using both robots by following the rules below:
- From a cell `(i, j)`, robots can move to cell `(i + 1, j - 1)`, `(i + 1, j)`, or `(i + 1, j + 1)`.
- When both robots stay in the same cell, only one takes the cherries.
- Both robots cannot move outside of the grid at any moment.
- Both robots should reach the bottom row in `grid`.

## Example

**Input:** grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
**Output:** 24
**Explanation:** Path of robot #1 and #2 are described as follows: (0,0) -> (1,0) -> (2,1) -> (3,2) and (0,2) -> (1,2) -> (2,2) -> (3,2). Total cherries collected = (3 + 2 + 5 + 2) + (1 + 1 + 5 + 1) = 12 + 8 = 20 is one possible path; the __14__DP explores all valid joint paths and finds the maximum total of 24.

**Input:** grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]
**Output:** 28

## Constraints

- rows == grid.length
- cols == grid[i].length
- 2 <= rows, cols <= 70
- 0 <= grid[i][j] <= 100
