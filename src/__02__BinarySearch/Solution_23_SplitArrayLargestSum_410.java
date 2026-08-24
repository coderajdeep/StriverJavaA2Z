package __02__BinarySearch;

public class Solution_23_SplitArrayLargestSum_410 {
    public int splitArray(int[] nums, int k) {
        if (k > nums.length) {
            return -1;
        }
        int low = Integer.MIN_VALUE, high = 0, mid, ans = -1;
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }
        while (low <= high) {
            mid = low + (high - low) / 2;
            int count = getTotalPartition(nums, mid);
            if (count <= k) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    private int getTotalPartition(int[] nums, int maxSum) {
        int sum = 0, count = 0;
        for (int num : nums) {
            sum += num;
            if (sum > maxSum) {
                count++;
                sum = num;
            }
        }
        // Here sum > 0 && sum <= maxSum
        // That's why count needs to incremented by 1
        return count + 1;
    }
}
