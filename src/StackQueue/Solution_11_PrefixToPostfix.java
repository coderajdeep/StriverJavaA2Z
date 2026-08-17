package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_11_PrefixToPostfix {
    public String prefixToPostfix(String s) {
        int length = s.length();
        Deque<String> stack = new ArrayDeque<>();
        for (int i=length-1; i>=0; i--) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            }
            else {
                String s1 = stack.pop();
                String s2 = stack.pop();
                stack.push(s1 + s2 + ch);
            }
        }
        return stack.pop();
    }
}
