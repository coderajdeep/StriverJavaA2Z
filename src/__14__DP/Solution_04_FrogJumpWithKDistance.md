# Frog Jump with K Distances

**Source:** takeUforward

## Problem Statement

This is a follow-up to the Frog Jump problem. There is a frog on the `1st` step of an `N` stairs long staircase. The frog wants to reach the `Nth` stair. `HEIGHT[i]` is the height of the `(i+1)th` stair.

If the frog jumps from the `ith` to the `jth` staircase, the energy consumed in the jump is `abs(HEIGHT[i] - HEIGHT[j])`, where `abs()` denotes the absolute difference.

This time, instead of just 1 or 2 steps, the frog can jump from stair `i` to any stair in the range `[i+1, i+K]`, i.e. up to `K` steps at a time. Find the minimum total energy used by the frog to reach from the 1st stair to the Nth stair.

## Example

**Input:** n = 5, k = 3, heights = [10, 30, 40, 50, 20]
**Output:** 30
**Explanation:** The frog jumps from index 0 to index 1 (a jump of size 1, energy = |30-10| = 20), then from index 1 to index 4 (a jump of size 3, energy = |20-30| = 10). Total energy = 20 + 10 = 30, which is the minimum among all valid paths using jumps of size at most k = 3.

## Constraints

- 1 <= n <= 10^4
- 1 <= k <= n-1
- 0 <= heights[i] <= 10^4
