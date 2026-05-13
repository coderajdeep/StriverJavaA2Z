package BinarySearch;

public class Solution_17_MinimumDaysToMakeM_Bouquets_1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < ((long) k * m)) {
            return -1;
        }
        int[] maxMinElement = getMaxMinElement(bloomDay);
        int low = maxMinElement[1], high = maxMinElement[0], mid, ans = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            int totalBouquets = getTotalBouquets(bloomDay, k, mid);
            if (m <= totalBouquets) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    private int getTotalBouquets(int[] nums, int k, int mid) {
        int total = 0, count = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] <= mid) {
                count++;
                if (count == k) {
                    total++;
                    count = 0;
                }
            }
            else {
                count = 0;
            }
        }
        return total;
    }
    private int[] getMaxMinElement(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        return new int[] {max, min};
    }
}
