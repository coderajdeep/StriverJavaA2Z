package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Solution_17_Letter_Combinations_of_Phone_Number_17 {
    public List<String> letterCombinations(String digits) {
        String[] keypad = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(0, digits, keypad, sb, result);
        return result;
    }
    private static void solve(int index, String digits, String[] keypad, StringBuilder sb, List<String> result) {
        if (index == digits.length()) {
            if (sb.length() == digits.length()) {
                result.add(sb.toString());
            }
            return;
        }
        int digitsCurrentNum = digits.charAt(index) -'0';
        int stringLength = keypad[digitsCurrentNum - 2].length();
        for (int i=0; i<stringLength; i++) {
            sb.append(keypad[digitsCurrentNum - 2].charAt(i));
            solve(index + 1, digits, keypad, sb, result);
            sb.setLength(sb.length() - 1);
        }
    }
}
