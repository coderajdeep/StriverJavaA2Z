# Ninja's Training (Paint House / N Activities, M Points)

**Source:** takeUforward (generalized version of LeetCode #256 "Paint House")

**Note on discrepancy:** The filename references LeetCode #256 (Paint House), which asks for the *minimum cost* to paint `n` houses using exactly 3 colors such that no two adjacent houses share a color. The code in this file solves the more general takeUforward "Ninja's Training" formulation: `n` days and `m` activities/tasks (not fixed at 3), and it *maximizes* points earned (merit points) rather than minimizing cost, with the constraint that the same activity cannot be performed on two consecutive days. The underlying DP transition (choose an option this row that differs from the option chosen in the adjacent row, using values from the previous row) is identical in structure to Paint House; only the objective (max vs min) and the number of choices (m vs fixed 3) differ. This document describes the actual problem solved by the code — Ninja's Training.

## Problem Statement

A Ninja has an `n` day training schedule. He has to perform one of three activities each day (Running, Fighting Practice, or Learning New Moves). Each activity has some merit points on each day. As a support, he has `points[][]` array which gives points on each day for each activity. The rules are:
- On any day, the Ninja can perform any one of three activities.
- Merit points for performing the given activity on a particular day are given by `points[day][activity]`.
- The Ninja must not perform the same activity on two consecutive days.

Find the maximum merit points the Ninja can earn.

(In the generalized version implemented here, the number of activities per day is `m`, not fixed at 3.)

## Example

**Input:** points = [[10,40,70],[20,50,80],[30,60,90]]
**Output:** 210
**Explanation:** Day 0: choose activity 2 (70 points). Day 1: choose activity 1 (50 points, cannot repeat activity 2 from the previous day). Day 2: choose activity 2 (90 points, cannot repeat activity 1 from the previous day). Total = 70 + 50 + 90 = 210, which is the maximum achievable.

## Constraints

- 1 <= n <= 10^5
- m >= 2 (number of activities/tasks per day)
- 1 <= points[i][j] <= 100
