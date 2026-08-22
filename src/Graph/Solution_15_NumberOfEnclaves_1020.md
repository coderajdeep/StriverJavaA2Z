# Number of Enclaves

**Source:** LeetCode #1020 — https://leetcode.com/problems/number-of-enclaves/

## Problem Statement

You are given an `m x n` binary matrix `grid`, where `0` represents a sea cell and `1` represents a land cell.

A **move** consists of walking from one land cell to another adjacent (4-directionally) land cell, or walking off the boundary of the grid.

Return the number of land cells in `grid` for which we cannot walk off the boundary of the grid in any number of moves — i.e., the number of land cells that are completely enclosed by sea and cannot reach the border.

## Example

**Input:** `grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]`

**Output:** `3`

**Explanation:** There are three `1`s that are enclosed and cannot escape the boundary through a sequence of 4-directional land moves; one `1` can reach the boundary directly.

**Input:** `grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]`

**Output:** `0`

**Explanation:** All land cells are connected to a boundary cell, so none are enclosed. The typical approach: flood fill (BFS/DFS) from all border land cells to mark cells that can escape, then count the remaining un-marked `1` cells.

## Constraints

- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 500`
- `grid[i][j]` is `0` or `1`
