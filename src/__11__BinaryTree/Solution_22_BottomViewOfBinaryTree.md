# Bottom View of Binary Tree

**Source:** takeUforward

## Problem Statement

Given a binary tree, print the bottom view of it. The bottom view of a binary tree is the set of nodes visible when the tree is viewed from the bottom.

For every vertical line (column), the bottommost node encountered at that horizontal distance from the root is part of the bottom view. Assign the root a horizontal distance (vertical level) of 0; each left child gets `parent's level - 1` and each right child gets `parent's level + 1`. Traverse the tree level by level (BFS), and for each vertical level, keep overwriting the recorded value so that the last node encountered at that level (i.e., the one closest to the bottom) remains. Return the bottom view values ordered from the leftmost vertical level to the rightmost.

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

**Output:** `[2, 4, 5, 3]`

**Explanation:** Vertical level -1 has `2`. Level 0 initially has `1`, but is later overwritten by `4` (child of `2` at level 0). Level 1 has `3` first, then overwritten by `5`. Reading left to right by vertical level gives `[2, 4, 5, 3]`.

## Constraints

- The number of nodes in the tree is in the range `[0, 10^4]`.
- `-10^5 <= Node.val <= 10^5`
