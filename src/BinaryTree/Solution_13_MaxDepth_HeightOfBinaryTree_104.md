# Maximum Depth of Binary Tree

**Source:** LeetCode #104 — Maximum Depth of Binary Tree

## Problem Statement

Given the `root` of a binary tree, return its maximum depth (height): the number of nodes along the longest path from the root node down to the farthest leaf node.

## Example

**Input:** `root = [3, 9, 20, null, null, 15, 7]`

```
    3
   / \
  9  20
    /  \
   15   7
```

**Output:** `3`

**Explanation:** The longest root-to-leaf path is 3 -> 20 -> 15 (or 3 -> 20 -> 7), which has 3 nodes.

## Constraints

- The number of nodes in the tree is in the range `[0, 10^4]`.
- `-100 <= Node.val <= 100`
