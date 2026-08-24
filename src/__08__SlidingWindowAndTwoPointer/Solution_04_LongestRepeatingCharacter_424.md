# Longest Repeating Character Replacement

**Source:** LeetCode #424 — https://leetcode.com/problems/longest-repeating-character-replacement/

## Problem Statement

You are given a string `s` and an integer `k`. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most `k` times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

## Example

**Input:** s = "ABAB", k = 2
**Output:** 4
**Explanation:** Replace the two 'A's with two 'B's or vice versa.

**Input:** s = "AABABBA", k = 1
**Output:** 4
**Explanation:** Replace the one 'A' in the middle with 'B' and form "AABBBBA". The substring "BBBB" has the longest repeating letters, which is 4. There may exist other ways to achieve this answer too.

## Constraints

- 1 <= s.length <= 10^5
- s consists of only uppercase English letters.
- 0 <= k <= s.length

## Notes on this implementation

Three approaches are provided: `characterReplacementBestSolution` (O(n), never decreases the tracked `maxFreq` even when the window shrinks — a classic trick that still yields the correct final answer), `characterReplacement` (O(26n), recomputes `maxFreq` by scanning the frequency array whenever the window shrinks), and `characterReplacementBruteForce` (O(n^2), checks every starting index).
