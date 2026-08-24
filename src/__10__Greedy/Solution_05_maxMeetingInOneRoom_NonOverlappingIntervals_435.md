# Non-overlapping Intervals / Maximum Meetings in One Room

**Source:** LeetCode #435 — https://leetcode.com/problems/non-overlapping-intervals/ (method `eraseOverlapIntervals`), and takeUforward — "N meetings in one room" (methods `maxMeetingsCleanImplementation` / `maxMeetingsSimpleImplementation`)

This file contains solutions to two closely related greedy interval-scheduling problems.

## Problem Statement 1 — Non-overlapping Intervals (LeetCode #435)

Given an array of intervals `intervals` where `intervals[i] = [starti, endi]`, return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note that intervals which only touch at a point are non-overlapping. For example, `[1, 2]` and `[2, 3]` are non-overlapping.

### Example

**Input:** intervals = [[1,2],[2,3],[3,4],[1,3]]
**Output:** 1
**Explanation:** [1,3] can be removed and the rest of the intervals are non-overlapping.

**Input:** intervals = [[1,2],[1,2],[1,2]]
**Output:** 2
**Explanation:** You need to remove two [1,2] to make the rest of the intervals non-overlapping.

### Constraints

- 1 <= intervals.length <= 10^5
- intervals[i].length == 2
- -5 * 10^4 <= starti < endi <= 5 * 10^4

## Problem Statement 2 — N Meetings in One Room (takeUforward)

There is one meeting room. Given the start time (`start[]`) and end time (`end[]`) of `N` meetings, find the maximum number of meetings that can be accommodated in this room such that only one meeting can be held in the room at any given time. Two meetings can be scheduled one after another if the start time of one meeting equals the end time of another. Return the maximum number of meetings that can be performed (greedily choosing the meeting that finishes earliest at each step).

### Example

**Input:** start = [1, 3, 0, 5, 8, 5], end = [2, 4, 6, 7, 9, 9]
**Output:** 4
**Explanation:** Meetings at indices (1,2), (2,4), (5,7), (8,9) can be performed — meeting 1 (1-2), meeting 2 (3-4), meeting 4 (5-7), meeting 5 (8-9).

### Constraints

- 1 <= N <= 10^5
- 0 <= start[i] < end[i] <= 10^5
