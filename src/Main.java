import Array.Solution_33_LargestSubArrayWithGivenXOR;
import BinarySearch.Solution_20_KthMissingPositiveNumber_1539;
import Heap.Solution_07_SortKSortedArray;
import Heap.Solution_15_MaximumSumCombination;
import Recursion.Solution_09_GenerateSubsequenceWithTargetSum;
import Recursion.Solution_12_CombinationSum_39;

import java.util.Arrays;
import java.util.List;

// Option + Cmd + v
public class Main {
    public static void main(String[] args) {
        try {
            int kthPositive = Solution_20_KthMissingPositiveNumber_1539.findKthPositive(new int[]{1, 2, 3, 4}, 2);
            System.out.println(kthPositive);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
