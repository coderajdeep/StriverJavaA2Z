package __07__StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_12_PostfixToPrefix {
    public String postToPre(String postfix) {
        Deque<String> stack = new ArrayDeque<>();
        for (char ch : postfix.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            }
            else {
                String s2 = stack.pop();
                String s1 = stack.pop();
                stack.push(ch + s1 + s2);
            }
        }
        return stack.pop();
    }


}
