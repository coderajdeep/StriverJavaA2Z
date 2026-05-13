package BinarySearch;

public class Solution_15_NthRoot {
    // Time complexity O(log(n))
    // Space complexity O(1)
    // If the element has no integer Nth root, then need to return -1
    public int NthRoot(int N, int M) {
        int low = 1, high = M, mid, ans = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            long powerValue = getPower(N, M, mid);
            if (powerValue == M) {
                return mid;
            }
            if (powerValue == -1) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
    long getPower(int N, int M, int mid) {
        long ans = 1;
        for (int i=0; i<N; i++) {
            ans = (ans * mid);
            if (ans > M) {
                return -1;
            }
        }
        return ans;
    }

    // Nth root range
    // So the root will be between the two number
    // high^N < M < low^N
    // Returns floor & ceil root integer range
    public int[] NthRootRange(int N, int M) {
        int low = 1, high = M, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            long powerValue = getPower(N, M, mid);
            if (powerValue == M) {
                return new int[] {mid, mid};
            }
            if (powerValue == -1) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return new int[] {high, low};
    }
}
