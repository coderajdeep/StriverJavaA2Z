# Binary Tree Right Side View

**Source:** LeetCode #199 — Binary Tree Right Side View

## Problem Statement

Given the `root` of a binary tree, imagine yourself standing on the right side of it. Return the values of the nodes you can see, ordered from top to bottom.

## Example

**Input:** `root = [1, 2, 3, null, 5, null, 4]`

```
   1
  / \
 2   3
  \    \
   5    4
```

**Output:** `[1, 3, 4]`

**Explanation:** Standing on the right side, you see `1` at level 0, `3` at level 1 (it is the rightmost node visible even though `5` exists further left), and `4` at level 2.

## Constraints

- The number of nodes in the tree is in the range `[0, 100]`.
- `-100 <= Node.val <= 100`
