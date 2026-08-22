# Count Distinct Substrings of a String

**Source:** takeUforward — "Number of Distinct Substrings in a String"

## Problem Statement

Given a string `s`, count the total number of distinct substrings of this string, including the empty substring.

The approach: insert every suffix of the string into a trie character by character. Each time a new trie node needs to be created while walking down the trie, that represents a brand-new distinct substring. Summing these new-node creations across all suffixes, plus 1 for the empty substring, gives the total distinct substring count.

## Example

**Input:** s = "ab"
**Output:** 4
**Explanation:** The distinct substrings of "ab" are: "" (empty), "a", "b", "ab" — a total of 4.

**Input:** s = "aa"
**Output:** 3
**Explanation:** The distinct substrings of "aa" are: "" (empty), "a", "aa" — a total of 3 (the substring "a" appearing at two positions is only counted once).

## Constraints

- 1 <= s.length <= 10^3 (typical for the trie-based approach, O(n^2) time)
- s consists of lowercase English letters.

## Complexity

- Time complexity: O(n^2) — inserting all n suffixes, each up to length n
- Space complexity: O(n^2) in the worst case for trie nodes
