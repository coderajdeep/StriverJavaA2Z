# Shortest Job First (SJF) — Minimum Average Waiting Time

**Source:** takeUforward — "Shortest job first (or SJF), minimum number of average waiting time" — https://takeuforward.org/data-structure/shortest-job-first-or-sjf-greedy-algorithm/

## Problem Statement

Given an array `bt` of `n` integers, where `bt[i]` denotes the burst time (execution time) of the `i`-th process. All processes arrive at time 0, and only one process can be executed at a time on a single CPU.

Find the minimum average waiting time when the CPU schedules the processes using the Shortest Job First (SJF) strategy, i.e., always run the process with the smallest remaining burst time next.

The waiting time of a process is the sum of the burst times of all processes scheduled before it.

## Example

**Input:** bt = [4, 3, 7, 1, 2]
**Output:** 4
**Explanation:** Sorting burst times gives [1, 2, 3, 4, 7]. Waiting times are 0, 1, 3, 6, 10, giving a total of 20 and an average of 20 / 5 = 4.

**Input:** bt = [1, 2, 3, 4]
**Output:** 2
**Explanation:** Waiting times are 0, 1, 3, 6, giving a total of 10 and an average of 10 / 4 = 2 (integer division).

## Constraints

- 1 <= n <= 10^5
- 1 <= bt[i] <= 10^5
