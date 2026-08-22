# Count Partitions with Given Difference

**Source:** takeUforward

## Problem Statement

Given an array `arr` of `n` non-negative integers and a target difference `diff`, count the number of ways to partition the array into two subsets `S1` and `S2` such that `S1 - S2 = diff` (where `sum(S1) >= sum(S2)`), and every array element belongs to exactly one of the two subsets. Return the count modulo `10^9 + 7`.

This reduces to Count Subsets with Sum K: since `S1 + S2 = totalSum` and `S1 - S2 = diff`, we get `S1 = (totalSum + diff) / 2`. Count the number of subsets of `arr` that sum to this value of `S1`. If `(totalSum + diff)` is odd, or the required target exceeds the total sum, the answer is 0.

## Example

**Input:** arr = [1, 1, 2, 3], diff = 1
**Output:** 3
**Explanation:** Total sum = 7, so S1 = (7+1)/2 = 4. The number of subsets summing to 4 is 3: {1,3}, {1,3} (using the other 1), {1,1,2}.

**Input:** arr = [1, 2, 3, 3], diff = 1
**Output:** 2

## Constraints

- 1 <= arr.length <= 100
- 0 <= arr[i] <= 1000
- 0 <= diff <= sum(arr)
