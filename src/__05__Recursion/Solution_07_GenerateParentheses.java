package __05__Recursion;

import java.util.ArrayList;
import java.util.List;

public class Solution_07_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        generateParenthesisUtils(0, 0, 0, n, sb, result);
        return result;
    }
    private static void generateParenthesisUtils(int index, int openCount, int closeCount, int n, StringBuilder sb, List<String> result) {
        if (openCount < closeCount || openCount > n) {
            return;
        }
        if (index == 2 * n) {
            if (openCount == closeCount) {
                result.add(sb.toString());
            }
            return;
        }
        sb.append('(');
        generateParenthesisUtils(index + 1, openCount + 1, closeCount, n, sb, result);
        sb.setLength(sb.length() - 1);
        sb.append(')');
        generateParenthesisUtils(index + 1, openCount, closeCount + 1, n, sb, result);
        sb.setLength(sb.length() - 1);
    }
}
