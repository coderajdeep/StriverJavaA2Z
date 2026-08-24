# Minimum Window Subsequence

**Source:** LeetCode #727 — https://leetcode.com/problems/minimum-window-subsequence/ (Premium)

## Problem Statement

Given strings `s1` and `s2`, return the minimum contiguous substring `part` of `s1`, so that `s2` is a subsequence of `part`.

If there is no such window in `s1` that covers all characters in `s2`, return the empty string `""`. If there are multiple such minimum-length windows, return the one with the left-most starting index.

Note the distinction from LeetCode #76 (Minimum Window Substring): here `s2` must appear as a **subsequence** (characters in order, not necessarily contiguous or with matching frequency requirements) of the returned window, not merely have all its characters present anywhere in the window.

## Example

**Input:** s1 = "abcdebdde", s2 = "bde"
**Output:** "bcde"
**Explanation:** "bcde" is the answer because it occurs before "bdde" which has the same length. "deb" is not a smaller window because the elements of s2 in the window must occur in order.

**Input:** s1 = "jmeqksfrsdcmsiwvaovztaqenprpvnbstl", s2 = "u"
**Output:** ""
**Explanation:** s2 contains a character 'u' that never appears in s1, so there is no valid window.

## Constraints

- 1 <= s1.length <= 2 * 10^4
- 1 <= s2.length <= 100
- s1 and s2 consist of lowercase English letters.

## Notes on this implementation

`minWindow` is the greedy two-pointer approach: scan `s1` left to right matching characters of `s2` in order; once `s2` is fully matched ending at index `i`, walk backward from `i` to find the earliest valid start of that window, then continue scanning forward from just after the found start to look for a shorter window. `minWindowDP` is a __14__DP approach where `dp[i][j]` represents the starting index (length-based) of the minimum window of `s1` ending at index `i-1` that contains `s2` as a subsequence up to index `j-1`.
