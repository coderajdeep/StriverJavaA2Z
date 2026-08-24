# Construct Binary Search Tree from Preorder Traversal

**Source:** LeetCode #1008 — https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

## Problem Statement

Given an array of integers `preorder`, which represents the **preorder traversal** of a BST (i.e., binary search tree), construct the tree and return its root.

It is guaranteed that there is always a valid binary search tree with the given requirements for the input, and that each value of `preorder` is unique.

## Example

**Input:** preorder = [8,5,1,7,10,12]
**Output:** [8,5,10,1,7,null,12]
**Explanation:** The tree built has root 8, with left subtree rooted at 5 (containing 1 and 7) and right subtree rooted at 10 (containing 12).

**Input:** preorder = [1,3]
**Output:** [1,null,3]

## Constraints

- `1 <= preorder.length <= 100`
- `1 <= preorder[i] <= 10^8`
- All the values of `preorder` are unique.
