package __02__BinarySearch;

public class Solution_07_CountOccurrencesInSortedArray {
    public int countOccurrences(int[] arr, int target) {
        int lowerIndex = lowerBound(arr, target);
        if (lowerIndex == arr.length || arr[lowerIndex] != target) {
            return 0;
        }
        return upperBound(arr, target) - lowerIndex;
    }
    private int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    private int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
