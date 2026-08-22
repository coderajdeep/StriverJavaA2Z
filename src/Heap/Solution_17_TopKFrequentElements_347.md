# Top K Frequent Elements

**Source:** LeetCode #347 — https://leetcode.com/problems/top-k-frequent-elements/

## Problem Statement

Given an integer array `nums` and an integer `k`, return the `k` most frequent elements. You may return the answer in any order.

## Example

**Input:** nums = [1,1,1,2,2,3], k = 2
**Output:** [1,2]

**Input:** nums = [1], k = 1
**Output:** [1]

## Constraints

- 1 <= nums.length <= 10^5
- -10^4 <= nums[i] <= 10^4
- k is in the range [1, the number of distinct elements in the array].
- It is guaranteed that the answer is unique.

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

## Notes on this implementation

Instead of a heap, this solution uses bucket sort: it counts frequency of every number with a HashMap, then buckets numbers by frequency (`freq[frequency] = list of numbers`), and finally scans buckets from highest frequency down to collect the top `k` numbers — achieving O(n + k) time complexity instead of the typical O(n log k) heap-based approach.
