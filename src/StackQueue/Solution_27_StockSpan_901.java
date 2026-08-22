package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_27_StockSpan_901 {

    // Leetcode
    public static class StockSpanner {
        private Deque<int[]> stack;
        private int index;

        public StockSpanner() {
            stack = new ArrayDeque<>();
            index = 0;
        }

        public int next(int price) {
            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                stack.pop();
            }
            int result;
            if (stack.isEmpty()) {
                result = (index+1);
            }
            else {
                result = index - stack.peek()[1];
            }
            stack.push(new int[] {price, index++});
            return result;
        }
    }

    // Take U Forward
    public static class Solution_TakeUForward {
        public int[] stockSpan(int[] arr, int n) {
            int[] result = new int[n];
            Deque<Integer> stack = new ArrayDeque<> ();
            for (int i=0; i<n; i++) {
                while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    result[i] = i+1;
                }
                else {
                    result[i] = i - stack.peek();
                }
                stack.push(i);
            }
            return result;
        }
    }
}
