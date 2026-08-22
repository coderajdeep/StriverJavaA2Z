# Topological Sort (DFS)

**Source:** takeUforward

## Problem Statement

Given a **Directed Acyclic Graph (DAG)** with `V` vertices (numbered `0` to `V-1`) and an adjacency list `adj`, find a **topological ordering** of the vertices.

A topological sort of a directed graph is a linear ordering of vertices such that for every directed edge `u → v`, vertex `u` comes before vertex `v` in the ordering. Topological sort is only possible for a DAG (a directed graph with no cycles).

Implement this using DFS: for every unvisited node, run DFS, and after all its descendants have been fully explored, push the node onto a stack. Once all nodes have been processed, popping the stack from top to bottom yields a valid topological order.

## Example

**Input:** `V = 6`, `adj = [[],[],[3],[1],[0,1],[0,2]]` (directed edges: 5→0, 5→2, 4→0, 4→1, 2→3, 3→1)

**Output:** `[5, 4, 2, 3, 1, 0]` (one valid ordering; multiple valid orderings may exist)

**Explanation:** Every directed edge points from an earlier node to a later node in the output ordering, e.g. 5 appears before 0 and 2, 2 appears before 3, and 3 appears before 1.

## Constraints

- `1 <= V <= 10^4`
- `0 <= adj[i].length <= V`
- The input graph is guaranteed to be a DAG (directed and acyclic).
