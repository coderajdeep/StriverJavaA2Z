# Children Sum Property in a Binary Tree

**Source:** takeUforward

## Problem Statement

Given a binary tree, check whether it satisfies the Children Sum Property at every node. A binary tree satisfies this property if, for every node that has at least one child, the value of the node is equal to the sum of the values of its left and right children (treating a missing child as contributing 0).

Leaf nodes (nodes with no children) trivially satisfy the property.

Return `true` if the tree satisfies the Children Sum Property at every node, `false` otherwise.

## Example

**Input:**

```
        10
       /  \
      4    6
     / \    \
    1   3    6
```

**Output:** `true`

**Explanation:** At node `10`: `4 + 6 = 10`. At node `4`: `1 + 3 = 4`. At node `6`: only right child `6`, so `0 + 6 = 6`. Leaves `1`, `3`, `6` trivially satisfy the property. Every node satisfies the Children Sum Property.

**Input:**

```
      5
     / \
    3   4
```

**Output:** `false`

**Explanation:** At node `5`, `3 + 4 = 7 != 5`, so the property is violated.

## Constraints

- The number of nodes in the tree is in the range `[1, 10^4]`.
- `0 <= Node.val <= 10^4`
