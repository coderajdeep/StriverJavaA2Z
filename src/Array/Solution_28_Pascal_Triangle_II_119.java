package Array;

import java.util.ArrayList;
import java.util.List;

public class Solution_27_Pascal_Triangle_II_119 {
    // https://youtu.be/bR7mQgwQ_o8
    // https://chatgpt.com/share/69e7649a-d9e4-8324-a70c-74987d618a43
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return List.of(1);
        }
        if (rowIndex == 1) {
            return List.of(1, 1);
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        long denominator = 1, numerator = rowIndex, prev = 1;
        for (int i=1; i<rowIndex; i++) {
            long value = (prev * numerator) / denominator;
            list.add((int)value);
            numerator--;
            denominator++;
            prev = value;
        }
        list.add(1);
        return list;
    }
}
