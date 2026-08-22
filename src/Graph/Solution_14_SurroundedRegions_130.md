# Surrounded Regions

**Source:** LeetCode #130 — https://leetcode.com/problems/surrounded-regions/

## Problem Statement

You are given an `m x n` matrix `board` containing letters `'X'` and `'O'`. Capture all regions that are **4-directionally surrounded** by `'X'`.

A region is captured by flipping all `'O'`s into `'X'`s in that surrounded region. A region is **not** captured (and stays as `'O'`) if it is connected — directly or indirectly through other `'O'` cells — to an `'O'` cell on the border of the board.

## Example

**Input:**
```
board = [["X","X","X","X"],
         ["X","O","O","X"],
         ["X","X","O","X"],
         ["X","O","X","X"]]
```

**Output:**
```
[["X","X","X","X"],
 ["X","X","X","X"],
 ["X","X","X","X"],
 ["X","O","X","X"]]
```

**Explanation:** The `'O'`s in the middle (rows 1–2) are completely surrounded by `'X'` and get flipped. The `'O'` at `(3,1)` touches the border, so it (and anything connected to it) is not flipped. The typical approach: run BFS/DFS from every border `'O'` to mark cells that must survive, then flip all unmarked `'O'`s to `'X'`.

## Constraints

- `m == board.length`
- `n == board[i].length`
- `1 <= m, n <= 200`
- `board[i][j]` is `'X'` or `'O'`
