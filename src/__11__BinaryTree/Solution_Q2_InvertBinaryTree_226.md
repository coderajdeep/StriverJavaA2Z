# Invert Binary Tree

**Source:** LeetCode #226 — Invert Binary Tree

## Problem Statement

Given the `root` of a binary tree, invert the tree, and return its root. Inverting a binary tree means swapping the left and right children of every node in the tree.

## Example

**Input:** `root = [4, 2, 7, 1, 3, 6, 9]`

```
      4                4
     / \              / \
    2   7    -->     7   2
   / \ / \           / \ / \
  1  3 6  9         9  6 3  1
```

**Output:** `[4, 7, 2, 9, 6, 3, 1]`

**Explanation:** Every node's left and right children are swapped, recursively, throughout the tree.

## Constraints

- The number of nodes in the tree is in the range `[0, 100]`.
- `-100 <= Node.val <= 100`
