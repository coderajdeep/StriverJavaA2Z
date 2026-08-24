package __01__Array;

public class Solution_12_singleNumber_136 {
    // Time complexity: O(n)
    // Space complexity: O(1)
    public int singleNumber(int[] nums) {
        int singleNumber = 0;
        for (int num : nums) {
            singleNumber = (singleNumber ^ num);
        }
        return singleNumber;
    }
}
