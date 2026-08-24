package __02__BinarySearch;

public class Solution_19_MinCapacityToShipPackagesWithinD_Days_1011 {
    public int shipWithinDays(int[] weights, int days) {
        int[] sumAndMaxElement = getSumAndMaxElement(weights);
        int low = sumAndMaxElement[1], high = sumAndMaxElement[0], mid, ans = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            int totalDays = totalDaysRequired(weights, mid);
            if (totalDays <= days) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    private int[] getSumAndMaxElement(int[] weights) {
        int maxElement = Integer.MIN_VALUE, sum = 0;
        for (int weight : weights) {
            if (weight > maxElement) {
                maxElement = weight;
            }
            sum += weight;
        }
        return new int[] {sum, maxElement};
    }
    private int totalDaysRequired(int[] weights, int weightCapacity) {
        int days = 0, totalWeight = 0;
        for (int weight : weights) {
            totalWeight += weight;
            if (totalWeight > weightCapacity) {
                days++;
                totalWeight = weight;
            }
        }
        if (totalWeight > 0) {
            days++;
        }
        return days;
    }
}
