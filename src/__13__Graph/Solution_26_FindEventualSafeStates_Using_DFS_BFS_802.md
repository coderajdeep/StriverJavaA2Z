# Find Eventual Safe States

**Source:** LeetCode #802 — https://leetcode.com/problems/find-eventual-safe-states/

## Problem Statement

There is a directed graph of `n` nodes with each node labeled from `0` to `n - 1`. The graph is represented by a 0-indexed 2D integer array `graph` where `graph[i]` is an integer array of nodes adjacent to node `i`, meaning there is an edge from node `i` to each node in `graph[i]`.

A node is a **terminal node** if there are no outgoing edges. A node is a **safe node** if every possible path starting from that node leads to a terminal node (or another safe node) — i.e., no path starting from a safe node can ever reach a cycle.

Return an array containing all the **safe nodes** of the graph. The answer should be sorted in **ascending order**.

Two classic approaches are used:
- **DFS-based (white/gray/black coloring):** During DFS, mark nodes currently on the recursion path (`path[]`); if a DFS from a node reaches a node still on the active path, that entire path is unsafe (part of a cycle). Nodes never found to lead into a cycle are safe.
- **BFS-based (reverse graph + Kahn's algorithm):** Reverse all edges, compute in-degrees on the reversed graph (which equals out-degree of the original graph), and repeatedly remove nodes with in-degree `0` (i.e., original out-degree `0`, terminal-like). Every node eventually removed this way is safe.

## Example

**Input:** `graph = [[1,2],[2,3],[5],[0],[5],[],[]]`

**Output:** `[2,4,5,6]`

**Explanation:** The nodes `5` and `6` are terminal nodes (no outgoing edges), so they are trivially safe. Node `4` only leads to node `5`, a safe node, so it is also safe. Node `2` leads to node `5`, so it is safe. Nodes `0`, `1`, `3` form a cycle (0→1→2... but actually 0→1, 1→2, 1→3, 3→0, forming a cycle 0→1→3→0), so they are not safe.

## Constraints

- `n == graph.length`
- `1 <= n <= 10^4`
- `0 <= graph[i].length <= n`
- `0 <= graph[i][j] <= n - 1`
- `graph[i]` is sorted in ascending order.
- The graph may contain self-loops.
- The number of edges in the graph will not exceed `10^4`.
