package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution_15_NextGreaterElement_I_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> ngeMap = nextLargerElement(nums2);
        int length = nums1.length;
        int[] result = new int[length];
        for (int i=0; i<length; i++) {
            result[i] = ngeMap.get(nums1[i]);
        }
        return result;
    }
    private Map<Integer, Integer> nextLargerElement(int[] arr) {
        int length = arr.length;
        Map<Integer, Integer> result = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=length-1; i>=0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            int ngeValue = stack.isEmpty() ? -1 : stack.peek();
            result.put(arr[i], ngeValue);
            stack.push(arr[i]);
        }
        return result;
    }
}
