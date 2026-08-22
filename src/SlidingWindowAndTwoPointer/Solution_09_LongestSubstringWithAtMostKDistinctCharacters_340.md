# Longest Substring with At Most K Distinct Characters

**Source:** LeetCode #340 — https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/ (Premium)

## Problem Statement

Given a string `s` and an integer `k`, return the length of the longest substring of `s` that contains at most `k` distinct characters.

## Example

**Input:** s = "eceba", k = 2
**Output:** 3
**Explanation:** The substring is "ece" with length 3.

**Input:** s = "aa", k = 1
**Output:** 2
**Explanation:** The substring is "aa" with length 2.

## Constraints

- 1 <= s.length <= 5 * 10^4
- 0 <= k <= 50

## Notes on this implementation

Standard sliding window using a HashMap of character-to-frequency: expand the window on the right, and while the map has more than `k` distinct keys, shrink from the left (removing a key from the map once its frequency hits zero). Time complexity O(2n), space complexity O(k).
