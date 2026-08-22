# Number of Islands

**Source:** LeetCode #200 — https://leetcode.com/problems/number-of-islands/

## Problem Statement

Given an `m x n` 2D binary grid `grid` which represents a map of `'1'`s (land) and `'0'`s (water), return the number of **islands**.

An island is surrounded by water and is formed by connecting adjacent lands horizontally, vertically, **or diagonally**. You may assume all four edges of the grid are all surrounded by water.

*(Note: the classic LeetCode 200 formulation only connects land 4-directionally (horizontally/vertically). This solution's `dx`/`dy` arrays include the four diagonal directions as well, so it solves the 8-directional variant of "Number of Islands" — commonly presented on takeUforward as "Number of Islands II"/8-directional islands. Trusting the code, the problem statement below reflects 8-directional (horizontal, vertical, and diagonal) connectivity.)*

## Example

**Input:**
```
grid = [["1","1","0","0","0"],
        ["0","1","0","0","1"],
        ["1","0","0","1","1"],
        ["0","0","0","0","0"],
        ["1","0","1","0","1"]]
```

**Output:** `3`

**Explanation:** Using 8-directional connectivity (including diagonals), cells that touch diagonally are merged into the same island, reducing what would otherwise be a higher count under strict 4-directional connectivity.

## Constraints

- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 300`
- `grid[i][j]` is `'0'` or `'1'`
