package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_13_PostfixToInfix {
    public String postToInfix(String postExp) {
        Deque<String> stack = new ArrayDeque<>();
        for (char ch : postExp.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            }
            else {
                String s2 = stack.pop();
                String s1 = stack.pop();
                stack.push("(" + s1 + ch + s2 + ")");
            }
        }
        return stack.pop();
    }
}
