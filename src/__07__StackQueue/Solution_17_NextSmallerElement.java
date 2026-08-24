package __07__StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_17_NextSmallerElement {
    public int[] nextSmallerElements(int[] arr) {
        int size = arr.length;
        int[] result = new int[size];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=size-1; i>=0; i--) {
            while (!stack.isEmpty() && arr[i] <= stack.peek()) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }
}
