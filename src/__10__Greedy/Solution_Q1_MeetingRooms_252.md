# Meeting Rooms

**Source:** LeetCode #252 — https://leetcode.com/problems/meeting-rooms/

## Problem Statement

Given an array of meeting time intervals `intervals` where `intervals[i] = [starti, endi]`, determine if a person could attend all meetings.

## Example

**Input:** intervals = [[0,30],[5,10],[15,20]]
**Output:** false
**Explanation:** [0,30] overlaps with both [5,10] and [15,20], so the person cannot attend all meetings.

**Input:** intervals = [[7,10],[2,4]]
**Output:** true
**Explanation:** The two meetings do not overlap.

## Constraints

- 0 <= intervals.length <= 10^4
- intervals[i].length == 2
- 0 <= starti < endi <= 10^6
