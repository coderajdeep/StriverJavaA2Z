# Longest Duplicate Substring

**Source:** LeetCode #1044 — https://leetcode.com/problems/longest-duplicate-substring/

## Problem Statement

Given a string `s`, consider all duplicated substrings: (contiguous) substrings of `s` that occur 2 or more times. The occurrences may overlap.

Return any duplicated substring that has the longest possible length. If `s` does not have a duplicated substring, return `""`.

## Example

**Input:** s = "banana"
**Output:** "ana"
**Explanation:** "ana" appears twice in "banana" (at index 1 and index 3), and it is the longest such duplicated substring.

**Input:** s = "abcd"
**Output:** ""
**Explanation:** There is no substring that appears more than once, so the answer is an empty string.

## Constraints

- 2 <= s.length <= 3 * 10^4
- s consists of lowercase English letters.

## Notes on this implementation

The file explicitly comments "This solution is not optimized" — it inserts every suffix of the string into a trie character by character, incrementing a `count` at each visited node; whenever a node's count exceeds 1 (meaning this path/substring has been seen before), it updates the longest duplicated substring found so far. This runs in O(n^2) time in the worst case, unlike the optimal binary-search + rolling-hash (Rabin–Karp) approach typically used for this problem.
