package Array;

import java.util.ArrayList;
import java.util.List;

public class Solution_09_unionOfTwoSortedArray {
    // Time complexity: O(n)
    // Space complexity: O(n)
    public int[] unionArray(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            int value;
            if (nums1[i] <= nums2[j]) {
                value = nums1[i++];
            }
            else {
                value = nums2[j++];
            }
            if (list.isEmpty() || list.get(list.size() - 1) != value) {
                list.add(value);
            }
        }
        while (i < n1) {
            if (list.isEmpty() || list.get(list.size() - 1) != nums1[i]) {
                list.add(nums1[i]);
            }
            i++;
        }
        while (j < n2) {
            if (list.isEmpty() || list.get(list.size() - 1) != nums2[j]) {
                list.add(nums2[j]);
            }
            j++;
        }
        int n = list.size();
        int[] result = new int[n];
        for (int index=0; index<n; index++) {
            result[index] = list.get(index);
        }
        return result;
    }
}
