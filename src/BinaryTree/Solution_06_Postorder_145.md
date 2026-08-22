# Binary Tree Postorder Traversal

**Source:** LeetCode #145 — Binary Tree Postorder Traversal

## Problem Statement

Given the `root` of a binary tree, return the postorder traversal of its nodes' values (left subtree, then right subtree, then root).

## Example

**Input:** `root = [1, null, 2, 3]`

```
1
 \
  2
 /
3
```

**Output:** `[3, 2, 1]`

**Explanation:** Traverse the subtree rooted at 2 first: its left child 3, then 2, and finally visit the root 1 last.

## Constraints

- The number of nodes in the tree is in the range `[0, 100]`.
- `-100 <= Node.val <= 100`

Follow-up: Recursive solution is trivial, could you do it iteratively?
