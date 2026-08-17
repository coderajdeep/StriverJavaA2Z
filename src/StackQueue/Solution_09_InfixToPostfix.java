package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_09_InfixToPostfix {
    // Time complexity O(n)
    // Space complexity O(n)
    public String infixToPostfix(String s) {
        int size = s.length();
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();
        for (int i=0; i<size; ++i) {
            char ch = s.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
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
                // When the Character is an operator
                // This condition will change in case of infixToPrefix conversion
                while (!stack.isEmpty() && ((getPrecedence(ch) < getPrecedence(stack.peek()))
                        || ((stack.peek() != '^') && (getPrecedence(ch) == getPrecedence(stack.peek()))))) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
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
        else {
            return 0;
        }
    }

    public String infixToPostfixImprovedReadability(String expression) {
        Deque<Character> operatorStack = new ArrayDeque<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);

            // Case 1: Operand (a-z, 0-9)
            if (isOperand(current)) {
                postfix.append(current);
            }

            // Case 2: Opening bracket
            else if (current == '(') {
                operatorStack.push(current);
            }

            // Case 3: Closing bracket
            else if (current == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.pop(); // remove '('
            }

            // Case 4: Operator
            else {
                while (!operatorStack.isEmpty() && shouldPop(current, operatorStack.peek())) {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.push(current);
            }
        }

        // Pop remaining operators
        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop());
        }

        return postfix.toString();
    }

    private boolean isOperand(char ch) {
        return Character.isLetterOrDigit(ch);
    }

    private boolean shouldPop(char current, char top) {
        int currPrecedence = getPrecedenceImprovedReadability(current);
        int topPrecedence = getPrecedenceImprovedReadability(top);

        // Pop if:
        // 1. Higher precedence on stack
        // 2. Same precedence and not right-associative (^)
        return (currPrecedence < topPrecedence) ||
                (currPrecedence == topPrecedence && top != '^');
    }

    private int getPrecedenceImprovedReadability(char operator) {
        // Java 14 syntax
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> 0;
        };
    }
}
