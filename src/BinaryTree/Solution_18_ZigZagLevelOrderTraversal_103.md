# Binary Tree Zigzag Level Order Traversal

**Source:** LeetCode #103 — Binary Tree Zigzag Level Order Traversal

## Problem Statement

Given the `root` of a binary tree, return the zigzag level order traversal of its nodes' values (i.e., from left to right, then right to left for the next level and alternate between).

## Example

**Input:** `root = [3, 9, 20, null, null, 15, 7]`

```
    3
   / \
  9  20
    /  \
   15   7
```

**Output:** `[[3], [20, 9], [15, 7]]`

**Explanation:** Level 0 is read left-to-right: `[3]`. Level 1 is read right-to-left: `[20, 9]`. Level 2 goes back to left-to-right: `[15, 7]`.

## Constraints

- The number of nodes in the tree is in the range `[0, 2000]`.
- `-100 <= Node.val <= 100`
