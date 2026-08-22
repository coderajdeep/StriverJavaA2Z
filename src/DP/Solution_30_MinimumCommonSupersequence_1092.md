# Shortest Common Supersequence

**Source:** LeetCode #1092 — https://leetcode.com/problems/shortest-common-supersequence/

## Problem Statement

Given two strings `str1` and `str2`, return the shortest string that has both `str1` and `str2` as subsequences. If there are multiple valid strings, return any of them.

A string `s` is a subsequence of string `t` if deleting some number of characters from `t` (possibly `0`) results in the string `s`.

This is solved by first computing the LCS of `str1` and `str2`, then merging the two strings around their LCS: characters from the LCS appear once, and characters not part of the LCS are inserted from both strings in their original relative order.

## Example

**Input:** str1 = "abac", str2 = "cab"
**Output:** "cabac"
**Explanation:** str1 = "abac" is a subsequence of "cabac" (delete the leading 'c'). str2 = "cab" is a subsequence of "cabac" (delete the trailing "ac"). The output "cabac" has length 5, which is the shortest possible supersequence.

**Input:** str1 = "abc", str2 = "abc"
**Output:** "abc"

## Constraints

- 1 <= str1.length, str2.length <= 1000
- str1 and str2 consist of lowercase English letters.
