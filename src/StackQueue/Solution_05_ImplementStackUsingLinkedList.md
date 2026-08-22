# Implement Stack using Linked List

**Source:** takeUforward

## Problem Statement

Implement a Stack data structure using a Singly Linked List (instead of a fixed-size array), supporting the following operations, each in O(1) time:

- `push(x)`: Insert element `x` on top of the stack by adding a new node at the head of the linked list.
- `pop()`: Remove and return the element on top of the stack by removing the head node.
- `top()`: Return the value of the head node without removing it.
- `isEmpty()`: Return `true` if the stack has no elements, `false` otherwise.

Because the stack is backed by a linked list rather than an array, it has no fixed capacity and grows/shrinks dynamically with each push/pop.

## Example

**Input:**
```
push(10)
push(20)
push(30)
top()
pop()
isEmpty()
```
**Output:**
```
30
30
false
```
**Explanation:** After pushing 10, 20, 30, the head of the list (top of stack) is 30. Popping removes and returns 30, and the stack is still non-empty afterward (10, 20 remain).

## Constraints

- 1 <= number of operations <= 10^4
- Element values fit in a 32-bit integer.
- No fixed upper bound on the number of elements (bounded only by available memory).
