# Construct Binary Tree from Preorder and Inorder Traversal

**Source:** LeetCode #105 — Construct Binary Tree from Preorder and Inorder Traversal

## Problem Statement

Given two integer arrays `preorder` and `inorder` where `preorder` is the preorder traversal of a binary tree and `inorder` is the inorder traversal of the same tree, construct and return the binary tree.

## Example

**Input:** `preorder = [3, 9, 20, 15, 7]`, `inorder = [9, 3, 15, 20, 7]`

**Output:**

```
    3
   / \
  9  20
    /  \
   15   7
```

**Explanation:** The first element of preorder (`3`) is the root. In inorder, everything left of `3` (`[9]`) forms the left subtree, and everything right of `3` (`[15, 20, 7]`) forms the right subtree. Recursing on these sub-arrays (using the corresponding preorder slices) reconstructs the tree above.

## Constraints

- `1 <= preorder.length <= 3000`
- `inorder.length == preorder.length`
- `-3000 <= preorder[i], inorder[i] <= 3000`
- `preorder` and `inorder` consist of unique values.
- Each value of `inorder` also appears in `preorder`.
- `preorder` is guaranteed to be the preorder traversal of the tree.
- `inorder` is guaranteed to be the inorder traversal of the tree.
