# Number of Provinces

**Source:** LeetCode #547 — https://leetcode.com/problems/number-of-provinces/

## Problem Statement

There are `n` cities. Some of them are directly connected, while some are not. If city `a` is directly connected with city `b`, and city `b` is directly connected with city `c`, then city `a` is indirectly connected with city `c`.

A **province** is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an `n x n` matrix `isConnected` where `isConnected[i][j] = 1` if the `ith` city and the `jth` city are directly connected, and `isConnected[i][j] = 0` otherwise.

Return the total number of **provinces**.

## Example

**Input:** `isConnected = [[1,1,0],[1,1,0],[0,0,1]]`

**Output:** `2`

**Explanation:** Cities 0 and 1 are directly connected and form one province; city 2 is isolated and forms a second province.

**Input:** `isConnected = [[1,0,0],[0,1,0],[0,0,1]]`

**Output:** `3`

**Explanation:** No two cities are connected, so each city is its own province.

## Constraints

- `1 <= n <= 200`
- `n == isConnected.length == isConnected[i].length`
- `isConnected[i][j]` is `1` or `0`
- `isConnected[i][i] == 1`
- `isConnected[i][j] == isConnected[j][i]`
