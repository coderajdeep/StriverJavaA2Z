# Binary Tree Preorder Traversal

**Source:** LeetCode #144 — Binary Tree Preorder Traversal

## Problem Statement

Given the `root` of a binary tree, return the preorder traversal of its nodes' values (root, then left subtree, then right subtree).

## Example

**Input:** `root = [1, null, 2, 3]`

```
1
 \
  2
 /
3
```

**Output:** `[1, 2, 3]`

**Explanation:** Visit the root (1) first, then traverse the left subtree (none directly), then the right subtree rooted at 2 — visiting 2 before its left child 3.

## Constraints

- The number of nodes in the tree is in the range `[0, 100]`.
- `-100 <= Node.val <= 100`

Follow-up: Recursive solution is trivial, could you do it iteratively?
