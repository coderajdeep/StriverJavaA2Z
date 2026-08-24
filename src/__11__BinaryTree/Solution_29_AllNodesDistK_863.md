# All Nodes Distance K in Binary Tree

**Source:** LeetCode #863 — All Nodes Distance K in Binary Tree

## Problem Statement

Given the `root` of a binary tree, the value of a target node `target`, and an integer `k`, return an array of the values of all nodes that have a distance `k` from the target node.

You can return the answer in any order.

## Example

**Input:** `root = [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]`, `target = 5`, `k = 2`

```
          3
        /   \
       5     1
      / \   / \
     6   2 0   8
        / \
       7   4
```

**Output:** `[7, 4, 1]`

**Explanation:** The nodes at distance 2 from the target node (value `5`) are `7`, `4`, and `1` (going down through `2` to reach `7` and `4`, and up through `3` to reach `1`).

## Constraints

- The number of nodes in the tree is in the range `[1, 500]`.
- `0 <= Node.val <= 500`
- All `Node.val` are unique.
- `target` is the value of one of the nodes in the tree.
- `0 <= k <= 1000`
