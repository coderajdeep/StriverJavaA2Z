# Shortest Substring Containing All Distinct Characters of the String

**Source:** takeUforward-style / Coding Ninjas (Naukri Code360) — https://www.naukri.com/code360/problems/shortest-substring-with-all-characters_704894

## Problem Statement

Given a string `s`, find the length (and one instance) of the shortest contiguous substring of `s` that contains all the distinct characters present in `s` at least once.

Unlike Minimum Window Substring (LeetCode #76), there is no separate target string `t` — the "target" character set is simply the set of all distinct characters occurring in `s` itself.

## Example

**Input:** s = "aabcbcdbca"
**Output:** "dbca"
**Explanation:** The distinct characters in s are {a, b, c, d}. "dbca" is a substring of length 4 containing all four distinct characters, and no shorter substring contains all of them.

**Input:** s = "aaab"
**Output:** "ab"
**Explanation:** The distinct characters are {a, b}. "ab" is the shortest substring containing both.

## Constraints

- 1 <= s.length <= 10^5
- s consists of lowercase English letters.

## Notes on this implementation

The method `shortestSubstring` first collects the set of all distinct characters in `s` (via a HashMap of char to 1) to know the target count `totalChar`. It then runs a sliding window: expand `right`, decrementing counts and tracking how many distinct required characters currently have a non-negative remaining count (`count`); once `count == totalChar` (window contains all distinct characters), shrink `left` while still valid, tracking the minimum-length window found. Time complexity O(n), space complexity O(26).
