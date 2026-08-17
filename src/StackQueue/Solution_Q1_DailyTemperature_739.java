package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_Q1_DailyTemperature_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = length-1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return result;
    }
}
