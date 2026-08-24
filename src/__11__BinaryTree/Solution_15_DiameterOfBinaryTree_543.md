# Diameter of Binary Tree

**Source:** LeetCode #543 — Diameter of Binary Tree

## Problem Statement

Given the `root` of a binary tree, return the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in the tree. This path may or may not pass through the `root`. The length of a path between two nodes is represented by the number of edges between them.

## Example

**Input:** `root = [1, 2, 3, 4, 5]`

```
      1
     / \
    2   3
   / \
  4   5
```

**Output:** `3`

**Explanation:** The longest path is `[4, 2, 1, 3]` or `[5, 2, 1, 3]`, with a length of 3 edges.

## Constraints

- The number of nodes in the tree is in the range `[1, 10^4]`.
- `-100 <= Node.val <= 100`
