package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_22_SumOfSubarrayRanges_2104 {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long result = 0;
        int[] nse = getNSE(nums);
        int[] nge = getNGE(nums);
        int[] pse = getPSE(nums);
        int[] pge = getPGE(nums);
        // sum of all ranges = Σ(max of each subarray) − Σ(min of each subarray)
        for (int i=0; i<n; i++) {
            long psi = i - pse[i];
            long pgi = i - pge[i];
            long nsi = nse[i] - i;
            long ngi = nge[i] - i;
            result += (nums[i] * ((pgi * ngi) - (psi * nsi)));
        }
        return result;
    }

    private int[] getNSE(int[] arr) {
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<> ();
        int[] nse = new int[n];
        for (int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nse;
    }
    private int[] getNGE(int[] arr) {
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<> ();
        int[] nge = new int[n];
        for (int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                stack.pop();
            }
            nge[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nge;
    }
    private int[] getPSE(int[] arr) {
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] pse = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }

    private int[] getPGE(int[] arr) {
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<> ();
        int[] pge = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }
            pge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pge;
    }
}
