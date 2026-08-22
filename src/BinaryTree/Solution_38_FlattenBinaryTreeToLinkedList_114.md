# Flatten Binary Tree to Linked List

**Source:** LeetCode #114 — Flatten Binary Tree to Linked List

## Problem Statement

Given the `root` of a binary tree, flatten the tree into a "linked list":

- The "linked list" should use the same `TreeNode` class where the `right` child pointer points to the next node in the list and the `left` child pointer is always `null`.
- The "linked list" should be in the same order as a preorder traversal of the binary tree.

## Example

**Input:** `root = [1, 2, 5, 3, 4, null, 6]`

```
      1
     / \
    2   5
   / \    \
  3   4    6
```

**Output:** `[1, null, 2, null, 3, null, 4, null, 5, null, 6]`

**Explanation:** After flattening, the tree becomes a right-skewed "linked list" following preorder order: `1 -> 2 -> 3 -> 4 -> 5 -> 6`, with every `left` pointer set to `null`.

## Constraints

- The number of nodes in the tree is in the range `[0, 2000]`.
- `-100 <= Node.val <= 100`

Follow-up: Can you flatten the tree in-place (with O(1) extra space)?
