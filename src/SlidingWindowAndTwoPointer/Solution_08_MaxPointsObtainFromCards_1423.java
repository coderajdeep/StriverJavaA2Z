package SlidingWindowAndTwoPointer;

public class Solution_08_MaxPointsObtainFromCards_1423 {
    // Time complexity O(n)
    // Space complexity O(1)
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0, result, n = cardPoints.length;
        for (int i=0; i<k; ++i) {
            sum += cardPoints[i];
        }
        result = sum;
        for (int i=0; i<k; ++i) {
            sum += (cardPoints[n-1-i] - cardPoints[k-1-i]);
            result = Math.max(result, sum);
        }
        return result;
    }
}
