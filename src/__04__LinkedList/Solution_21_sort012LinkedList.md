# Sort a Linked List of 0s, 1s and 2s

**Source:** takeUforward

## Problem Statement

Given a linked list of `N` nodes where each node's data is one of `0`, `1`, or `2`, sort the linked list in a single traversal (conceptually) so that all `0`s come first, followed by all `1`s, followed by all `2`s.

The straightforward approach counts the number of `0`s, `1`s, and `2`s in the list, then overwrites the node values in a second pass in the correct sorted order. A more advanced approach re-links the nodes into three separate chains (a zero chain, a one chain, and a two chain) and then merges them, without changing any node's `data` field ahead of time.

## Example

**Input:** head = [1,0,2,1,0]
**Output:** [0,0,1,1,2]

**Input:** head = [2,2,0,1]
**Output:** [0,1,2,2]

## Constraints

- `1 <= N <= 10^5`
- `Node.data` is `0`, `1`, or `2`.
- Expected time complexity: O(n), expected auxiliary space: O(1).
