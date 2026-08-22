# Amount of Time for Binary Tree to Be Infected

**Source:** LeetCode #2385 — Amount of Time for Binary Tree to Be Infected

## Problem Statement

You are given the `root` of a binary tree with unique values, and an integer `start`. At minute `0`, an infection starts from the node with value `start`.

Each minute, a node becomes infected if:
- The node is currently uninfected.
- The node is adjacent to an infected node (adjacency includes parent, left child, and right child — i.e., the tree is treated as an undirected graph).

Return the number of minutes needed for the entire tree to be infected.

## Example

**Input:** `root = [1, 5, 3, null, 4, 10, 6, 9, 2]`, `start = 3`

```
            1
           / \
          5   3
           \ / \
           4 10  6
          / \
         9   2
```

**Output:** `4`

**Explanation:** Starting from node `3`, the infection spreads: minute 1 infects `1`, `10`, `6`; minute 2 infects `5`; minute 3 infects `4`; minute 4 infects `9` and `2`. The whole tree is infected after 4 minutes.

## Constraints

- The number of nodes in the tree is in the range `[1, 10^5]`.
- `1 <= Node.val <= 10^5`
- All `Node.val` are unique.
- `1 <= start <= 10^5`
- `start` is the value of a node in the tree.
