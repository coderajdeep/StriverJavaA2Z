# Intersection of Two Linked Lists

**Source:** LeetCode #160 — Intersection of Two Linked Lists

## Problem Statement

Given the heads of two singly linked-lists `headA` and `headB`, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return `null`.

The test cases are generated such that there are no cycles anywhere in the entire linked structure. Note that the linked lists must retain their original structure after the function returns — you may not modify either list.

## Example

**Input:** listA = [4,1,8,4,5], listB = [5,6,1,8,4,5] (intersecting at node with value 8)
**Output:** Intersected at '8'
**Explanation:** The two lists intersect at the node with value 8 (referring to the same node in memory, not just the same value).

**Input:** listA = [2,6,4], listB = [1,5]
**Output:** No intersection
**Explanation:** Since the two lists do not intersect, `intersectVal` must be 0, and the two lists should be treated as disjoint.

## Constraints

- The number of nodes of `listA` is in the range `[1, 3 * 10^4]`.
- The number of nodes of `listB` is in the range `[1, 3 * 10^4]`.
- `1 <= Node.val <= 10^5`
- Follow up: Could you write a solution that runs in O(m + n) time and use only O(1) memory?
