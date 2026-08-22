# Longest Substring Without Repeating Characters

**Source:** LeetCode #3 — https://leetcode.com/problems/longest-substring-without-repeating-characters/

## Problem Statement

Given a string `s`, find the length of the longest substring without repeating characters.

## Example

**Input:** s = "abcabcbb"
**Output:** 3
**Explanation:** The answer is "abc", with the length of 3.

**Input:** s = "pwwkew"
**Output:** 3
**Explanation:** The answer is "wke", with the length of 3. Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

## Constraints

- 0 <= s.length <= 5 * 10^4
- s consists of English letters, digits, symbols and spaces.

## Notes on this implementation

Two sliding-window solutions are given: `longestNonRepeatingSubstringBestApproach` uses a HashMap of character to last-seen-index to jump the left pointer directly (single pass, O(n)), while `longestNonRepeatingSubstring` uses a HashSet and shrinks the window one character at a time (O(2n)).
