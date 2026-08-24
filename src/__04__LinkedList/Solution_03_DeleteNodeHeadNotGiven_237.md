# Delete Node in a Linked List

**Source:** LeetCode #237 — Delete Node in a Linked List

## Problem Statement

There is a singly-linked list `head` and you are given a reference to a node `node` to be deleted. You will **not** be given access to the head of the list, only access to `node`. It is guaranteed that `node` is **not** the tail node in the list, and it is not the head node either.

Delete the given node. Note that by deleting the node, we do not mean removing it from memory — we mean:

- The value of the given node should not exist in the linked list.
- The number of nodes in the linked list should decrease by one.
- All the values before `node` should be in the same order.
- All the values after `node` should be in the same order.

Since you have no access to the previous node, the standard trick is to copy the value of the next node into the given node and then bypass (skip) the next node.

## Example

**Input:** head = [4,5,1,9], node = 5 (the node with value 5)
**Output:** [4,1,9]
**Explanation:** After calling your function, the linked list should look like [4,1,9], since the third node with value 5 (node) is deleted by copying the value 1 from the next node and linking past it.

**Input:** head = [4,5,1,9], node = 1
**Output:** [4,5,9]
**Explanation:** The node with value 1 is removed by copying value 9 into it and linking past the last node.

## Constraints

- The number of the nodes in the given list is in the range `[2, 1000]`.
- `-1000 <= Node.val <= 1000`
- The value of each node in the list is unique.
- The `node` to be deleted is in the list and is not a tail node.
