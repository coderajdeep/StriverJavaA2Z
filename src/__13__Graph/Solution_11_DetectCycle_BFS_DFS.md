# Detect Cycle in an Undirected __13__Graph (BFS and DFS)

**Source:** takeUforward

## Problem Statement

Given an undirected graph with `V` vertices and an adjacency list `adj`, determine if the graph contains a **cycle**. The graph may be disconnected, so all components must be checked.

Implement the check using both approaches:

- **DFS-based:** During DFS traversal, track the parent of the current node. If DFS reaches a node that is already visited and that node is not the immediate parent, a cycle exists.
- **BFS-based:** Using a queue that also tracks each node's parent, if BFS reaches a node that is already visited and it is not the parent of the current node, a cycle exists.

Return `true` if the graph contains at least one cycle, `false` otherwise.

## Example

**Input:** `V = 4`, `adj = [[1,2],[0,2],[0,1,3],[2]]` (edges: 0-1, 0-2, 1-2, 2-3)

**Output:** `true`

**Explanation:** The nodes 0, 1, 2 form a triangle (0-1, 1-2, 2-0), which is a cycle.

**Input:** `V = 4`, `adj = [[1],[0,2],[1,3],[2]]` (edges: 0-1, 1-2, 2-3)

**Output:** `false`

**Explanation:** The graph is a simple path 0-1-2-3 with no cycle.

## Constraints

- `1 <= V <= 10^4`
- `0 <= adj[i].length <= V`
- The graph is undirected and may be disconnected.
