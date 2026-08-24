# Implement Queue using Linked List

**Source:** takeUforward

## Problem Statement

Implement a Queue data structure using a Singly Linked List (instead of a fixed-size array), supporting the following operations, each in O(1) time:

- `push(x)`: Insert element `x` at the rear of the queue by adding a new node after the current tail.
- `pop()`: Remove and return the element at the front of the queue by removing the head node.
- `peek()`: Return the value of the head node without removing it.
- `isEmpty()`: Return `true` if the queue has no elements, `false` otherwise.

Maintain both `front` and `rear` pointers so that enqueue (insert at rear) and dequeue (remove from front) both run in O(1). Since the queue is backed by a linked list, it has no fixed capacity and grows/shrinks dynamically.

## Example

**Input:**
```
push(10)
push(20)
push(30)
peek()
pop()
peek()
```
**Output:**
```
10
10
20
```
**Explanation:** After pushing 10, 20, 30, the front of the queue is 10. Popping removes and returns 10, leaving the front as 20.

## Constraints

- 1 <= number of operations <= 10^4
- Element values fit in a 32-bit integer.
- No fixed upper bound on the number of elements (bounded only by available memory).
