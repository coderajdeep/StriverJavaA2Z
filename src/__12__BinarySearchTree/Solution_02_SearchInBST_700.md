# Search in a Binary Search Tree

**Source:** LeetCode #700 — https://leetcode.com/problems/search-in-a-binary-search-tree/

## Problem Statement

You are given the `root` of a binary search tree (BST) and an integer `val`.

Find the node in the BST whose value equals `val` and return the subtree rooted with that node. If such a node does not exist, return `null`.

## Example

**Input:** root = [4,2,7,1,3], val = 2
**Output:** [2,1,3]
**Explanation:** The node with value 2 is found, and the subtree rooted at that node ([2,1,3]) is returned.

**Input:** root = [4,2,7,1,3], val = 5
**Output:** []
**Explanation:** There is no node with value 5 in the BST, so null (empty tree) is returned.

## Constraints

- The number of nodes in the tree is in the range `[1, 5000]`.
- `1 <= Node.val <= 10^7`
- `root` is a binary search tree.
- `1 <= val <= 10^7`
