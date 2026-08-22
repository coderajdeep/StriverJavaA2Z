# Minimum Window Substring

**Source:** LeetCode #76 — https://leetcode.com/problems/minimum-window-substring/

## Problem Statement

Given two strings `s` and `t` of lengths `m` and `n` respectively, return the minimum window substring of `s` such that every character in `t` (including duplicates) is included in the window. If there is no such substring, return the empty string `""`.

The testcases will be generated such that the answer is unique.

## Example

**Input:** s = "ADOBECODEBANC", t = "ABC"
**Output:** "BANC"
**Explanation:** The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

**Input:** s = "a", t = "a"
**Output:** "a"
**Explanation:** The entire string s is the minimum window.

**Input:** s = "a", t = "aa"
**Output:** ""
**Explanation:** Both 'a's from t must be included in the window. Since the largest window of s only has one 'a', return empty string.

## Constraints

- m == s.length
- n == t.length
- 1 <= m, n <= 10^5
- s and t consist of uppercase and lowercase English letters.

Follow up: Could you find an algorithm that runs in O(m + n) time?

## Notes on this implementation

`minWindow` is a brute-force-ish O(n^2) approach that, for every starting index `i`, resets a 52-slot (upper+lowercase) frequency array from `t` and scans forward until the window contains `t` in full. `minWindowOptimizedVersion` is the standard O(n) two-pointer sliding window: expand `right`, decrementing frequencies (and incrementing a `cnt` of matched characters when a needed character is found), then shrink `left` while the window still satisfies the requirement, tracking the minimum length window.
