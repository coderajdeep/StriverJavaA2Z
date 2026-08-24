# Kth Missing Positive Number

**Source:** LeetCode #1539 — https://leetcode.com/problems/kth-missing-positive-number/

## Problem Statement

Given an array `arr` of positive integers sorted in a strictly increasing order, and an integer `k`, return the `k`-th positive integer that is **missing** from this array.

## Example

**Input:** arr = [2,3,4,7,11], k = 5
**Output:** 9
**Explanation:** The missing positive integers are [1,5,6,8,9,10,...]. The 5th missing positive integer is 9.

**Input:** arr = [1,2,3,4], k = 2
**Output:** 6
**Explanation:** The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.

## Constraints

- `1 <= arr.length <= 1000`
- `1 <= arr[i] <= 1000`
- `1 <= k <= 1000`
- `arr[i] < arr[i+1]` for all valid `i`.
