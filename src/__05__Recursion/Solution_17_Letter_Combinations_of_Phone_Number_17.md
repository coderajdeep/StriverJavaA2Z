# Letter Combinations of a Phone Number

**Source:** LeetCode #17 — Letter Combinations of a Phone Number

## Problem Statement

Given a string `digits` containing digits from `2` to `9` inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that `1` does not map to any letters.

- 2: "abc", 3: "def", 4: "ghi", 5: "jkl", 6: "mno", 7: "pqrs", 8: "tuv", 9: "wxyz"

## Example

**Input:** digits = "23"
**Output:** ["ad","ae","af","bd","be","bf","cd","ce","cf"]

**Input:** digits = ""
**Output:** []

**Input:** digits = "2"
**Output:** ["a","b","c"]

## Constraints

- `0 <= digits.length <= 4`
- `digits[i]` is a digit in the range `['2', '9']`.
