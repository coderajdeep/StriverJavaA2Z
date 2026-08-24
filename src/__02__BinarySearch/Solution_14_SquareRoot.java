package __02__BinarySearch;

public class Solution_14_SquareRoot {
    // Time complexity O(log(n))
    // Space complexity O(1)
    public int floorSqrt(int n) {
        int low = 1, high = n, mid, ans = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            long square = (long) mid * mid;
            if (square <= n) {
                ans = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
