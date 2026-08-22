# Merge k Sorted Lists

**Source:** LeetCode #23 — https://leetcode.com/problems/merge-k-sorted-lists/

## Problem Statement

You are given an array of `k` linked-lists `lists`, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

## Example

**Input:** lists = [[1,4,5],[1,3,4],[2,6]]
**Output:** [1,1,2,3,4,4,5,6]
**Explanation:** The linked-lists are:
```
[
  1->4->5,
  1->3->4,
  2->6
]
```
merging them into one sorted list: `1->1->2->3->4->4->5->6`.

**Input:** lists = []
**Output:** []

## Constraints

- k == lists.length
- 0 <= k <= 10^4
- 0 <= lists[i].length <= 500
- -10^4 <= lists[i][j] <= 10^4
- lists[i] is sorted in ascending order.
- The sum of lists[i].length will not exceed 10^4.

## Notes on this implementation

Both `mergeKLists` and `mergeKListsBetterDataStructure` use a min-heap (`PriorityQueue`) seeded with the head node of each list; the smallest node is repeatedly polled, appended to the result, and replaced in the heap by its `next` node. Time complexity is O(N log k), where N is the total number of nodes across all lists.
