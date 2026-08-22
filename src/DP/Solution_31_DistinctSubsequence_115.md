# Distinct Subsequences

**Source:** LeetCode #115 — https://leetcode.com/problems/distinct-subsequences/

## Problem Statement

Given two strings `s` and `t`, return the number of distinct subsequences of `s` which equal `t`.

The test cases are generated so that the answer fits on a 32-bit signed integer.

## Example

**Input:** s = "rabbbit", t = "rabbit"
**Output:** 3
**Explanation:** As shown below, there are 3 ways you can generate "rabbit" from s.
rabb**b**it
ra**b**bbit
rab**b**bit

**Input:** s = "babgbag", t = "bag"
**Output:** 5
**Explanation:** As shown below, there are 5 ways you can generate "bag" from s.
**ba**b**g**bag
**ba**bgba**g**
**b**abgb**ag**
ba**b**g**bag**
babg**bag**

## Constraints

- 1 <= s.length, t.length <= 1000
- s and t consist of English letters.
