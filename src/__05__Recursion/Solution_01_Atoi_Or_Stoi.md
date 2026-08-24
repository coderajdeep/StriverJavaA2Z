# Implement atoi (String to Integer Conversion)

**Source:** takeUforward

## Problem Statement

Implement the `myAtoi(String input)` function, which converts a string to a 32-bit signed integer (similar to C/C++'s `atoi` function).

The algorithm for `myAtoi` is as follows:

1. Ignore any leading whitespace.
2. Check if the next character (if not already at the end of the string) is `'-'` or `'+'`. Read this character in if it is either, using it to determine the sign of the final result (the default sign is positive if neither is present).
3. Read in the digits until a non-digit character is encountered or the end of the input is reached. If no digits were read, then the result is 0.
4. Convert these digits into an integer. If no digits were read, then the integer is 0.
5. If the integer is out of the 32-bit signed integer range `[-2^31, 2^31 - 1]`, then clamp the integer so that it remains in the range. Specifically, integers less than `-2^31` should be clamped to `-2^31`, and integers greater than `2^31 - 1` should be clamped to `2^31 - 1`.
6. Return the integer as the final result.

## Example

**Input:** "42"
**Output:** 42

**Input:** "   -042"
**Output:** -42

**Input:** "1337c0d3"
**Output:** 1337

**Input:** "words and 987"
**Output:** 0

**Input:** "-91283472332"
**Output:** -2147483648
**Explanation:** The number "-91283472332" is out of the range of a 32-bit signed integer, so it is clamped to `-2^31`.

## Constraints

- `0 <= input.length <= 200`
- `input` consists of English letters, digits, `' '`, `'+'`, `'-'`, and `'.'`.
