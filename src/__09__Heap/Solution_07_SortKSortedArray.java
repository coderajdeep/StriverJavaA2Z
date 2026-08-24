package __09__Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_07_SortKSortedArray {
    // https://www.geeksforgeeks.org/problems/k-sorted-array1610/1
    private record Pair(int value, int index) {}

    // Time complexity O(n*log(k))
    // Space complexity O(log(k))
    public int[] getSortedArray(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int size = nums.length;
        for (int i=0; i<=k; i++) {
            pq.offer(nums[i]);
        }
        int[] result = new int[size];
        int index = 0;
        for (int i=k+1; i<size && !pq.isEmpty(); i++) {
            result[index++] = pq.poll();
            pq.offer(nums[i]);
        }
        while (!pq.isEmpty()) {
            result[index++] = pq.poll();
        }
        return result;
    }

    // Time complexity O(n*log(n))
    // Space complexity O(n)
    public boolean isKSortedArray(int[] nums, int k) {
        int size = nums.length;
        Pair[] array = new Pair[size];
        for (int i=0; i<size; i++) {
            array[i] = new Pair(nums[i], i);
        }
        Arrays.sort(array, (a, b) -> a.value() - b.value());
        // Can be replaced with below
        // Arrays.sort(array, Comparator.comparingInt(Pair::value));
        for (int i=0; i<size; i++) {
            if (Math.abs(array[i].index - i) > k) {
                return false;
            }
        }
        return true;
    }
}
