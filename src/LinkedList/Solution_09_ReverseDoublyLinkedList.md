# Reverse a Doubly Linked List

**Source:** takeUforward

## Problem Statement

Given the head of a doubly linked list, reverse the list in place and return the new head of the reversed list. Each node in a doubly linked list stores a value along with a pointer to the `next` node and a pointer to the `prev` node. Reversing the list means every node's `next` should point to what used to be its previous node, and every node's `prev` should point to what used to be its next node.

Do this in a single pass without using extra space for another list, by swapping the `next` and `prev` pointers of every node as you traverse.

## Example

**Input:** head = [1,2,3,4,5] (as a doubly linked list)
**Output:** [5,4,3,2,1]
**Explanation:** Traversing the list forward now visits 5, 4, 3, 2, 1 and traversing backward from the new head visits 1, 2, 3, 4, 5.

**Input:** head = [10,20]
**Output:** [20,10]

## Constraints

- The number of nodes in the list is in the range `[0, 10^5]`.
- `-10^5 <= Node.data <= 10^5`
- Expected time complexity: O(n), expected auxiliary space: O(1).
