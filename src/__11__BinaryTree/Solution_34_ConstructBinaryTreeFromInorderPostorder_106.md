# Construct Binary Tree from Inorder and Postorder Traversal

**Source:** LeetCode #106 — Construct Binary Tree from Inorder and Postorder Traversal

## Problem Statement

Given two integer arrays `inorder` and `postorder` where `inorder` is the inorder traversal of a binary tree and `postorder` is the postorder traversal of the same tree, construct and return the binary tree.

## Example

**Input:** `inorder = [9, 3, 15, 20, 7]`, `postorder = [9, 15, 7, 20, 3]`

**Output:**

```
    3
   / \
  9  20
    /  \
   15   7
```

**Explanation:** The last element of postorder (`3`) is the root. In inorder, everything left of `3` (`[9]`) forms the left subtree, and everything right of `3` (`[15, 20, 7]`) forms the right subtree. Recursing on these sub-arrays from the end of the postorder array backwards (building right subtree first, then left) reconstructs the tree above.

## Constraints

- `1 <= inorder.length <= 3000`
- `postorder.length == inorder.length`
- `-3000 <= inorder[i], postorder[i] <= 3000`
- `inorder` and `postorder` consist of unique values.
- Each value of `postorder` also appears in `inorder`.
- `inorder` is guaranteed to be the inorder traversal of the tree.
- `postorder` is guaranteed to be the postorder traversal of the tree.
