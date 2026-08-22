# Valid Parenthesis String

**Source:** LeetCode #678 — https://leetcode.com/problems/valid-parenthesis-string/

## Problem Statement

Given a string `s` containing only three types of characters: `'('`, `')'` and `'*'`, return `true` if `s` is valid.

The following rules define a valid string:

- Any left parenthesis `'('` must have a corresponding right parenthesis `')'`.
- Any right parenthesis `')'` must have a corresponding left parenthesis `'('`.
- Left parenthesis `'('` must go before the corresponding right parenthesis `')'`.
- `'*'` could be treated as a single right parenthesis `')'` or a single left parenthesis `'('` or an empty string `""`.

## Example

**Input:** s = "()"
**Output:** true

**Input:** s = "(*)"
**Output:** true

**Input:** s = "(*))"
**Output:** true

## Constraints

- 1 <= s.length <= 100
- s[i] is '(', ')' or '*'.

## Notes on this implementation

The class provides two solutions: `isValidBestSolution` uses the greedy min/max open-count range approach (O(n) time, O(1) space), and `checkValidStringMemoization` uses a top-down DP/memoization approach on `(index, open-count)`.
