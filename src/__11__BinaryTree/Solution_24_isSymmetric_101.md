# Symmetric Tree

**Source:** LeetCode #101 — Symmetric Tree

## Problem Statement

Given the `root` of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

## Example

**Input:** `root = [1, 2, 2, 3, 4, 4, 3]`

```
      1
     / \
    2   2
   / \ / \
  3  4 4  3
```

**Output:** `true`

**Explanation:** The left subtree is a mirror reflection of the right subtree.

**Input:** `root = [1, 2, 2, null, 3, null, 3]`

**Output:** `false`

**Explanation:** The subtrees are not mirror images of each other; the `3` nodes are positioned asymmetrically.

## Constraints

- The number of nodes in the tree is in the range `[1, 1000]`.
- `-100 <= Node.val <= 100`
