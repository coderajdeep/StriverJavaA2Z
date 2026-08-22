# Same Tree

**Source:** LeetCode #100 — Same Tree

## Problem Statement

Given the roots of two binary trees `p` and `q`, write a function to check if they are the same or not. Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

## Example

**Input:** `p = [1, 2, 3]`, `q = [1, 2, 3]`

```
p:      1        q:      1
       / \              / \
      2   3            2   3
```

**Output:** `true`

**Input:** `p = [1, 2]`, `q = [1, null, 2]`

**Output:** `false`

**Explanation:** In `p`, `2` is the left child of `1`. In `q`, `2` is the right child of `1`. Structurally different, so not the same tree.

## Constraints

- The number of nodes in both trees is in the range `[0, 100]`.
- `-10^4 <= Node.val <= 10^4`
