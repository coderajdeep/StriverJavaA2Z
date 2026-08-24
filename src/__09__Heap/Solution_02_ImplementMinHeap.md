# Implement a Min __09__Heap

**Source:** takeUforward

## Problem Statement

Implement a Min __09__Heap data structure from scratch, backed by an array, supporting the following operations:

- `insert(key)` — insert a new key into the heap and restore the heap property by "bubbling up" (heapify-up).
- `extractMin()` — remove the minimum element (the root) from the heap, replace it with the last element, and restore the heap property by "sifting down" (heapify-down).
- `getMin()` — return the minimum element without removing it.
- `changeKey(index, newVal)` — update the value at a given index and re-heapify up or down as needed.
- `isEmpty()` — check whether the heap is empty.
- `heapSize()` — return the current number of elements.

The heap must maintain the min-heap invariant at all times: every parent node's value is less than or equal to the values of its children.

## Example

**Input:** insert(5), insert(3), insert(8), insert(1), then getMin()
**Output:** 1
**Explanation:** After inserting 5, 3, 8, 1 with heapify-up restoring the min-heap property after each insertion, the smallest element, 1, sits at the root and is returned by getMin().

**Input:** ...continuing from above, call extractMin() then getMin()
**Output:** 3
**Explanation:** extractMin() removes 1 (moves the last element to the root and heapifies down), leaving 3 as the new minimum.

## Constraints

- Number of elements <= 10^5 (bounded by internal array capacity)
- Operations should run in O(log n) time, except getMin/isEmpty/heapSize which are O(1).
