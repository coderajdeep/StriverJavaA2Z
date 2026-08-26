# Meeting Rooms II

**Source:** LeetCode #253 — https://leetcode.com/problems/meeting-rooms-ii/

## Problem Statement

Given an array of meeting time intervals `intervals` where `intervals[i] = [starti, endi]`, return the minimum number of conference rooms required.

## Example

**Input:** intervals = [[0,30],[5,10],[15,20]]
**Output:** 2
**Explanation:** [0,30] needs its own room. [5,10] and [15,20] can share a second room since they don't overlap each other, but both overlap [0,30].

**Input:** intervals = [[7,10],[2,4]]
**Output:** 1
**Explanation:** The two meetings do not overlap, so they can share the same room.

## Constraints

- 1 <= intervals.length <= 10^4
- 0 <= starti < endi <= 10^6
