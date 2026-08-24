package __07__StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_23_RemoveKDigits_402 {
    public String removeKDigits(String num, int k) {
        if (num.isEmpty()) {
            return "";
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > ch) {
                stack.pop();
                k--;
            }
            if (ch != '0' || !stack.isEmpty()) {
                stack.push(ch);
            }
        }
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }
        int n = stack.size();
        if (n == 0) {
            return "0";
        }
        char[] result = new char[n];
        for (int i=n-1; i>=0; i--) {
            result[i] = stack.pop();
        }
        return String.valueOf(result);
    }
}
