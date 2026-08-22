# Preorder, Inorder, and Postorder Traversal in a Single Traversal

**Source:** takeUforward

## Problem Statement

Given a binary tree, return its preorder, inorder, and postorder traversals — all three at once — using a single iterative traversal of the tree (one pass over the nodes with one stack), instead of doing three separate traversals.

The standard approach pushes a `(node, state)` pair onto a stack, where `state` tracks how many times the node has been "visited": the first visit records the node in the preorder list and pushes the left child, the second visit records the node in the inorder list and pushes the right child, and the third visit records the node in the postorder list.

## Example

**Input:** A binary tree given in level-order as `[1, null, 2, 3]`

```
1
 \
  2
 /
3
```

**Output:**
- Inorder: `[1, 3, 2]`
- Preorder: `[1, 2, 3]`
- Postorder: `[3, 2, 1]`

**Explanation:** Preorder visits root, then left, then right. Inorder visits left, then root, then right. Postorder visits left, then right, then root. All three lists are produced together in one traversal of the tree.

## Constraints

- The number of nodes in the tree is in the range `[0, 100]`.
- `-100 <= Node.val <= 100`
