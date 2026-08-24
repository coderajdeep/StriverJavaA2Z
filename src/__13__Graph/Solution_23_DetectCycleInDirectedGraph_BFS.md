# Detect Cycle in a Directed __13__Graph (BFS / Kahn's Algorithm)

**Source:** takeUforward

## Problem Statement

Given a **directed graph** with `V` vertices (numbered `0` to `V-1`) and an adjacency list `adj`, determine whether the graph contains a **cycle**, using the BFS-based Kahn's algorithm for topological sorting.

The approach:
1. Compute the in-degree of every vertex.
2. Push all vertices with in-degree `0` into a queue and process them via BFS, decrementing the in-degree of each neighbor as vertices are removed, adding newly-zero-in-degree neighbors to the queue.
3. Count how many vertices were successfully processed (removed from the graph).

If the count of processed vertices is **less than `V`**, then some vertices could never reach in-degree `0` — meaning they are part of a cycle (a valid topological order does not exist). Return `true` if a cycle exists, `false` otherwise.

## Example

**Input:** `V = 4`, `adj = [[1],[2],[3],[1]]` (directed edges: 0→1, 1→2, 2→3, 3→1)

**Output:** `true`

**Explanation:** Vertices 1, 2, 3 form a cycle (1→2→3→1), so none of them ever reach in-degree 0 during Kahn's algorithm; only vertex 0 gets processed, giving `count = 1 < V = 4`.

**Input:** `V = 4`, `adj = [[1],[2],[3],[]]` (directed edges: 0→1, 1→2, 2→3)

**Output:** `false`

**Explanation:** The graph is a DAG, so all 4 vertices are eventually processed (`count == V`), confirming no cycle.

## Constraints

- `1 <= V <= 10^4`
- `0 <= adj[i].length <= V`
- The graph is directed and may be disconnected.
