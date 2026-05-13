package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_07_ValidParentheses_20 {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else if (stack.isEmpty()) {
                return false;
            }
            else if (ch == ')' && stack.peek() != '(') {
                return false;
            }
            else if (ch == '}' && stack.peek() != '{') {
                return false;
            }
            else if (ch == ']' && stack.peek() != '[') {
                return false;
            }
            else {
                stack.poll();
            }
        }
        return stack.isEmpty();
    }
}
