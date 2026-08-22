# Rotate Array by K Places (Left Rotation)

**Source:** LeetCode #189 — https://leetcode.com/problems/rotate-array/ (see discrepancy note below)

## Problem Statement

Given an integer array `nums`, rotate the array to the **left** by `k` positions, where `k` is non-negative.

The rotation should be done in-place using the reversal algorithm: reverse the first `k` elements, reverse the remaining `n-k` elements, then reverse the whole array.

## Example

**Input:** nums = [1, 2, 3, 4, 5, 6, 7], k = 3
**Output:** [4, 5, 6, 7, 1, 2, 3]
**Explanation:** The first 3 elements [1, 2, 3] move to the end, and the rest shift to the front.

**Input:** nums = [-1, -100, 3, 99], k = 2
**Output:** [3, 99, -1, -100]
**Explanation:** The first 2 elements move to the end after a left rotation by 2.

## Constraints

- 1 <= nums.length <= 10^5
- -2^31 <= nums[i] <= 2^31 - 1
- 0 <= k <= 10^5

## Discrepancy Note

The filename references LeetCode #189 ("Rotate Array"), but the canonical LC 189 problem asks you to rotate the array to the **right** by `k` steps (e.g., [1,2,3,4,5,6,7] with k=3 → [5,6,7,1,2,3,4]). The code in `Solution_06_leftRotateByK_189.java` (and its method name `rotateArrayByOne`'s sibling `rotateArray`) instead performs a **left** rotation by `k` using the classic three-reversal trick, matching the filename's "leftRotateByK" description rather than LC 189's right-rotation requirement. The problem statement above reflects what the code actually does (left rotation).
