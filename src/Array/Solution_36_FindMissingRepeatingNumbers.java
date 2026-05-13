package Array;

public class Solution_36_FindMissingRepeatingNumbers {
    // Time complexity O(n)
    // Space complexity O(n)
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int n = nums.length;
        int[] hash = new int[n+1];
        for (int num : nums) {
            hash[num]++;
        }
        int[] result = new int[2];
        for (int i=1; i<=n; i++) {
            if (hash[i] == 2) {
                result[0] = i;
            }
            else if (hash[i] == 0) {
                result[1] = i;
            }
        }
        return result;
    }

    // Time complexity O(n)
    // Space complexity O(1)
    // Mathematical approach
    // (1 + 2 + 3 + x + x + 5 + .... + n) - (1 + 2 + 3 + x + 5 + .... + n) -> (x - y) -> v1
    // x -> repeating number
    // y -> missing number
    // (1^2 + 2^2 + 3^2 + x^2 + x^2 + 5^2 + .... + n^2) - (1^2 + 2^2 + 3^2 + x^2 + 5^2 + .... + n^2) -> (x^2 - y^2) -> v2
    // (x + y) -> v2 / v1 -> v3
    // x -> ((v1 + v3) / 2) -> v4
    // y -> (v3 - v4)
    public int[] findMissingRepeatingNumbersMathematicalSolution(int[] nums) {
        int n = nums.length;
        long diff = 0, squareDiff = 0;
        for (int i=0; i<n; i++) {
            diff += ((long)(nums[i]) - (i+1));
            squareDiff += ((long) (nums[i] * nums[i]) - (long)((i+1)*(i+1)));
        }
        long x_plus_y = squareDiff / diff;
        long repeatingNumber = (x_plus_y + diff) / 2;
        long missingNumber = x_plus_y - repeatingNumber;
        return new int[] {(int) repeatingNumber, (int) missingNumber};
    }


    // Using bit manipulation method
    // Time complexity O(n)
    // Space complexity O(1)
    // https://youtu.be/2D0D8HE6uak
    public int[] findMissingRepeatingNumbersBitManipulation(int[] nums) {
        int xor = getXOR(nums);
        int firstSetBitPosition = getFirstSetBitPosition(xor);
        int zero = 0, one = 0;
        for (int i=0; i<nums.length; i++) {
            if ((nums[i] & (1 << firstSetBitPosition)) == 0) {
                zero = (zero ^ nums[i]);
            }
            else {
                one = (one ^ nums[i]);
            }
            if (((i+1) & (1 << firstSetBitPosition)) == 0) {
                zero = (zero ^ (i+1));
            }
            else {
                one = (one ^ (i+1));
            }
        }
        return getResult(zero, one, nums);
    }
    private int getXOR(int[] nums) {
        int xor = 0;
        for (int i=0; i<nums.length; i++) {
            xor = (xor ^ nums[i] ^ (i+1));
        }
        return xor;
    }
    private int getFirstSetBitPosition(int num) {
        int bitPosition = 0;
        while (true) {
            if ((num & (1 << bitPosition)) != 0) {
                break;
            }
            bitPosition++;
        }
        return bitPosition;
    }
    private int[] getResult(int x, int y, int[] nums) {
        boolean isPresent = false;
        for (int num : nums) {
            if (num == x) {
                isPresent = true;
                break;
            }
        }
        if (isPresent) {
            return new int[] {x, y};
        }
        else {
            return new int[] {y, x};
        }
    }
}
