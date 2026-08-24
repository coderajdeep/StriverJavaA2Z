# Top View of Binary Tree

**Source:** takeUforward

## Problem Statement

Given a binary tree, print the top view of it. The top view of a binary tree is the set of nodes visible when the tree is viewed from the top.

For every vertical line (column), the topmost node encountered at that horizontal distance from the root is part of the top view. Assign the root a horizontal distance (vertical level) of 0; each left child gets `parent's level - 1` and each right child gets `parent's level + 1`. Traverse the tree level by level (BFS), and for each vertical level, only keep the value of the first node encountered (i.e., the one closest to the top). Return the top view values ordered from the leftmost vertical level to the rightmost.

## Example

**Input:**

```
        1
       / \
      2   3
       \
        4
         \
          5
```

**Output:** `[2, 1, 3]`

**Explanation:** Vertical level -1 has only `2` (first, and only, node seen there). Level 0 has `1`. Level 1 has `3` (node `4` at level 1 comes later in BFS order and is hidden). Reading left to right by vertical level gives `[2, 1, 3]`.

## Constraints

- The number of nodes in the tree is in the range `[0, 10^4]`.
- `-10^5 <= Node.val <= 10^5`
