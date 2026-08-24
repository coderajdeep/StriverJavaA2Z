package __02__BinarySearch;

public class Solution_10_FindMinimumInRotatedSortedArray_153 {
    public int findMin(int[] nums) {
        int minValue = Integer.MAX_VALUE, low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] <= nums[high]) {
                minValue = Math.min(minValue, nums[mid]);
                high = mid - 1;
            }
            else {
                minValue = Math.min(minValue, nums[low]);
                low = mid + 1;
            }
        }
        return minValue;
    }
}
