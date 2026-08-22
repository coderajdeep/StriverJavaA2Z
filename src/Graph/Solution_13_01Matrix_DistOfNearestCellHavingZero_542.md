# 01 Matrix

**Source:** LeetCode #542 — https://leetcode.com/problems/01-matrix/

## Problem Statement

Given an `m x n` binary matrix `mat`, return the distance of the nearest `0` for each cell.

The distance between two adjacent cells is `1`, where "adjacent" means the cells share a 4-directional edge (up, down, left, right).

## Example

**Input:** `mat = [[0,0,0],[0,1,0],[0,0,0]]`

**Output:** `[[0,0,0],[0,1,0],[0,0,0]]`

**Explanation:** Every `1` cell already has a directly adjacent `0`, so its distance is `1`... actually here the single `1` at `(1,1)` has distance `1` from its nearest `0`.

**Input:** `mat = [[0,0,0],[0,1,0],[1,1,1]]`

**Output:** `[[0,0,0],[0,1,0],[1,2,1]]`

**Explanation:** A multi-source BFS starting from all `0` cells simultaneously expands outward, assigning each `1` cell the minimum number of steps to reach any `0`.

## Constraints

- `m == mat.length`
- `n == mat[i].length`
- `1 <= m, n <= 10^4`
- `1 <= m * n <= 10^4`
- `mat[i][j]` is `0` or `1`
- There is at least one `0` in `mat`
