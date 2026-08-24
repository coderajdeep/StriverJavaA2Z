# Number of Connected Components in an Undirected __13__Graph

**Source:** takeUforward

## Problem Statement

You are given `V` vertices (numbered `0` to `V-1`) and a list of `edges` of an undirected graph, where each edge is a pair `[u, v]` denoting an undirected edge between vertex `u` and vertex `v`. The graph may not be fully connected — it can consist of several separate components.

Build the adjacency list from the edge list and, using DFS (or BFS), find the total number of **connected components** in the graph — that is, the number of separate groups of vertices such that every vertex in a group is reachable from every other vertex in the same group, and no vertex in one group is reachable from a vertex in another group.

## Example

**Input:** `V = 7`, `edges = [[0,1],[1,2],[3,4]]`

**Output:** `3`

**Explanation:** The vertices split into three connected components: `{0, 1, 2}`, `{3, 4}`, and `{5}`, `{6}` are isolated — giving components `{0,1,2}`, `{3,4}`, `{5}`, `{6}`, i.e. a total of 4. (For the given example edges with `V = 7`, vertices 5 and 6 are isolated singleton components, so the total count is 4.)

## Constraints

- `1 <= V <= 10^5`
- `0 <= edges.length <= 10^5`
- `0 <= u, v < V`
- The graph may be disconnected and may contain multiple separate components.
