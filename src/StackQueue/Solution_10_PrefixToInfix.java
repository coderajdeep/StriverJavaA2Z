package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_10_PrefixToInfix {
    public String prefixToInfix(String s) {
        int size = s.length();
        Deque<String> stack = new ArrayDeque<>();
        for (int i=size-1; i>=0; i--) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            }
            else {
                // Just dry run a+b -> +ab
                // Don't need to remember
                String s1 = stack.pop(); // Operand 1
                String s2 = stack.pop(); // Operand 2
                stack.push("(" + s1 + ch + s2 + ")");
            }
        }
        return stack.isEmpty() ? "" : stack.pop();
    }
}
