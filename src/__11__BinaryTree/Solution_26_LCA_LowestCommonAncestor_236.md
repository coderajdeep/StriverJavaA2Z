# Lowest Common Ancestor of a Binary Tree

**Source:** LeetCode #236 — Lowest Common Ancestor of a Binary Tree

## Problem Statement

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes `p` and `q` in the tree.

According to the definition of LCA: "The lowest common ancestor is defined between two nodes `p` and `q` as the lowest node in the tree that has both `p` and `q` as descendants (where a node can be a descendant of itself)."

## Example

**Input:** `root = [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]`, `p = 5`, `q = 1`

```
          3
        /   \
       5     1
      / \   / \
     6   2 0   8
        / \
       7   4
```

**Output:** `3`

**Explanation:** The LCA of nodes `5` and `1` is `3`.

**Input:** `root = [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]`, `p = 5`, `q = 4`

**Output:** `5`

**Explanation:** The LCA of nodes `5` and `4` is `5`, since a node can be a descendant of itself according to the LCA definition.

## Constraints

- The number of nodes in the tree is in the range `[2, 10^5]`.
- `-10^9 <= Node.val <= 10^9`
- All `Node.val` are unique.
- `p != q`
- `p` and `q` will both exist in the tree.
