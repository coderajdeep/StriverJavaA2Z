# Postfix to Infix Conversion

**Source:** takeUforward

## Problem Statement

Given a valid postfix expression `postExp` consisting of single-character operands (letters/digits) and the operators `+`, `-`, `*`, `/`, `^`, convert it to its equivalent, fully parenthesized infix expression.

In a **postfix** expression, an operator follows its two operands (e.g., `ab+`). In an **infix** expression, an operator appears between its two operands (e.g., `(a+b)`).

Scan the postfix expression from **left to right**. Whenever an operand is encountered, push it onto a stack. Whenever an operator is encountered, pop the top two operands `s2` (first pop, the right operand) and `s1` (second pop, the left operand), combine them as `(s1 <operator> s2)`, and push the resulting string back onto the stack. After the scan, the stack contains exactly one string, which is the resulting infix expression.

## Example

**Input:** postExp = "AB+CD-*"
**Output:** "((A+B)*(C-D))"
**Explanation:** Scanning left to right, `AB+` becomes `(A+B)`, `CD-` becomes `(C-D)`, and combining them with `*` produces `((A+B)*(C-D))`.

## Constraints

- 1 <= postExp.length <= 100
- postExp contains only single uppercase/lowercase letters or digits as operands, and `+`, `-`, `*`, `/`, `^` as operators.
- The input postfix expression is well-formed.
