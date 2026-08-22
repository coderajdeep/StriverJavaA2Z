# Topological Sort (BFS / Kahn's Algorithm)

**Source:** takeUforward

## Problem Statement

Given a **Directed Acyclic Graph (DAG)** with `V` vertices (numbered `0` to `V-1`) and an adjacency list `adj`, find a **topological ordering** of the vertices using the BFS-based approach known as **Kahn's Algorithm**.

Kahn's algorithm works as follows:
1. Compute the in-degree (number of incoming edges) of every vertex.
2. Push all vertices with in-degree `0` into a queue.
3. Repeatedly pop a vertex from the queue, append it to the result, and decrement the in-degree of each of its neighbors. If a neighbor's in-degree drops to `0`, push it into the queue.
4. Continue until the queue is empty. The order in which vertices were popped is a valid topological order.

Return an array representing a valid topological ordering of the vertices.

## Example

**Input:** `V = 6`, `adj = [[],[],[3],[1],[0,1],[0,2]]` (directed edges: 5→0, 5→2, 4→0, 4→1, 2→3, 3→1)

**Output:** `[4, 5, 2, 3, 1, 0]` (one valid ordering produced by Kahn's algorithm; multiple valid orderings may exist)

**Explanation:** Vertices 4 and 5 have in-degree 0 initially and are processed first; removing their outgoing edges reduces the in-degree of 0, 1, and 2, allowing them to be processed next, and so on.

## Constraints

- `1 <= V <= 10^4`
- `0 <= adj[i].length <= V`
- The input graph is guaranteed to be a DAG (directed and acyclic).

## Note on this file's implementation

Despite the filename and intent ("BFS"/Kahn's algorithm), the code in `Solution_22_TopologicalSort_BFS.java` is byte-for-byte identical in logic to `Solution_21_TopologicalSort_DFS.java` — it uses the recursive DFS + stack approach rather than an in-degree-based BFS queue (Kahn's algorithm). This looks like a copy-paste artifact in the source rather than an actual Kahn's-algorithm implementation. The problem statement above describes the intended BFS/Kahn's-algorithm problem this file is meant to represent, per the takeUforward series; the discrepancy in the actual code is noted here per the source's own logic taking precedence.
