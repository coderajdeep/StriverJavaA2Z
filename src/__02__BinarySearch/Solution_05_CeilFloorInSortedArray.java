package __02__BinarySearch;

public class Solution_05_CeilFloorInSortedArray {
    public int[] getFloorAndCeil(int[] nums, int x) {
        int lowerIndex = lowerBound(nums, x), n = nums.length;
        if (lowerIndex == n) {
            return new int[] {nums[n-1], -1};
        }
        if (nums[lowerIndex] == x) {
            return new int[] {x, x};
        }
        if (lowerIndex == 0) {
            return new int[] {-1, nums[0]};
        }
        return new int[] {nums[lowerIndex-1], nums[lowerIndex]};
    }
    private int lowerBound(int[] nums, int x) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < x) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
