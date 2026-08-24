# Longest K Unique Characters Substring

**Source:** takeUforward / GeeksforGeeks — https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1

## Problem Statement

Given a string `s` and an integer `k`, find the length of the longest substring that contains exactly `k` unique (distinct) characters. If no such substring exists, return `-1`.

This differs from LeetCode #340 (Longest Substring with At Most K Distinct Characters) and Fruit Into Baskets (LeetCode #904), which ask for **at most** `k` distinct characters — here the substring must contain **exactly** `k` distinct characters.

## Example

**Input:** s = "aabacbebebe", k = 3
**Output:** 7
**Explanation:** "cbebebe" is the longest substring with exactly 3 distinct characters ('c', 'b', 'e').

**Input:** s = "aaaa", k = 2
**Output:** -1
**Explanation:** There are only 1 distinct characters in total in the string, so no substring can have exactly 2 distinct characters.

## Constraints

- 1 <= s.length <= 10^5
- 1 <= k <= 26
- s consists of lowercase English letters.

## Notes on this implementation

The method `longestKSubstr` uses a standard sliding window with a HashMap of character frequencies: expand the window on the right, shrink from the left whenever the map has more than `k` distinct keys, and update the answer only when the map size is exactly `k` (initial answer is `-1` if no valid window with exactly k distinct characters is ever found).
