# Vertical Order Traversal of a Binary Tree

**Source:** LeetCode #987 — Vertical Order Traversal of a Binary Tree

## Problem Statement

Given the `root` of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position `(row, col)`, its left and right children will be at positions `(row + 1, col - 1)` and `(row + 1, col + 1)` respectively. The root of the tree is at `(0, 0)`.

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case:

- Sort these nodes by their values.

Return the vertical order traversal of the binary tree.

## Example

**Input:** `root = [3, 9, 20, null, null, 15, 7]`

```
    3
   / \
  9  20
    /  \
   15   7
```

**Output:** `[[9], [3, 15], [20], [7]]`

**Explanation:**
- Column -1: only node `9`.
- Column 0: node `3` (row 0) and node `15` (row 2), so `[3, 15]`.
- Column 1: only node `20`.
- Column 2: only node `7`.

## Constraints

- The number of nodes in the tree is in the range `[1, 1000]`.
- `0 <= Node.val <= 1000`
