package BinarySearch;

public class Solution_12_SingleElementInSortedArray_540 {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n==1) {
            return nums[0];
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[n-1] != nums[n-2]) {
            return nums[n-1];
        }
        // If control comes to this point
        // Above check will make sure that the single element is not the first or the last element
        int low = 2, high = n-3;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid-1] < nums[mid] && nums[mid] < nums[mid+1]) {
                return nums[mid];
            }
            if (mid % 2 == 0) {
                // If mid is even and this condition is true
                // then single element will be on the right side
                if (nums[mid] == nums[mid+1]) {
                    low = mid + 2;
                }
                // else left side
                else {
                    high = mid - 2;
                }
            }
            else {
                // If mid is odd and this condition is true
                // then single element will be on the left side
                if (nums[mid] == nums[mid+1]) {
                    high = mid - 1;
                }
                // else right side
                else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
