# Basic Heap Structure

**Source:** takeUforward

## Problem Statement

Implement the skeleton of a binary Min Heap backed by an array. A binary heap stores its elements in a plain array and uses index arithmetic to represent the implicit tree structure:

- The parent of the node at index `i` is at index `(i - 1) / 2`.
- The left child of the node at index `i` is at index `2*i + 1`.
- The right child of the node at index `i` is at index `2*i + 2`.

Set up the underlying array, track the current `size` versus total `capacity`, and provide the index-navigation helpers (`getParent`, `getLeftChild`, `getRightChild`) plus a `swap` utility that later heap operations (`insert`, `extractMin`, `heapifyUp`, `heapifyDown`) will build on top of.

## Example

**Input:** new MinHeap(10) creates an empty heap with capacity 10 (rounded up to at least 100 in this implementation)
**Output:** getSize() == 0
**Explanation:** The heap starts empty; the parent/child helper methods compute the correct array indices for a node, e.g. getParent(3) == 1, getLeftChild(1) == 3, getRightChild(1) == 4.

## Constraints

- 1 <= capacity <= 10^5 (typical)
- Array-index arithmetic assumes a 0-indexed array representing a complete binary tree.

## Notes on this implementation

This file only defines the array/size bookkeeping and index helpers (`getParent`, `getLeftChild`, `getRightChild`, `swap`, `printArray`) — it does not yet implement `insert` or `extractMin`. The full min-heap operations (insert, extractMin, heapify up/down) are implemented separately in `Solution_02_ImplementMinHeap.java`.
