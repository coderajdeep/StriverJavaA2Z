# Find Bottom Left Tree Value

**Source:** LeetCode #513 — Find Bottom Left Tree Value

## Problem Statement

Given the `root` of a binary tree, return the leftmost value in the last row of the tree.

## Example

**Input:** `root = [2, 1, 3]`

```
  2
 / \
1   3
```

**Output:** `1`

**Input:** `root = [1, 2, 3, 4, null, 5, 6, null, null, 7]`

```
          1
        /   \
       2     3
      /     / \
     4     5   6
    /
   7
```

**Output:** `7`

**Explanation:** The last row of the tree is row 3, which contains only node `7`. It is the leftmost (and only) value in that row.

## Constraints

- The number of nodes in the tree is in the range `[1, 10^4]`.
- `-2^31 <= Node.val <= 2^31 - 1`
