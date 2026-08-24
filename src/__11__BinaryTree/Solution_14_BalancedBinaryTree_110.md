# Balanced Binary Tree

**Source:** LeetCode #110 — Balanced Binary Tree

## Problem Statement

Given a binary tree, determine if it is height-balanced. A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differs by more than 1.

## Example

**Input:** `root = [3, 9, 20, null, null, 15, 7]`

```
    3
   / \
  9  20
    /  \
   15   7
```

**Output:** `true`

**Explanation:** Every node's left and right subtree heights differ by at most 1, so the tree is balanced.

**Input:** `root = [1, 2, 2, 3, 3, null, null, 4, 4]`

**Output:** `false`

**Explanation:** The subtree rooted at the first `2` has a height difference greater than 1 between its left and right subtrees.

## Constraints

- The number of nodes in the tree is in the range `[0, 5000]`.
- `-10^4 <= Node.val <= 10^4`
