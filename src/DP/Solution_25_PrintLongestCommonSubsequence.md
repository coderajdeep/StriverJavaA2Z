# Print Longest Common Subsequence

**Source:** takeUforward

## Problem Statement

Given two strings `s1` (of length `n`) and `s2` (of length `m`), find and print (reconstruct) one Longest Common Subsequence (LCS) between the two strings — a subsequence being characters that appear in the same relative order in both strings, but not necessarily contiguously.

## Example

**Input:** n = 5, m = 3, s1 = "abcde", s2 = "ace"
**Output:** "ace"
**Explanation:** "ace" is a subsequence of both "abcde" and "ace", and it is the longest such common subsequence.

**Input:** n = 3, m = 3, s1 = "abc", s2 = "def"
**Output:** "" (empty string)
**Explanation:** There is no common subsequence between "abc" and "def".

## Constraints

- 1 <= n, m <= 1000
- s1 and s2 consist of lowercase English letters.
