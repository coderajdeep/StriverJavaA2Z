# Number of Substrings Containing All Three Characters

**Source:** LeetCode #1358 — https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

## Problem Statement

Given a string `s` consisting only of characters `a`, `b` and `c`. Return the number of substrings containing at least one occurrence of all these characters `a`, `b` and `c`.

## Example

**Input:** s = "abcabc"
**Output:** 10
**Explanation:** The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 

**Input:** s = "aaacb"
**Output:** 3
**Explanation:** The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".

**Input:** s = "abc"
**Output:** 1

## Constraints

- 3 <= s.length <= 5 * 10^4
- s consists only of the characters a, b, or c.

## Notes on this implementation

Three approaches are given, all O(n): `numberOfSubstringsWithOutHashMap` tracks the last-seen index of 'a', 'b', and 'c' directly and, once all three have appeared, adds `min(lastIndexA, lastIndexB, lastIndexC) + 1` valid substrings ending at the current index; `numberOfSubstringsUsingMap` generalizes this using a HashMap (works for any k distinct required characters); and `numberOfSubstrings` uses a true sliding window that shrinks from the left whenever the window contains all three characters, counting `(n - right)` new valid substrings each time.
