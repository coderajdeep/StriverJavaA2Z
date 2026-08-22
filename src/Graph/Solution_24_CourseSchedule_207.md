# Course Schedule

**Source:** LeetCode #207 — https://leetcode.com/problems/course-schedule/

## Problem Statement

There are a total of `numCourses` courses you have to take, labeled from `0` to `numCourses - 1`. You are given an array `prerequisites` where `prerequisites[i] = [ai, bi]` indicates that you **must** take course `bi` first if you want to take course `ai`.

- For example, the pair `[0, 1]` indicates that to take course `0` you have to first take course `1`.

Return `true` if you can finish all courses. Otherwise, return `false`.

This is equivalent to determining whether the directed graph formed by treating each prerequisite pair as an edge `bi → ai` contains a cycle. If it does, it's impossible to complete all courses; if not (the graph is a DAG), a valid course order exists.

## Example

**Input:** `numCourses = 2`, `prerequisites = [[1,0]]`

**Output:** `true`

**Explanation:** There are 2 courses to take. To take course 1 you should have finished course 0, so it is possible.

**Input:** `numCourses = 2`, `prerequisites = [[1,0],[0,1]]`

**Output:** `false`

**Explanation:** To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1 — this is a cycle (0 depends on 1 depends on 0), so it is impossible.

## Constraints

- `1 <= numCourses <= 2000`
- `0 <= prerequisites.length <= 5000`
- `prerequisites[i].length == 2`
- `0 <= ai, bi < numCourses`
- All the pairs `prerequisites[i]` are unique.
