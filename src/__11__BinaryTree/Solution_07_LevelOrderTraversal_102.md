# Binary Tree Level Order Traversal

**Source:** LeetCode #102 — Binary Tree Level Order Traversal

## Problem Statement

Given the `root` of a binary tree, return the level order traversal of its nodes' values (i.e., from left to right, level by level).

## Example

**Input:** `root = [3, 9, 20, null, null, 15, 7]`

```
    3
   / \
  9  20
    /  \
   15   7
```

**Output:** `[[3], [9, 20], [15, 7]]`

**Explanation:** Level 0 contains just the root (3). Level 1 contains 9 and 20, read left to right. Level 2 contains 15 and 7, read left to right.

## Constraints

- The number of nodes in the tree is in the range `[0, 2000]`.
- `-1000 <= Node.val <= 1000`
