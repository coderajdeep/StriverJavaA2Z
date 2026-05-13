package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_20_SumOfSubArrayMinimum_907 {
    private static final int MOD = (int)1e9 + 7;
    public int sumSubArrayMin(int[] arr) {
        int size = arr.length;
        int[] nse = getNseIndexes(arr);
        int[] pse = getPseIndexes(arr);
        long result = 0;
        for (int i=0; i<size; i++) {
            long leftSize = i-pse[i];
            long rightSize = nse[i]-i;
            // https://chatgpt.com/share/69db4829-4400-8322-a68c-a3c205947f6c
            // Java automatically type case to long for arr[i]
            result = (result + leftSize * rightSize * arr[i]) % MOD;
            // If an array has x+1+y element and x index (o based indexing) is val
            // then there will be (x+1) * (y+1) sub array which will contain val
            // sub array starting index [0 x] and ending index [x x+y]
        }
        return (int) result;
    }
    private int[] getNseIndexes(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<> ();
        int size = arr.length;
        int[] result = new int[size];
        for (int i=size-1; i>=0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? size : stack.peek();
            stack.push(i);
        }
        return result;
    }
    private int[] getPseIndexes(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<> ();
        int size = arr.length;
        int[] result = new int[size];
        for (int i=0; i<size; i++) {
            // We are considering only previous smaller or equal element index
            // Either in previous smaller or next smaller element calculation, we need to do this
            // Otherwise we are going to be double calculate few elements
            // Just dry run below test case
            // [7,5,8,5]
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return result;
    }
}
