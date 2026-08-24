package __07__StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_24_LargestRectangleInHistogram_84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, result = 0;
        int[] nse = getNSE(heights);
        int[] pse = getPSE(heights);
        for (int i=0; i<n; i++) {
            int left = pse[i] + 1;
            int right = nse[i] - 1;
            result = Math.max(result, (right - left + 1) * heights[i]);
        }
        return result;
    }
    private int[] getNSE(int[] arr) {
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] nse = new int[n];
        for (int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nse;
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
}
