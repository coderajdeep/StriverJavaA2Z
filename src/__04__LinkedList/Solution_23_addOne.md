# Add 1 to a Number Represented as a Linked List

**Source:** takeUforward

## Problem Statement

You are given a non-negative integer represented as a singly linked list of digits. The digits are stored such that the most significant digit is at the head of the list. Add one to the number represented by the linked list and return the head of the resulting linked list, handling any carry propagation (including growing the list by one extra digit if the number overflows, e.g. 999 + 1 = 1000).

A common approach: reverse the list, add 1 starting from the (now first) least significant digit while propagating carry, appending an extra node if a carry remains at the end, then reverse the list back.

## Example

**Input:** head = [1,2,3]
**Output:** [1,2,4]
**Explanation:** 123 + 1 = 124.

**Input:** head = [9,9,9]
**Output:** [1,0,0,0]
**Explanation:** 999 + 1 = 1000, so an extra node is prepended.

## Constraints

- `1 <= number of nodes <= 10^4`
- `0 <= Node.val <= 9`
- The input list represents a valid number without leading zeros (unless the number itself is 0).
