# Flood Fill

**Source:** LeetCode #733 — https://leetcode.com/problems/flood-fill/

## Problem Statement

You are given an image represented by an `m x n` grid of integers `image`, where `image[i][j]` represents the pixel value of the image. You are also given three integers `sr`, `sc`, and `color`. Your task is to perform a **flood fill** on the image starting from the pixel `image[sr][sc]`.

To perform a flood fill:
1. Begin with the starting pixel and change its color to `color`.
2. Perform the same process for each pixel that is **4-directionally connected** (up, down, left, right) to the starting pixel and has the same color as the starting pixel.
3. Keep repeating this process by checking all four directions of the pixels that were just changed, until there are no more adjacent pixels of the original color to change.

Return the modified image after performing the flood fill.

## Example

**Input:** `image = [[1,1,1],[1,1,0],[1,0,1]]`, `sr = 1`, `sc = 1`, `color = 2`

**Output:** `[[2,2,2],[2,2,0],[2,0,1]]`

**Explanation:** Starting from pixel `(1,1)` which has value `1`, all connected pixels of value `1` (up, down, left, right connectivity) are repainted to `2`.

## Constraints

- `m == image.length`
- `n == image[i].length`
- `1 <= m, n <= 50`
- `0 <= image[i][j], color < 2^16`
- `0 <= sr < m`
- `0 <= sc < n`
