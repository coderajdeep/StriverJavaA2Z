# Prefix to Postfix Conversion

**Source:** takeUforward

## Problem Statement

Given a valid prefix expression `s` consisting of single-character operands (letters/digits) and the operators `+`, `-`, `*`, `/`, `^`, convert it to its equivalent postfix expression.

In a **prefix** expression, an operator precedes its two operands (e.g., `+ab`). In a **postfix** expression, an operator follows its two operands (e.g., `ab+`).

Scan the prefix expression from **right to left**. Whenever an operand is encountered, push it onto a stack. Whenever an operator is encountered, pop the top two operands `s1` (first pop) and `s2` (second pop), concatenate them as `s1 + s2 + operator`, and push the resulting string back onto the stack. After the scan, the stack contains exactly one string, which is the resulting postfix expression.

## Example

**Input:** s = "*-A/BC-/AKL"
**Output:** "AB/C-AK/L-*"
**Explanation:** Scanning right to left, each operator is combined with its two most recently formed operand strings, appending the operator after both operands to build the postfix form.

## Constraints

- 1 <= s.length <= 100
- s contains only single uppercase/lowercase letters or digits as operands, and `+`, `-`, `*`, `/`, `^` as operators.
- The input prefix expression is well-formed.
