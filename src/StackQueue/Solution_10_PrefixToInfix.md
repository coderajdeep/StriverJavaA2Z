# Prefix to Infix Conversion

**Source:** takeUforward

## Problem Statement

Given a valid prefix expression `s` consisting of single-character operands (letters/digits) and the operators `+`, `-`, `*`, `/`, `^`, convert it to its equivalent, fully parenthesized infix expression.

In a **prefix** expression, an operator precedes its two operands (e.g., `+ab`). In an **infix** expression, an operator appears between its two operands (e.g., `(a+b)`).

Scan the prefix expression from **right to left**. Whenever an operand is encountered, push it onto a stack. Whenever an operator is encountered, pop the top two operands `s1` (first pop) and `s2` (second pop), combine them as `(s1 <operator> s2)`, and push the resulting string back onto the stack. After the scan, the stack contains exactly one string, which is the resulting infix expression.

## Example

**Input:** s = "*-A/BC-/AKL"
**Output:** "((A-(B/C))*((A/K)-L))"
**Explanation:** Scanning right to left and combining operands with their operator while wrapping each combination in parentheses reconstructs the fully parenthesized infix form.

## Constraints

- 1 <= s.length <= 100
- s contains only single uppercase/lowercase letters or digits as operands, and `+`, `-`, `*`, `/`, `^` as operators.
- The input prefix expression is well-formed.
