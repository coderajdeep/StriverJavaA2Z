# Postfix to Prefix Conversion

**Source:** takeUforward

## Problem Statement

Given a valid postfix expression `postfix` consisting of single-character operands (letters/digits) and the operators `+`, `-`, `*`, `/`, `^`, convert it to its equivalent prefix expression.

In a **postfix** expression, an operator follows its two operands (e.g., `ab+`). In a **prefix** expression, an operator precedes its two operands (e.g., `+ab`).

Scan the postfix expression from **left to right**. Whenever an operand is encountered, push it onto a stack. Whenever an operator is encountered, pop the top two operands `s2` (first pop, the right operand) and `s1` (second pop, the left operand), concatenate them as `operator + s1 + s2`, and push the resulting string back onto the stack. After the scan, the stack contains exactly one string, which is the resulting prefix expression.

## Example

**Input:** postfix = "AB+CD-*"
**Output:** "*+AB-CD"
**Explanation:** Scanning left to right, `AB+` becomes `+AB`, `CD-` becomes `-CD`, and combining them with `*` prepends the operator, giving `*+AB-CD`.

## Constraints

- 1 <= postfix.length <= 100
- postfix contains only single uppercase/lowercase letters or digits as operands, and `+`, `-`, `*`, `/`, `^` as operators.
- The input postfix expression is well-formed.
