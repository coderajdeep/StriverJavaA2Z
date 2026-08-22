# Frog Jump

**Source:** takeUforward

## Problem Statement

There is a frog on the `1st` step of an `N` stairs long staircase. The frog wants to reach the `Nth` stair. `HEIGHT[i]` is the height of the `(i+1)th` stair.

If the frog jumps from the `ith` to the `jth` staircase, the energy consumed in the jump is `abs(HEIGHT[i] - HEIGHT[j])`, where `abs()` denotes the absolute difference.

The frog can jump either one or two steps at a time. Find the minimum total energy used by the frog to reach from the 1st stair to the Nth stair.

## Example

**Input:** n = 4, heights = [10, 20, 30, 10]
**Output:** 20
**Explanation:** The frog can jump from stair 0 to stair 1 (energy = 10), then from stair 1 to stair 3 (energy = 10). Total energy = 20, which is the minimum possible.

**Input:** n = 3, heights = [10, 50, 10]
**Output:** 0
**Explanation:** The frog jumps from stair 0 to stair 2 directly (energy = |10-10| = 0), since jumping two steps at a time is allowed.

## Constraints

- 1 <= n <= 10^5
- 0 <= heights[i] <= 10^4
