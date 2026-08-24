# Construct Binary Search Tree from Postorder Traversal

**Source:** takeUforward (classic GfG-style problem)

## Problem Statement

Given an array `post[]` which represents the **postorder traversal** of a Binary Search Tree (BST), construct the BST and return its root.

Recall that in a postorder traversal, nodes are visited in the order: left subtree, right subtree, root — so the **last** element of the array is always the root of the tree, and elements are processed from the end of the array backwards.

It is guaranteed that the input represents a valid BST with unique values.

## Example

**Input:** post = [1, 7, 5, 50, 40, 10]
**Output:** A BST with root 10, left subtree rooted at 5 (containing 1 and 7), and right subtree rooted at 40 (containing 50).
**Explanation:** The last element (10) is the root. Values less than 10 form the left subtree, values greater than 10 form the right subtree, recursively applied from the end of the array.

**Input:** post = [3, 2, 1]
**Output:** A BST with root 1, and left child 2, whose left child is 3 (a left-skewed tree since all values are decreasing).

## Constraints

- `1 <= post.length <= 10^4`
- All values in `post` are unique.
- `post` represents a valid postorder traversal of some BST.
