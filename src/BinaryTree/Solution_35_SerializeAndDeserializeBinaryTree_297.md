# Serialize and Deserialize Binary Tree

**Source:** LeetCode #297 — Serialize and Deserialize Binary Tree

## Problem Statement

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

## Example

**Input:** `root = [1, 2, 3, null, null, 4, 5]`

```
    1
   / \
  2   3
     / \
    4   5
```

**Output:** `[1, 2, 3, null, null, 4, 5]`

**Explanation:** The tree is serialized into a string representation (e.g., a level-order encoding such as `"1,2,3,N,N,4,5"` using `N` to mark null children), and deserializing that string reconstructs a tree identical in structure and values to the original.

## Constraints

- The number of nodes in the tree is in the range `[0, 10^4]`.
- `-1000 <= Node.val <= 1000`
