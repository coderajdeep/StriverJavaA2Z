# Allocate Minimum Number of Pages (Book Allocation Problem)

**Source:** takeUforward

## Problem Statement

Given an array `nums` of `n` integers where `nums[i]` represents the number of pages in the `i`-th book, and an integer `m` representing the number of students, allocate all the books to the `m` students such that:

- Each student gets at least one book.
- Each book is allocated to exactly one student.
- The allocation of books to students must be contiguous (in the given order of books).

The goal is to minimize the maximum number of pages assigned to any one student. If it is not possible to allocate books to all students (i.e. `m > n`), return `-1`.

## Example

**Input:** nums = [12, 34, 67, 90], m = 2
**Output:** 113
**Explanation:** Allocation [12,34,67] to student 1 (113 pages) and [90] to student 2 (90 pages) gives a maximum of 113, which is the minimum possible maximum.

**Input:** nums = [25, 46, 28, 49, 24], m = 4
**Output:** 71

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
- `1 <= m <= 10^5`
