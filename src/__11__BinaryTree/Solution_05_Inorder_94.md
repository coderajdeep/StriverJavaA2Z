# Binary Tree Inorder Traversal

**Source:** LeetCode #94 — Binary Tree Inorder Traversal

## Problem Statement

Given the `root` of a binary tree, return the inorder traversal of its nodes' values (left subtree, then root, then right subtree).

## Example

**Input:** `root = [1, null, 2, 3]`

```
1
 \
  2
 /
3
```

**Output:** `[1, 3, 2]`

**Explanation:** The left subtree of root is empty, so visit root (1) first, then traverse the subtree rooted at 2 in order: left child 3, then 2 itself.

## Constraints

- The number of nodes in the tree is in the range `[0, 100]`.
- `-100 <= Node.val <= 100`

Follow-up: Recursive solution is trivial, could you do it iteratively?
