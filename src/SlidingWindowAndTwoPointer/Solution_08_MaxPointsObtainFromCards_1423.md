# Maximum Points You Can Obtain from Cards

**Source:** LeetCode #1423 — https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

## Problem Statement

There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array `cardPoints`.

In one step, you can take one card from the beginning or from the end of the row. You have to take exactly `k` cards.

Your score is the sum of the points of the cards you have taken.

Given the integer array `cardPoints` and the integer `k`, return the maximum score you can obtain.

## Example

**Input:** cardPoints = [1,2,3,4,5,6,1], k = 3
**Output:** 12
**Explanation:** After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.

**Input:** cardPoints = [2,2,2], k = 2
**Output:** 4
**Explanation:** Regardless of which two cards you take, your score will always be 4.

**Input:** cardPoints = [9,7,7,9,7,7,9], k = 7
**Output:** 55
**Explanation:** You have to take all the cards. Your score is the total points of all cards.

## Constraints

- 1 <= cardPoints.length <= 10^5
- 1 <= cardPoints[i] <= 10^4
- 1 <= k <= cardPoints.length

## Notes on this implementation

The problem is reframed as finding the minimum-sum contiguous subarray of length `n - k` to exclude (leaving the maximum-sum combination of a prefix and suffix totaling `k` cards). The implementation starts with the sum of the first `k` cards, then slides the "kept" window by swapping one card from the front for one from the back, one step at a time, tracking the maximum sum seen — O(n) time, O(1) space.
