package __02__BinarySearch;

public class Solution_20_KthMissingPositiveNumber_1539 {
    // Time complexity O(n)
    // Space complexity O(1)
    public static int findKthPositiveLinearSolution(int[] arr, int k) {
        for (int value : arr) {
            if (k < value) {
                return k;
            }
            else {
                k++;
            }
        }
        return k;
    }

    public static int findKthPositive(int[] arr, int k) {
        if (k < arr[0]) {
            return k;
        }
        int n = arr.length;
        int[] nums = new int[n];
        for (int i=0; i<n; i++) {
            nums[i] = (arr[i] - (i+1));
        }
        int lowerBoundIndex = lowerBound(nums, k);
        if (lowerBoundIndex == n) {
            return ((k - nums[n-1]) + arr[n-1]);
        }
        if (nums[lowerBoundIndex] == k) {
            return (arr[lowerBoundIndex] - 1);
        }
        return (arr[lowerBoundIndex] - (nums[lowerBoundIndex] - k + 1));
    }
    private static int lowerBound(int[] nums, int target) {
        int low = 0, high = nums.length, mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
