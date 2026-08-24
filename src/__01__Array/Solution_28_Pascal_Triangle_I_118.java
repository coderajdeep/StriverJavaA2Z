package __01__Array;

import java.util.ArrayList;
import java.util.List;

public class Solution_28_Pascal_Triangle_I_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<> (List.of(1));
        result.add(firstRow);
        if (numRows == 1) {
            return result;
        }
        List<Integer> secondRow = new ArrayList<> (List.of(1, 1));
        result.add(secondRow);
        if (numRows == 2) {
            return result;
        }
        for (int i=2; i<numRows; i++) {
            List<Integer> list = new ArrayList<> ();
            list.add(1);
            for (int j=1; j<i; j++) {
                int value = result.get(i-1).get(j-1) + result.get(i-1).get(j);
                list.add(value);
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }
}
