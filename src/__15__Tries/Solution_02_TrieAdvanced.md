# Implement Trie II (Prefix Tree)

**Source:** takeUforward — "Implement Trie – II (Prefix Tree)"

## Problem Statement

Implement a Trie class that supports the following operations, in addition to standard insert:

- `void insert(String word)` — Inserts a string `word` into the trie.
- `int countWordsEqualTo(String word)` — Returns how many times the exact string `word` has been inserted into the trie.
- `int countWordsStartingWith(String prefix)` — Returns the number of strings (previously inserted) that have `prefix` as a prefix.
- `void erase(String word)` — Removes one occurrence of the string `word` from the trie (if it exists).

Each trie node maintains two counters: `endCount` (how many words end at this node) and `prefixCount` (how many words pass through this node as a prefix), which are incremented on insert and decremented on erase.

## Example

**Input:**
```
insert("apple")
insert("apple")
insert("apps")
countWordsEqualTo("apple")     -> 2
countWordsStartingWith("app")  -> 3
erase("apple")
countWordsEqualTo("apple")     -> 1
countWordsStartingWith("app")  -> 2
```
**Output:** 2, 3, 1, 2
**Explanation:** "apple" was inserted twice, so countWordsEqualTo("apple") is 2 and countWordsStartingWith("app") counts all 3 inserted words ("apple", "apple", "apps") since they all start with "app". After erasing one "apple", only 1 remains and the prefix count for "app" drops to 2.

## Constraints

- 1 <= word.length, prefix.length <= 2000
- word and prefix consist only of lowercase English letters.
- At most 3 * 10^4 calls in total will be made to insert, countWordsEqualTo, countWordsStartingWith, and erase.
