package Arrays;

public class Solution_21_NextPermutation_31 {

    // Time complexity O(n)
    // Space complexity O(1)
    public void nextPermutation(int[] nums) {
        int size = nums.length, pivot = -1;
        // We are traversing back side to front
        // It's increasing from back to front
        // But when it's decrease w.r.t the previous element, we got our pivot
        // First decreased value's index is the pivot
        for (int i = size-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                pivot = i;
                break;
            }
        }
        if (pivot == -1) {
            reverse(nums, 0, size-1);
            return;
        }
        for (int i = size-1; i > pivot; i--) {
            // We need to find which element is greater than the pivot
            // Then we need to swap with pivot and reverse from (pivot + 1) index to last index
            if (nums[i] > nums[pivot]) {
                swap(nums, pivot, i);
                reverse(nums, pivot + 1, size-1);
                break;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
