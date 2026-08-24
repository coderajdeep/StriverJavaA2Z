# Complete String (Longest Word With All Prefixes)

**Source:** takeUforward — "Complete String" (related to LeetCode #720 "Longest Word in Dictionary" and LeetCode #1858 "Longest Word With All Prefixes")

## Problem Statement

Given an array of `n` strings `words`, find the longest string in the array such that every prefix of it is also present in the array (i.e., the string is "complete" — buildable one character at a time using other words already present in the array).

If there is more than one string with the maximum length, return the lexicographically smallest one. If no such string exists, return `"None"`.

## Example

**Input:** words = ["n", "ni", "nin", "ninj", "ninja"]
**Output:** "ninja"
**Explanation:** Since all prefixes of "ninja" — "n", "ni", "nin", "ninj" — are present in the array, "ninja" is a complete string.

**Input:** words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
**Output:** "apple"
**Explanation:** "apple" and "apply" both have all of their prefixes present, and both have length 5. "apple" is lexicographically smaller than "apply", so it is the answer.

## Constraints

- 1 <= n <= 10^5
- 1 <= words[i].length <= 30
- words[i] consists of lowercase English letters.

## Notes on this implementation

The method is named `completeString`, matching the takeUforward naming of this exact problem. It builds a trie of all words, marking `isEnd` at each terminal node, then for each word checks (via `checkAllPrefixOfString`) whether every prefix along its path is itself a complete word in the trie, tracking the longest (and lexicographically smallest on ties) qualifying word.
