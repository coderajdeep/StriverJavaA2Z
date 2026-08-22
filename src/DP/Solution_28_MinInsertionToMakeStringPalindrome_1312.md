# Minimum Insertion Steps to Make a String Palindrome

**Source:** LeetCode #1312 — https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/

## Problem Statement

Given a string `s`, find the minimum number of insertions needed to make `s` a palindrome.

A palindrome string is a string that reads the same backward as forward.

This is solved by computing the Longest Palindromic Subsequence (LPS) of `s`; the characters not part of the LPS are the ones that need a matching character inserted, so the answer is `n - lps_length`.

## Example

**Input:** s = "zzazz"
**Output:** 0
**Explanation:** The string "zzazz" is already a palindrome, so no insertions are needed.

**Input:** s = "mbadm"
**Output:** 2
**Explanation:** String can be transformed into "mbdadbm" or "mdbabdm" by inserting 2 characters.

**Input:** s = "leetcode"
**Output:** 5
**Explanation:** Inserting 5 characters, the string becomes "leetcodocteel".

## Constraints

- 1 <= s.length <= 500
- s consists of lowercase English letters.
