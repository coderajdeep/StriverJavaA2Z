# Valid Parentheses

**Source:** LeetCode #20 — Valid Parentheses

## Problem Statement

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:
1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

## Example

**Input:** s = "()[]{}"
**Output:** true
**Explanation:** Each opening bracket is matched by a closing bracket of the same type, in the correct order.

**Input:** s = "(]"
**Output:** false
**Explanation:** '(' is closed by ']', which is the wrong type of bracket.

## Constraints

- 1 <= s.length <= 10^4
- s consists of parentheses only `'()[]{}'`.
