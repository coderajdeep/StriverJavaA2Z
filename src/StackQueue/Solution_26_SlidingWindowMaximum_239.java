package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_26_SlidingWindowMaximum_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=0; i<k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int n = nums.length;
        int[] result = new int[n-k+1];
        int index = 0;
        result[index++] = nums[deque.peekFirst()];
        for (int i=k; i<n; i++) {
            if (!deque.isEmpty() && (i-k) >= deque.peekFirst()) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            result[index++] = nums[deque.peekFirst()];
        }
        return result;
    }
}
