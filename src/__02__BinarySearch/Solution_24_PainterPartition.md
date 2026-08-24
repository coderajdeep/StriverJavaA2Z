# Painter's Partition Problem

**Source:** takeUforward (originally from InterviewBit / Coding Ninjas)

## Problem Statement

Given `A` painters, each of whom takes `B` units of time to paint 1 unit of board, and `C` boards where `C[i]` is the length of the `i`-th board, find the minimum time required to paint all boards under the condition that any painter will only paint contiguous boards.

Two painters cannot share a board to paint (i.e. a board can be painted only by one painter), but a painter can paint multiple boards, as long as they are contiguous.

Since the answer can be very large, return the answer modulo `10000003`.

## Example

**Input:** A = 2 painters, B = 1 (time per unit length), boards = [10, 20, 30, 40]
**Output:** 60
**Explanation:** Splitting the boards into [10, 20, 30] (sum 60) for one painter and [40] (sum 40) for the other gives a maximum time of 60, which is the smallest achievable maximum among all contiguous splits into 2 groups.

**Input:** A = 2 painters, B = 1 (time per unit length), boards = [10, 10, 10, 10]
**Output:** 20
**Explanation:** One painter paints boards [10,10] (20 units of time) and the other paints [10,10] (20 units of time). The minimum possible value of the maximum time taken is 20.

## Constraints

- `1 <= A <= 1000` (number of painters)
- `1 <= B <= 10^6` (time to paint 1 unit of board)
- `1 <= C.length <= 10^5`
- `1 <= C[i] <= 10^6`
- Answer is returned modulo `10000003`.
