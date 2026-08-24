package __01__Array;

public class Solution_35_MergeTwoSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n;
        int[] nums = new int[length];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n && k < length) {
            if (nums1[i] <= nums2[j]) {
                nums[k++] = nums1[i++];
            }
            else {
                nums[k++] = nums2[j++];
            }
        }
        while (i < m && k < length) {
            nums[k++] = nums1[i++];
        }
        while (j < n && k < length) {
            nums[k++] = nums2[j++];
        }
        for (int in = 0; in < length; in++) {
            nums1[in] = nums[in];
        }
    }
}
