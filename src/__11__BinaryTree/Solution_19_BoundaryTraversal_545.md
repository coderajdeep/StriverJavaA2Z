# Boundary of Binary Tree

**Source:** LeetCode #545 — Boundary of Binary Tree (Premium/Locked problem; also a classic takeUforward problem)

## Problem Statement

The boundary of a binary tree is the collection of nodes that are on the boundary of the tree, ordered anticlockwise starting from the root.

The boundary consists of, in order:
1. The root node, if it is not a leaf.
2. The left boundary: nodes on the path from the root's left child down to the leftmost leaf, excluding leaves.
3. The leaves, from left to right.
4. The right boundary, in reverse order: nodes on the path from the root's right child down to the rightmost leaf, excluding leaves, listed bottom-up.

If the root itself is a leaf, only the root is added (no duplication of leaves).

Given the `root` of a binary tree, return the values of its boundary nodes, anticlockwise, starting from the root.

## Example

**Input:**

```
        1
       / \
      2   3
     / \    \
    4   5    6
       / \
      7   8
```

**Output:** `[1, 2, 4, 7, 8, 6, 3]`

**Explanation:**
- Root: `1`.
- Left boundary (excluding leaves): `2`.
- Leaves left to right: `4, 7, 8, 6`.
- Right boundary (excluding leaves, bottom-up): `3`.

## Constraints

- The number of nodes in the tree is in the range `[1, 10^4]`.
- `-1000 <= Node.val <= 1000`
