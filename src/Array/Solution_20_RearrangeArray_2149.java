package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Solution_20_RearrangeArray_2149 {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> positive = new ArrayList<> ();
        List<Integer> negative = new ArrayList<> ();
        for (int num : nums) {
            if (num >= 0) {
                positive.add(num);
            }
            else {
                negative.add(num);
            }
        }
        int size = nums.length;
        int[] result = new int[size];
        boolean isPositive = true;
        for (int i=0; i<size; ++i) {
            result[i] = isPositive ? positive.get(i/2) : negative.get(i/2);
            isPositive = !isPositive;
        }
        return result;
    }
}
