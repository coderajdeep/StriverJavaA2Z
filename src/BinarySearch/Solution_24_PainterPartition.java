package BinarySearch;

public class Solution_24_PainterPartition {
    public int paint(int A, int B, int[] C) {
        long low = Integer.MIN_VALUE, high = 0L, mid, ans = 0L;
        for (int value : C) {
            low = Math.max(low, ((long) value)*B);
            high += (((long) value) * B);
        }
        while (low <= high) {
            mid = low + (high - low) / 2;
            long count = paintersCount(C, mid, B);
            if (count <= A) {
                ans = mid % 10000003;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return (int) ans;
    }
    private long paintersCount(int[] nums, long maxTime, int B) {
        long count = 0, totalTime = 0;
        for (int num : nums) {
            totalTime += ((long) num * B);
            if (totalTime > maxTime) {
                count++;
                totalTime = ((long) num * B);
            }
        }
        // totalTime > 0 && totalTime <= maxTime
        return count + 1;
    }
}
