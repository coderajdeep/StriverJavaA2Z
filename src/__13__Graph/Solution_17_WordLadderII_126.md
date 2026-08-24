# Word Ladder II

**Source:** LeetCode #126 — https://leetcode.com/problems/word-ladder-ii/

## Problem Statement

A **transformation sequence** from word `beginWord` to word `endWord` using a dictionary `wordList` is a sequence of words `beginWord -> s1 -> s2 -> ... -> sk` such that:

- Every adjacent pair of words differs by a single letter.
- Every `si` for `1 <= i <= k` is in `wordList`. Note that `beginWord` does not need to be in `wordList`.
- `sk == endWord`

Given two words, `beginWord` and `endWord`, and a dictionary `wordList`, return **all the shortest transformation sequences** from `beginWord` to `endWord`, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words `[beginWord, s1, s2, ..., endWord]`.

## Example

**Input:** `beginWord = "hit"`, `endWord = "cog"`, `wordList = ["hot","dot","dog","lot","log","cog"]`

**Output:** `[["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]`

**Explanation:** There are two shortest transformation sequences of length 5 from "hit" to "cog". A level-by-level BFS is used to find the shortest length, collecting all paths that reach `endWord` at that level, and removing all words visited at that level from the dictionary before moving to the next level (so no shorter/invalid paths are reused).

**Input:** `beginWord = "hit"`, `endWord = "cog"`, `wordList = ["hot","dot","dog","lot","log"]`

**Output:** `[]`

**Explanation:** `endWord` `"cog"` is not in `wordList`, so no transformation sequence exists.

## Constraints

- `1 <= beginWord.length <= 5`
- `endWord.length == beginWord.length`
- `1 <= wordList.length <= 1000`
- `wordList[i].length == beginWord.length`
- `beginWord`, `endWord`, and `wordList[i]` consist of lowercase English letters.
- `beginWord != endWord`
- All the words in `wordList` are unique.
- The sum of all shortest transformation sequences does not exceed `10^5`.
