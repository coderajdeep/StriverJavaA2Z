# Remove K Digits

**Source:** LeetCode #402 — Remove K Digits

## Problem Statement

Given string `num` representing a non-negative integer `num`, and an integer `k`, return the smallest possible integer after removing `k` digits from `num`.

## Example

**Input:** num = "1432219", k = 3
**Output:** "1219"
**Explanation:** Remove the three digits 4, 3, and 2 to form the new number 1219, which is the smallest.

**Input:** num = "10200", k = 1
**Output:** "200"
**Explanation:** Remove the leading 1 to form 0200, which becomes 200 after removing leading zeros.

**Input:** num = "10", k = 2
**Output:** "0"

## Constraints

- 1 <= k <= num.length <= 10^5
- num consists of only digits.
- num does not have any leading zeros except for the zero itself.
