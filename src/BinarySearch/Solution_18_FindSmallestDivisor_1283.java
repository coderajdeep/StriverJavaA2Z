package BinarySearch;

public class Solution_18_FindSmallestDivisor_1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = getMax(nums), mid, ans = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            long totalDivisorSum = getTotalDivisorSum(nums, mid);
            if (totalDivisorSum <= threshold) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    private int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    private long getTotalDivisorSum(int[] nums, int mid) {
        long sum = 0L;
        for (int num : nums) {
            sum += (long) Math.ceil((double) num / mid);
        }
        return sum;
    }
}
