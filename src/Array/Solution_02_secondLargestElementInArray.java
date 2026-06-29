package Array;

public class Solution_02_secondLargestElementInArray {
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int secondLargestElement(int[] nums) {
        int firstLargest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        for (int num : nums) {
            if (firstLargest < num) {
                secondLargest = firstLargest;
                firstLargest = num;
            }
            else if (secondLargest < num && num < firstLargest) {
                secondLargest = num;
            }
        }
        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }
}
