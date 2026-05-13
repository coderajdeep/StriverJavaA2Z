package BinarySearch;

public class Solution_06_FirstAndLastOccurrence {
    public int[] searchRange(int[] nums, int target) {
        int lowerIndex = lowerBound(nums, target);
        if (lowerIndex == nums.length) {
            return new int[] {-1, -1};
        }
        if (nums[lowerIndex] == target) {
            int upperIndex = upperBound(nums, target);
            return new int[] {lowerIndex, upperIndex-1};
        }
        return new int[] {-1, -1};
    }
    private int lowerBound(int[] nums, int target) {
        int low = 0, high = nums.length, mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    private int upperBound(int[] nums, int target) {
        int low = 0, high = nums.length, mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] <= target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
