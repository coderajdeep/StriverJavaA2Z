# Minimum Insertions/Deletions to Convert String A to String B

**Source:** takeUforward

## Problem Statement

Given two strings `s1` and `s2`, find the minimum number of operations required to convert `s1` into `s2`, where the only two operations allowed are:
1. Insert a character
2. Delete a character

(Note: this differs from Edit Distance, which also allows a "replace" operation.)

This is solved via the Longest Common Subsequence (LCS) between `s1` and `s2`: the characters in the LCS should be kept; every other character in `s1` (length `n1 - lcs`) must be deleted, and every other character in `s2` (length `n2 - lcs`) must be inserted. The answer is `(n1 - lcs) + (n2 - lcs)`.

## Example

**Input:** s1 = "heap", s2 = "pea"
**Output:** 3
**Explanation:** LCS("heap", "pea") = "ea", length 2. Deletions needed from s1 = 4 - 2 = 2 ('h' and 'p'). Insertions needed into s1 to form s2 = 3 - 2 = 1 ('p'). Total operations = 2 + 1 = 3.

**Input:** s1 = "geeksforgeeks", s2 = "geeksfor"
**Output:** 5
**Explanation:** s2 is already a common subsequence of length 8 within s1 (LCS = 8). Deletions = 13 - 8 = 5, insertions = 8 - 8 = 0. Total = 5.

## Constraints

- 1 <= s1.length, s2.length <= 1000
- s1 and s2 consist of lowercase English letters.
