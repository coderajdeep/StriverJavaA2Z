package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

// Edge case :
// a+b*c-d/e+f*g-h/i
// a^b^c
public class Solution_14_InfixToPrefixConversion {
    public String infixToPrefix(String s) {
        StringBuilder sb = new StringBuilder(s);
        reverse(sb, 0, sb.length()-1);
        StringBuilder result = infixToPostfix(sb);
        reverse(result, 0, sb.length()-1);
        return result.toString();
    }
    private StringBuilder infixToPostfix(StringBuilder sb) {
        StringBuilder result = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        int size = sb.length();
        for (int i=0; i<size; ++i) {
            char ch = sb.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result.append(ch);
            }
            else if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            }
            else {
                while (!stack.isEmpty() && (getPrecedence(ch) <= getPrecedence(stack.peek()))) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result;
    }
    private void reverse(StringBuilder sb, int start, int end) {
        if (sb.length() % 2 == 1) {
            int mid = start + (end - start) / 2;
            if (sb.charAt(mid) == '(') {
                sb.setCharAt(mid, ')');
            }
            else if (sb.charAt(mid) == ')') {
                sb.setCharAt(mid, '(');
            }
        }
        while (start < end) {
            if (sb.charAt(start) == '(') {
                sb.setCharAt(start, ')');
            }
            else if (sb.charAt(start) == ')') {
                sb.setCharAt(start, '(');
            }
            if (sb.charAt(end) == '(') {
                sb.setCharAt(end, ')');
            }
            else if (sb.charAt(end) == ')') {
                sb.setCharAt(end, '(');
            }
            swap(sb, start, end);
            start++;
            end--;
        }
    }
    private void swap(StringBuilder sb, int start, int end) {
        char temp = sb.charAt(start);
        sb.setCharAt(start, sb.charAt(end));
        sb.setCharAt(end, temp);
    }
    private int getPrecedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        }
        else if (ch == '*' || ch == '/') {
            return 2;
        }
        else if (ch == '^') {
            return 3;
        }
        return 0;
    }
}
