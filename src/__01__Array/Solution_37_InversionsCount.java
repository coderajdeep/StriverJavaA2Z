package __01__Array;

public class Solution_37_InversionsCount {
    // Time complexity O(nlog(n))
    // Space complexity O(n)
    public long numberOfInversions(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        return mergeSort(0, n-1, nums, temp);
    }
    private long merge(int start, int mid, int end, int[] nums, int[] temp) {
        for (int i=start; i<=end; i++) {
            temp[i] = nums[i];
        }
        int i = start, j = mid + 1, k = start;
        long count = 0;
        while (i <= mid && j <= end && k <= end) {
            if (temp[i] <= temp[j]) {
                nums[k++] = temp[i++];
            }
            else {
                count += (mid - i + 1);
                nums[k++] = temp[j++];
            }
        }
        while (i <= mid && k <= end) {
            nums[k++] = temp[i++];
        }
        while (j <= end && k <= end) {
            nums[k++] = temp[j++];
        }
        return count;
    }
    private long mergeSort(int start, int end, int[] nums, int[] temp) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        long count1 = mergeSort(start, mid, nums, temp);
        long count2 = mergeSort(mid + 1, end, nums, temp);
        long count3 = merge(start, mid, end, nums, temp);
        return count1 + count2 + count3;
    }
}
