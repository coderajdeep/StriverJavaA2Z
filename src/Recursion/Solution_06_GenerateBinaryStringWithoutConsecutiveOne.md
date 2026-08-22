# Generate Binary Strings Without Consecutive 1s

**Source:** takeUforward

## Problem Statement

Given a positive integer `n`, generate and return all binary strings of length `n` that do not contain two consecutive `1`s.

Use recursion: at every index, you may always place a `0`. You may place a `1` only if the previous character placed was not a `1` (or this is the first character).

## Example

**Input:** n = 3
**Output:** ["000","001","010","100","101"]
**Explanation:** These are all the binary strings of length 3 with no two consecutive 1s. Strings like "011", "110", "111" are excluded because they contain consecutive 1s.

**Input:** n = 2
**Output:** ["00","01","10"]

## Constraints

- `1 <= n <= 20`
