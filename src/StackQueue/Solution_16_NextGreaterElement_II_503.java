package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_16_NextGreaterElement_II_503 {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=length-2; i>=0; i--) {
            stack.push(nums[i]);
        }
        int[] result = new int[length];
        for (int i=length-1; i>=0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return result;
    }
}
