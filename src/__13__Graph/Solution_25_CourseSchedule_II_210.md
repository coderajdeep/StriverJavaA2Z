# Course Schedule II

**Source:** LeetCode #210 — https://leetcode.com/problems/course-schedule-ii/

## Problem Statement

There are a total of `numCourses` courses you have to take, labeled from `0` to `numCourses - 1`. You are given an array `prerequisites` where `prerequisites[i] = [ai, bi]` indicates that you **must** take course `bi` first if you want to take course `ai`.

- For example, the pair `[0, 1]` indicates that to take course `0` you have to first take course `1`.

Return the ordering of courses you should take to finish all courses. If there are many valid answers, return **any** of them. If it is impossible to finish all courses, return an **empty array**.

This is solved by performing a topological sort (via Kahn's BFS algorithm) on the directed graph formed by edges `bi → ai`. If the number of courses successfully ordered equals `numCourses`, a valid order exists (the graph is a DAG); otherwise a cycle exists and an empty array is returned.

## Example

**Input:** `numCourses = 4`, `prerequisites = [[1,0],[2,0],[3,1],[3,2]]`

**Output:** `[0,1,2,3]` (one valid ordering; e.g. `[0,2,1,3]` is also valid)

**Explanation:** To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is `[0,1,2,3]`.

**Input:** `numCourses = 2`, `prerequisites = [[1,0],[0,1]]`

**Output:** `[]`

**Explanation:** There is a cycle (0 depends on 1, and 1 depends on 0), so there is no valid course order.

## Constraints

- `1 <= numCourses <= 2000`
- `0 <= prerequisites.length <= numCourses * (numCourses - 1)`
- `prerequisites[i].length == 2`
- `0 <= ai, bi < numCourses`
- `ai != bi`
- All the pairs `[ai, bi]` are distinct.
