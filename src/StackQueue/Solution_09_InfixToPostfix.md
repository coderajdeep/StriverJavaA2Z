# Infix to Postfix Conversion

**Source:** takeUforward

## Problem Statement

Given a valid infix expression `s` consisting of lowercase letters (`a`–`z`), digits (`0`–`9`), the operators `+`, `-`, `*`, `/`, `^`, and parentheses `(` `)`, convert it to its equivalent postfix expression.

In an **infix** expression, operators appear between operands (e.g., `a+b`). In a **postfix** expression, operators appear after their operands (e.g., `ab+`). Postfix expressions do not require parentheses to indicate order of operations and can be evaluated directly using a stack.

Use a stack to hold operators and parentheses while scanning the infix expression left to right, popping operators of higher-or-equal precedence (respecting right-associativity of `^`) before pushing the current operator, and popping until `(` is found upon encountering `)`.

Operator precedence (highest to lowest): `^` > `*`, `/` > `+`, `-`. `^` is right-associative; the others are left-associative.

## Example

**Input:** s = "a+b*(c^d-e)^(f+g*h)-i"
**Output:** "abcd^e-fgh*+^*+i-"
**Explanation:** Multiplication and exponentiation inside the parentheses are resolved first per precedence rules, and the result places every operator immediately after its two operands.

## Constraints

- 1 <= s.length <= 100
- s contains only lowercase English letters, digits, `+`, `-`, `*`, `/`, `^`, `(`, and `)`.
- The input expression is well-formed (balanced parentheses, valid operator placement).
