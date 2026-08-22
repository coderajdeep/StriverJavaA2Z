# Rearrange Array Elements by Sign

**Source:** LeetCode #2149 — https://leetcode.com/problems/rearrange-array-elements-by-sign/

## Problem Statement

You are given a 0-indexed integer array `nums` of even length, consisting of an equal number of positive and negative integers.

Rearrange the elements of `nums` such that the modified array follows the below conditions:
1. Every consecutive pair of integers have opposite signs.
2. For all integers with the same sign, the order in which they were present in the original array is preserved.
3. The rearranged array begins with a positive integer.

Return the modified array after rearranging the elements to satisfy the above conditions.

## Example

**Input:** nums = [3, 1, -2, -5, 2, -4]
**Output:** [3, -2, 1, -5, 2, -4]
**Explanation:** The positive integers, in order, are [3, 1, 2]. The negative integers, in order, are [-2, -5, -4]. The only possible way to rearrange them such that they satisfy all conditions is [3, -2, 1, -5, 2, -4].

**Input:** nums = [-1, 1]
**Output:** [1, -1]
**Explanation:** 1 is the only positive integer and -1 the only negative integer, so they are rearranged to be [1, -1].

## Constraints

- 2 <= nums.length <= 2 * 10^5
- nums.length is even
- 1 <= |nums[i]| <= 10^5
- nums consists of equal number of positive and negative integers.
