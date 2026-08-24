package __02__BinarySearch;

public class Solution_16_KokoEatingBananas_875 {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = getMaxValue(piles), mid, ans = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            long time = timeRequired(piles, mid);
            if (time <= h) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    private int getMaxValue(int[] piles) {
        int maxValue = Integer.MIN_VALUE;
        for (int pile : piles) {
            if (maxValue < pile) {
                maxValue = pile;
            }
        }
        return maxValue;
    }
    private long timeRequired(int[] piles, int mid) {
        long time = 0;
        for (int pile : piles) {
            time += (pile / mid);
            time += (pile % mid == 0 ? 0 : 1);
        }
        return time;
    }
}
