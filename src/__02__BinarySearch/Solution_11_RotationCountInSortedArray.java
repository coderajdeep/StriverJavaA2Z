package __02__BinarySearch;

import java.util.ArrayList;

public class Solution_11_RotationCountInSortedArray {
    public int findKRotation(ArrayList<Integer> arr) {
        int minValueIndex = -1, low = 0, high = arr.size() - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr.get(mid) <= arr.get(high)) {
                if (minValueIndex == -1 || (arr.get(mid) < arr.get(minValueIndex))) {
                    minValueIndex = mid;
                }
                high = mid - 1;
            }
            else {
                if (minValueIndex == -1 || (arr.get(low) < arr.get(minValueIndex))) {
                    minValueIndex = low;
                }
                low = mid + 1;
            }
        }
        return minValueIndex;
    }
}
