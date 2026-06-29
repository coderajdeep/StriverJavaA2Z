package Array;

public class Solution_22_NextPermutation_31 {

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
            reverse(0, size-1, nums);
            return;
        }
        for (int i = size-1; i > pivot; i--) {
            // We need to find which element is greater than the pivot
            // Then we need to swap with pivot and reverse from (pivot + 1) index to last index
            if (nums[i] > nums[pivot]) {
                swap(pivot, i, nums);
                reverse(pivot + 1, size-1, nums);
                break;
            }
        }
    }

    // Same solution
    public void nextPermutationSameSolution(int[] nums) {
        int n = nums.length, pivot = -1;
        if (n == 1) {
            return;
        }
        for (int i = n-1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                pivot = i-1;
                break;
            }
        }
        if (pivot == -1) {
            reverse(0, n-1, nums);
            return;
        }
        for (int i = n-1; i > pivot; i--) {
            if (nums[pivot] < nums[i]) {
                swap(pivot, i, nums);
                reverse(pivot+1, n-1, nums);
                return;
            }
        }
    }

    private void swap(int index1, int index2, int[] nums) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private void reverse(int start, int end, int[] nums) {
        while (start < end) {
            swap(start, end, nums);
            start++;
            end--;
        }
    }
}
