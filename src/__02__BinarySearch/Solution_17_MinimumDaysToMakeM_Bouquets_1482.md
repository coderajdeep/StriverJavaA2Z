# Minimum Number of Days to Make m Bouquets

**Source:** LeetCode #1482 — https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

## Problem Statement

You are given an integer array `bloomDay`, an integer `m` and an integer `k`. You want to make `m` bouquets. To make a bouquet, you need to use `k` **adjacent** flowers from the garden.

The garden consists of `n` flowers, the `i`-th flower will bloom on day `bloomDay[i]`, and then can be used in exactly one bouquet.

Return the minimum number of days you need to wait to be able to make `m` bouquets from the garden. If it is impossible to make `m` bouquets, return `-1`.

## Example

**Input:** bloomDay = [1,10,3,10,2], m = 3, k = 1
**Output:** 3
**Explanation:** Let's see what happens by the end of day 3: flowers [1,x,3,x,2] — we can make 3 bouquets each using 1 flower. So 3 is the answer.

**Input:** bloomDay = [1,10,3,10,2], m = 3, k = 2
**Output:** -1
**Explanation:** We need 6 flowers to make 3 bouquets but there are only 5 flowers, so it is impossible.

## Constraints

- `bloomDay.length == n`
- `1 <= n <= 10^5`
- `1 <= bloomDay[i] <= 10^9`
- `1 <= m <= 10^6`
- `1 <= k <= n`
