package Array;

public class Solution_16_sort012_75 {
    // Time complexity O(n)
    // Space complexity O(1)
    public void sortColors(int[] nums) {
        int size = nums.length;
        int low = 0, mid = 0, high = size-1;
        // [0 - (low-1)] -> 0
        // [low - (mid-1)] -> 1
        // [mid - high] -> 0/1/2
        // [(high+1) - (n-1)] -> 2
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if (nums[mid] == 1) {
                mid++;
            }
            else {
                swap(nums, mid, high);
                high--;
            }
        }
    }
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    // Time complexity O(n)
    // Space complexity O(1)
    public void sortColorsUsingCountSort(int[] nums) {
        int size = nums.length;
        int zero = 0, one = 0, two = 0;
        for (int num : nums) {
            if (num == 0) {
                zero++;
            }
            else if (num == 1) {
                one++;
            }
            else if (num == 2) {
                two++;
            }
        }
        fill(zero, 0, 0, nums);
        fill(one, zero, 1, nums);
        fill(two, zero+one, 2, nums);
    }
    private void fill(int total, int start, int value, int[] nums) {
        for (int i=0; i<total; i++) {
            nums[start+i] = value;
        }
    }
}
