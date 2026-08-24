# Implement Stack using __01__Array

**Source:** takeUforward

## Problem Statement

Implement a Stack data structure using a fixed-size __01__Array, supporting the following operations in O(1) time each:

- `push(x)`: Insert element `x` on top of the stack.
- `pop()`: Remove and return the element on top of the stack. If the stack is empty, it should not be possible to pop.
- `top()`: Return the element on top of the stack without removing it.
- `isEmpty()`: Return `true` if the stack has no elements, `false` otherwise.

A Stack follows the LIFO (Last In, First Out) principle — the most recently inserted element is the first one to be removed. Use a fixed-capacity array and a `top` pointer/index to track the current top of the stack. Handle overflow (pushing onto a full stack) and underflow (popping/peeking an empty stack) gracefully.

## Example

**Input:**
```
push(1)
push(2)
push(3)
top()
pop()
top()
```
**Output:**
```
3
3
2
```
**Explanation:** After pushing 1, 2, 3, the top of the stack is 3. Popping removes 3 and returns it, leaving the top as 2.

## Constraints

- 1 <= number of operations <= 1000
- Element values fit in a 32-bit integer.
- Stack capacity is fixed (e.g., 100) — pushing beyond capacity should raise an overflow error.
