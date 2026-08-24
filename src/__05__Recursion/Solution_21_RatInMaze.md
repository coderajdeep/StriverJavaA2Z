# Rat in a Maze

**Source:** takeUforward

## Problem Statement

Given a square grid (maze) of size `N x N`, a rat starts at the top-left cell `(0, 0)` and must reach the bottom-right cell `(N-1, N-1)`. A cell with value `1` is open (the rat can walk on it) and a cell with value `0` is blocked. The rat can move in four directions: Up ('U'), Down ('D'), Left ('L'), and Right ('R'). The rat cannot revisit a cell that is already part of the current path, and cannot step outside the grid or onto a blocked cell.

Find all possible paths that the rat can take to reach the destination from the source. Each path is represented as a string built from the direction characters describing the sequence of moves, and the source cell itself contributes no character to the path unless it is also the destination. Return the list of all such path strings sorted lexicographically. If no path exists, return an empty list.

## Example

**Input:** grid = [[1,0,0,0],[1,1,0,1],[1,1,0,0],[0,1,1,1]]
**Output:** ["DDRDRR","DRDDRR"]
**Explanation:** These are the two possible paths of 1s from (0,0) to (3,3) using only Up/Down/Left/Right moves through open cells without revisiting a cell.

**Input:** grid = [[1,0],[0,1]]
**Output:** []
**Explanation:** There is no path from (0,0) to (1,1) since diagonal movement is not allowed and both other adjacent cells are blocked / unreachable.

## Constraints

- `2 <= N <= 5`
- `grid[i][j]` is `0` or `1`.
- `grid[0][0] = 1` (unless the maze has no valid start).
