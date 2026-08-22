# Implement Queue using Stacks

**Source:** LeetCode #232 — Implement Queue using Stacks

## Problem Statement

Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (`push`, `peek`, `pop`, and `empty`).

Implement the `MyQueue` class:

- `void push(int x)` Pushes element `x` to the back of the queue.
- `int pop()` Removes the element from the front of the queue and returns it.
- `int peek()` Returns the element at the front of the queue.
- `boolean empty()` Returns `true` if the queue is empty, `false` otherwise.

Notes:
- You must use only standard operations of a stack, which means only `push to top`, `peek/pop from top`, `size`, and `is empty` operations are valid.
- Depending on your language, the stack may not be supported natively; you may simulate a stack using a list or deque as long as you only use standard stack operations.

## Example

**Input:**
```
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
```
**Output:**
```
[null, null, null, 1, 1, false]
```
**Explanation:**
```
MyQueue myQueue = new MyQueue();
myQueue.push(1);
myQueue.push(2);
myQueue.peek();  // return 1
myQueue.pop();   // return 1
myQueue.empty(); // return false
```

## Constraints

- 1 <= x <= 9
- At most 100 calls will be made to `push`, `pop`, `peek`, and `empty`.
- All the calls to `pop` and `peek` are valid.
