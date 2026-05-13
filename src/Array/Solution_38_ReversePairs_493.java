package Array;

public class Solution_38_ReversePairs_493 {
    // Time complexity O(nlog(n))
    // Space complexity O(n)
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        return mergeSort(0, n-1, nums, temp);
    }
    private void merge(int start, int mid, int end, int[] nums, int[] temp) {
        for (int i=start; i<=end; i++) {
            temp[i] = nums[i];
        }
        int i = start, j = mid + 1, k = start;
        while (i <= mid && j <= end && k <= end) {
            if (temp[i] <= temp[j]) {
                nums[k++] = temp[i++];
            }
            else {
                nums[k++] = temp[j++];
            }
        }
        while (i <= mid && k <= end) {
            nums[k++] = temp[i++];
        }
        while (j <= end && k <= end) {
            nums[k++] = temp[j++];
        }
    }
    private int getReversePairCount(int start, int mid, int end, int[] nums) {
        int i = start, j = mid + 1, count = 0;
        while (i <= mid && j <= end) {
            if ((long) nums[i] > (2L * nums[j])) {
                count += (mid - i + 1);
                j++;
            }
            else {
                i++;
            }
        }
        return count;
    }
    private int mergeSort(int start, int end, int[] nums, int[] temp) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int count1 = mergeSort(start, mid, nums, temp);
        int count2 = mergeSort(mid + 1, end, nums, temp);
        int count3 = getReversePairCount(start, mid, end, nums);
        merge(start, mid, end, nums, temp);
        return count1 + count2 + count3;
    }
}
