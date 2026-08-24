# __13__Graph BFS and DFS Traversal

**Source:** takeUforward

## Problem Statement

Given an undirected and disconnected graph with `V` vertices (numbered `0` to `V-1`) and a list of `edges`, where each edge is a pair `[u, v]` denoting an undirected edge between vertex `u` and vertex `v`, implement two standard graph traversals:

1. **`dfsOfGraph`** — Return a list containing the Depth First Search (DFS) traversal of the graph starting from vertex `0`, visiting adjacent unvisited nodes recursively. Since the graph may be disconnected, the traversal must also start fresh DFS calls from every yet-unvisited vertex so that all components are covered.
2. **`bfsOfGraph`** — Return a list containing the Breadth First Search (BFS) traversal of the graph starting from vertex `0`, using a queue to visit nodes level by level. As with DFS, unvisited vertices belonging to other components must also be traversed.

Build an adjacency list from the given edge list first (since the graph is undirected, add both directions for every edge), then run the traversal.

## Example

**Input:** `V = 5`, `edges = [[0,1],[0,2],[1,3],[1,4]]`

**Output (DFS):** `[0, 1, 3, 4, 2]`

**Output (BFS):** `[0, 1, 2, 3, 4]`

**Explanation:** Starting at node `0`, DFS dives deep along one branch before backtracking (0 → 1 → 3, backtrack → 4, backtrack → 2), while BFS explores all neighbors of a node before moving further (0's neighbors 1, 2, then 1's neighbors 3, 4).

## Constraints

- `1 <= V <= 10^4`
- `0 <= edges.length <= 10^4`
- `0 <= u, v < V`
- The graph may be disconnected.
- The graph has no self-loops.
