package BinarySearch;

public class Solution_9_searchInRotatedSortedArrayI_33 {
    // nums = [1,3]
    // target = 3
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] <= nums[high]) {
                // not nums[mid] <= target
                // because we have checked earlier nums[mid] == target
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
            else {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
