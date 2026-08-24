# Find Length of Loop in a Linked List

**Source:** takeUforward

## Problem Statement

Given the head of a linked list that may contain a cycle (loop), find and return the length of the loop, i.e., the number of nodes that make up the cycle. If the linked list does not contain a cycle, return `0`.

The approach uses Floyd's slow/fast pointer technique to detect the cycle first. Once `slow` and `fast` meet inside the loop, keep advancing one pointer by one step, counting the steps, until it comes back to the meeting point — that count is the length of the loop.

## Example

**Input:** head = [1,2,3,4,5] where the last node (5) points back to node with value 3
**Output:** 3
**Explanation:** The loop consists of nodes 3 -> 4 -> 5 -> 3, which has length 3.

**Input:** head = [1,2,3], no cycle
**Output:** 0
**Explanation:** There is no loop in the list.

## Constraints

- The number of nodes in the list is in the range `[0, 10^5]`.
- `-10^5 <= Node.val <= 10^5`
- Expected time complexity: O(n), expected auxiliary space: O(1).
