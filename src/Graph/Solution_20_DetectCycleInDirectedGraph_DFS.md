# Detect Cycle in a Directed Graph (DFS)

**Source:** takeUforward

## Problem Statement

Given a **directed graph** with `V` vertices (numbered `0` to `V-1`) and an adjacency list `adj`, determine whether the graph contains a **cycle**.

Use DFS traversal while maintaining two boolean arrays: `visited[]` to track globally visited nodes, and `path[]` (a.k.a. the recursion/DFS-call-stack marker) to track nodes currently on the active recursion path. If DFS reaches a node that is already marked `true` in `path[]` (i.e., it is an ancestor in the current DFS path, not merely a previously-visited node in another branch), a cycle exists. When backtracking from a node, unmark it from `path[]`.

Return `true` if the directed graph contains at least one cycle, `false` otherwise.

## Example

**Input:** `V = 4`, `adj = [[1],[2],[3],[1]]` (directed edges: 0→1, 1→2, 2→3, 3→1)

**Output:** `true`

**Explanation:** Following 1→2→3→1 revisits node 1 while it is still on the current recursion path, indicating a cycle.

**Input:** `V = 4`, `adj = [[1],[2],[3],[]]` (directed edges: 0→1, 1→2, 2→3)

**Output:** `false`

**Explanation:** The graph is a simple directed chain with no back-edge to an ancestor on the current path.

## Constraints

- `1 <= V <= 10^4`
- `0 <= adj[i].length <= V`
- The graph is directed and may be disconnected.
