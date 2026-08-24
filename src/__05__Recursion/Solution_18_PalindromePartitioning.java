package __05__Recursion;

import java.util.ArrayList;
import java.util.List;

public class Solution_18_PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        List<List<String>> result = new ArrayList<> ();
        solve(0, s, list, result);
        return result;
    }
    private static void solve(int index, String s, List<String> list, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<> (list));
            return;
        }
        for (int i=index; i<s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                String substring = s.substring(index, i + 1);
                list.add(substring);
                solve(i + 1, s, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
