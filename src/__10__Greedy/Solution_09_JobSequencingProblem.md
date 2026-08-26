# Job Sequencing Problem

**Source:** GeeksforGeeks / takeUforward — https://www.geeksforgeeks.org/dsa/job-sequencing-problem/

## Problem Statement

Given a set of `N` jobs where each job `i` has a deadline and profit associated with it. Each job takes 1 unit of time to complete, and only one job can be scheduled at a time. You will earn the profit associated with a job only if it is completed within its deadline (deadlines are 1-indexed, i.e., a job with deadline `d` must be finished on or before the `d`-th time slot).

Find the number of jobs done and the maximum profit that can be obtained, if only one job can be scheduled at a time, by greedily choosing the highest-profit jobs first and slotting each one into the latest available free day at or before its deadline.

## Example

**Input:** Jobs = [[1, 4, 20], [2, 1, 10], [3, 1, 40], [4, 1, 30]] (format: [id, deadline, profit])
**Output:** [2, 60]
**Explanation:** Job 3 (deadline 1, profit 40) and Job 1 (deadline 4, profit 20) are scheduled, giving 2 jobs done and total profit 60.

**Input:** Jobs = [[1, 2, 100], [2, 1, 19], [3, 2, 27], [4, 1, 25], [5, 1, 15]]
**Output:** [2, 127]
**Explanation:** Job 1 (deadline 2, profit 100) and Job 3 (deadline 2, profit 27) are scheduled.

## Constraints

- 1 <= N <= 10^5
- 1 <= deadline <= N
- 1 <= profit <= 500
