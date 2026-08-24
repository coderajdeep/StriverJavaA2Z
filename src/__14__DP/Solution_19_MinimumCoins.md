# Minimum Coins (Coin Change)

**Source:** takeUforward (equivalent in objective to LeetCode #322 "Coin Change")

## Problem Statement

Given an array `coins` representing distinct coin denominations (each denomination is available in unlimited supply) and an integer `target` representing the amount of money, find the minimum number of coins required to make up the `target` amount.

If the `target` amount cannot be formed using any combination of the coins, return `-1`.

## Example

**Input:** coins = [1, 2, 3], target = 7
**Output:** 3
**Explanation:** 7 = 3 + 3 + 1, using 3 coins (or 2+2+3).

**Input:** coins = [2], target = 3
**Output:** -1
**Explanation:** The amount 3 cannot be made up using only coins of denomination 2.

## Constraints

- 1 <= coins.length <= 12
- 1 <= coins[i] <= 2^31 - 1
- 0 <= target <= 10^4
