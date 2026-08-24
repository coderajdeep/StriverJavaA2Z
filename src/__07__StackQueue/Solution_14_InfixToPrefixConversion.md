# Infix to Prefix Conversion

**Source:** takeUforward

## Problem Statement

Given a valid infix expression `s` consisting of lowercase letters (`a`–`z`), the operators `+`, `-`, `*`, `/`, `^`, and parentheses `(` `)`, convert it to its equivalent prefix expression.

In an **infix** expression, operators appear between operands (e.g., `a+b`). In a **prefix** expression, operators appear before their operands (e.g., `+ab`).

A standard approach:
1. Reverse the infix expression `s`, swapping every `(` with `)` and every `)` with `(`.
2. Convert the reversed expression to postfix using the usual infix-to-postfix algorithm, with the tie-breaking rule for equal precedence adjusted so operands of the same precedence are still processed left-to-right correctly (i.e., pop on `<=` precedence rather than the strict `<` used for postfix, to correctly handle right-associativity after reversal).
3. Reverse the resulting postfix string to obtain the prefix expression.

Edge cases such as `a+b*c-d/e+f*g-h/i` and right-associative chains like `a^b^c` must be handled correctly by the precedence/associativity rules.

## Example

**Input:** s = "a+b*(c^d-e)^(f+g*h)-i"
**Output:** "-+a*b^-^cde+f*ghi"
**Explanation:** Reversing the string, converting to postfix with adjusted precedence handling, and reversing the result yields the prefix form where every operator precedes its operands.

## Constraints

- 1 <= s.length <= 100
- s contains only lowercase English letters, `+`, `-`, `*`, `/`, `^`, `(`, and `)`.
- The input expression is well-formed (balanced parentheses, valid operator placement).
