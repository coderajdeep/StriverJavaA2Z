# Minimum Element in a Binary Search Tree

**Source:** takeUforward

## Problem Statement

Given the `root` of a Binary Search Tree (BST), find and return the minimum value stored in the tree.

Since in a BST all values in the left subtree of a node are smaller than the node's value, the minimum element can be found by repeatedly moving to the left child starting from the root, without needing to compare against every node.

## Example

**Input:** root = [8,3,10,1,6,null,14]
**Output:** 1
**Explanation:** Starting at the root (8) and repeatedly moving left (8 -> 3 -> 1), we reach the leftmost node, which holds the minimum value 1.

**Input:** root = [5,2,8]
**Output:** 2
**Explanation:** The leftmost node from root 5 is 2, which is the minimum value in the tree.

## Constraints

- The number of nodes in the tree is in the range `[1, 10^4]`.
- `-10^4 <= Node.val <= 10^4`
- `root` is a valid binary search tree.
