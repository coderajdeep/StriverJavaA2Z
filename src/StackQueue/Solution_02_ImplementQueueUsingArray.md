# Implement Queue using Array

**Source:** takeUforward

## Problem Statement

Implement a Queue data structure using a fixed-size Array, supporting the following operations:

- `push(x)`: Insert element `x` at the rear of the queue.
- `pop()`: Remove and return the element at the front of the queue.
- `peek()`: Return the element at the front of the queue without removing it.
- `isEmpty()`: Return `true` if the queue has no elements, `false` otherwise.

A Queue follows the FIFO (First In, First Out) principle — the earliest inserted element is the first one to be removed. Maintain `front` and `rear` pointers into the array to track the current boundaries of the queue. Handle overflow (pushing onto a full queue) and underflow (popping/peeking an empty queue) gracefully.

## Example

**Input:**
```
push(1)
push(2)
push(3)
peek()
pop()
peek()
```
**Output:**
```
1
1
2
```
**Explanation:** After pushing 1, 2, 3, the front of the queue is 1. Popping removes 1 and returns it, leaving the front as 2.

## Constraints

- 1 <= number of operations <= 1000
- Element values fit in a 32-bit integer.
- Queue capacity is fixed (e.g., 100) — pushing beyond capacity should raise an overflow error.
