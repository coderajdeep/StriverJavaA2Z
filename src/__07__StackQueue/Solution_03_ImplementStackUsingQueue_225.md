# Implement Stack using Queues

**Source:** LeetCode #225 — Implement Stack using Queues

## Problem Statement

Implement a last-in-first-out (LIFO) stack using only one or two queues. The implemented stack should support all the functions of a normal stack (`push`, `top`, `pop`, and `empty`).

Implement the `MyStack` class:

- `void push(int x)` Pushes element `x` to the top of the stack.
- `int pop()` Removes the element on the top of the stack and returns it.
- `int top()` Returns the element on the top of the stack.
- `boolean empty()` Returns `true` if the stack is empty, `false` otherwise.

Notes:
- You must use only standard operations of a queue, which means only `push to back`, `peek/pop from front`, `size`, and `is empty` operations are valid.
- Depending on your language, the queue may not be supported natively; you may simulate a queue using a list or deque as long as you only use standard queue operations.

## Example

**Input:**
```
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
```
**Output:**
```
[null, null, null, 2, 2, false]
```
**Explanation:**
```
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top();   // return 2
myStack.pop();   // return 2
myStack.empty(); // return False
```

## Constraints

- 1 <= x <= 9
- At most 100 calls will be made to `push`, `pop`, `top`, and `empty`.
- All the calls to `pop` and `top` are valid.
