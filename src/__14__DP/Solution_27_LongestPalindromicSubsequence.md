# Longest Palindromic Subsequence

**Source:** takeUforward (equivalent to LeetCode #516)

## Problem Statement

Given a string `s`, find the length of the longest palindromic subsequence in `s`.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements. A palindromic subsequence reads the same forwards and backwards.

This is solved by computing the Longest Common Subsequence (LCS) between the string `s` and its reverse; the length of that LCS equals the length of the Longest Palindromic Subsequence.

## Example

**Input:** s = "bbbab"
**Output:** 4
**Explanation:** One possible longest palindromic subsequence is "bbbb".

**Input:** s = "cbbd"
**Output:** 2
**Explanation:** One possible longest palindromic subsequence is "bb".

## Constraints

- 1 <= s.length <= 1000
- s consists only of lowercase English letters.
