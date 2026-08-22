# Maximum Width of Binary Tree

**Source:** LeetCode #662 — Maximum Width of Binary Tree

## Problem Statement

Given the `root` of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels. The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

It is guaranteed that the answer will fit in a 32-bit signed integer.

## Example

**Input:** `root = [1, 3, 2, 5, 3, null, 9]`

```
        1
       / \
      3   2
     / \    \
    5   3    9
```

**Output:** `4`

**Explanation:** The maximum width exists in the third level with the length `4` (`5, 3, null, 9`), counting the null node between `3` and `9` (positions 4 to 7 in a 0-indexed complete tree at that level).

## Constraints

- The number of nodes in the tree is in the range `[1, 3000]`.
- `-100 <= Node.val <= 100`
