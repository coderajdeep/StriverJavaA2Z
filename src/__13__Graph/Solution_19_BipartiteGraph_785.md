# Is __13__Graph Bipartite?

**Source:** LeetCode #785 — https://leetcode.com/problems/is-graph-bipartite/

## Problem Statement

There is an undirected graph with `V` vertices, where each vertex is labeled from `0` to `V - 1`. The graph is described by an edge list (or, in LeetCode's original formulation, an adjacency list `graph` where `graph[u]` is the list of nodes adjacent to node `u`).

A graph is **bipartite** if the vertices can be partitioned into two independent sets `A` and `B` such that every edge in the graph connects a vertex in set `A` and a vertex in set `B`. Equivalently, the graph is bipartite if and only if it can be properly 2-colored — every adjacent pair of nodes must have different colors.

Return `true` if and only if the graph is bipartite.

*(Note: the solution's method signature `isBipartite(int V, List<List<Integer>> edges)` builds an adjacency list from an edge list, whereas LeetCode 785's original signature takes the adjacency list directly as `boolean isBipartite(int[][] graph)`. The underlying algorithm — 2-coloring via BFS/DFS — and the problem being solved are identical; only the input representation differs.)*

## Example

**Input:** `graph = [[1,2,3],[0,2],[0,1,3],[0,2]]`

**Output:** `false`

**Explanation:** Node 0 connects to nodes 1, 2, and 3. Attempting to 2-color: if node 0 is colored red, nodes 1, 2, 3 must be blue. But node 1 and node 3 are both blue and connect to node 2 (also required blue), creating a conflict — specifically node 0 and node 2 are both connected to 1 and 3, forming an odd cycle, so no valid 2-coloring exists.

**Input:** `graph = [[1,3],[0,2],[1,3],[0,2]]`

**Output:** `true`

**Explanation:** Nodes `{0, 2}` can be colored red and `{1, 3}` colored blue; every edge goes between the two color sets.

## Constraints

- `1 <= V <= 100`
- `0 <= edges.length <= V * (V - 1) / 2`
- There are no self-edges or repeated edges.
- The graph may be disconnected.
