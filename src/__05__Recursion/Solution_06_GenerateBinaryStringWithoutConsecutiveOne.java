package __05__Recursion;

import java.util.ArrayList;
import java.util.List;

public class Solution_06_GenerateBinaryStringWithoutConsecutiveOne {
    public List<String> generateBinaryStrings(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<> ();
        generatorUtils(0, n, '0', sb, result);
        return result;
    }
    private void generatorUtils(int index, int n, char prev, StringBuilder sb, List<String> result) {
        if (index == n) {
            result.add(sb.toString());
            return;
        }
        sb.append('0');
        generatorUtils(index + 1, n, '0', sb, result);
        sb.setLength(sb.length() - 1);
        if (prev == '0') {
            sb.append('1');
            generatorUtils(index + 1, n, '1', sb, result);
            sb.setLength(sb.length() - 1);
        }
    }
}
