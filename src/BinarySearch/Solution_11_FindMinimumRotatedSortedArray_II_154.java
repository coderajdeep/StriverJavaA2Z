package BinarySearch;

public class Solution_13_FindMinimumRotatedSortedArray_II_154 {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1, mid, minElement = Integer.MAX_VALUE;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                minElement = Math.min(minElement, nums[low]);
                low++;
                high--;
                continue;
            }
            if (nums[mid] <= nums[high]) {
                minElement = Math.min(minElement, nums[mid]);
                high = mid - 1;
            }
            else {
                minElement = Math.min(minElement, nums[low]);
                low = mid + 1;
            }
        }
        return minElement;
    }
}
