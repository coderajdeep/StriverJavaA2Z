# Rotting Oranges

**Source:** LeetCode #994 — https://leetcode.com/problems/rotting-oranges/

## Problem Statement

You are given an `m x n` grid where each cell can have one of three values:

- `0` representing an empty cell,
- `1` representing a fresh orange, or
- `2` representing a rotten orange.

Every minute, any fresh orange that is **4-directionally adjacent** to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return `-1`.

## Example

**Input:** `grid = [[2,1,1],[1,1,0],[0,1,1]]`

**Output:** `4`

**Explanation:** The rot spreads outward from the initial rotten orange at `(0,0)` level by level (multi-source BFS); after 4 minutes every fresh orange has rotted.

**Input:** `grid = [[2,1,1],[0,1,1],[1,0,1]]`

**Output:** `-1`

**Explanation:** The orange at cell `(2,0)` is isolated and can never become rotten because rot cannot cross diagonally or through an empty cell.

## Constraints

- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 10`
- `grid[i][j]` is `0`, `1`, or `2`
