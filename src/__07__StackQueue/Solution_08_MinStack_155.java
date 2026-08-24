package __07__StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_08_MinStack_155 {

    // Time complexity O(1) - for all the methods
    // Space complexity O(2*n) - used one stack but each element is a pair of currentValue and currentMinimum
    public static class MinStack {
        private final Deque<Integer> stack;
        private final Deque<Integer> minStack;

        public MinStack() {
            stack = new ArrayDeque<> ();
            minStack = new ArrayDeque<> ();
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(val);
                minStack.push(val);
            }
            else {
                stack.push(val);
                minStack.push(Math.min(val, minStack.peek()));
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
                minStack.pop();
            }
        }

        public int top() {
            if (!stack.isEmpty()) {
                return stack.peek();
            }
            return -1;
        }

        public int getMin() {
            if (!minStack.isEmpty()) {
                return minStack.peek();
            }
            return -1;
        }
    }


    // Time complexity O(1) - for all the methods
    // Space complexity O(2*n) - used two stack
    public static class MinStackUsingTwoStack {

        private final Deque<Integer> stack, minStack;

        public MinStackUsingTwoStack() {
            this.stack = new ArrayDeque<> ();
            this.minStack = new ArrayDeque<> ();
        }

        public void push(int value) {
            if (minStack.isEmpty() || minStack.peek() > value) {
                stack.push(value);
                minStack.push(value);
            }
            else {
                minStack.push(minStack.peek());
                stack.push(value);
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    // Time complexity O(1) - for all the methods
    // Space complexity O(2*n) - used two stack
    public static class MinStackUsingRecord {
        private static record Pair(int value, int minValue) {}
        private final Deque<Pair> stack;

        public MinStackUsingRecord() {
            stack = new ArrayDeque<> ();
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(new Pair(val, val));
            }
            else {
                stack.push(new Pair(val, Math.min(val, stack.peek().minValue())));
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        public int top() {
            if (!stack.isEmpty()) {
                return stack.peek().value();
            }
            return -1;
        }

        public int getMin() {
            if (!stack.isEmpty()) {
                return stack.peek().minValue();
            }
            return -1;
        }
    }

    // Time complexity O(1) - for all the methods
    // Space complexity O(n) - used one stack
    public static class MinStackBestSolution {

        private Deque<Long> stack;
        private long minElement;
        private long topElement;

        public MinStackBestSolution() {
            stack = new ArrayDeque<> ();
        }

        public void push(int val) {
            long value = (long) val;
            if (stack.isEmpty()) {
                stack.push(value);
                minElement = value;
            }
            else if (value < minElement) {
                // https://youtu.be/NdDIaH91P0g
                // We need to do this, otherwise we will lost the previous min wehn we pop out the current element
                // updatedValue = 2L * value - prevMinElement
                long updatedValue = 2L * value - minElement;
                stack.push(updatedValue);
                minElement = value;
            }
            else {
                // when value >= minElement
                stack.push(value);
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                topElement = stack.pop();
                if (topElement < minElement) {
                    // In this case, topElement is the updatedValue
                    // Actual top value is the minElement
                    // From the previous calculation
                    // updatedValue = 2L * value - prevMinElement
                    // prevMinElement = 2L * value - updatedValue (value -> minElement, updatedValue -> topElement)
                    minElement = 2L * minElement - topElement;
                }
            }
        }

        public int top() {
            if (!stack.isEmpty()) {
                topElement = stack.peek();
                if (topElement < minElement) {
                    // In this case, topElement is the updatedValue
                    // Actual top value is the minElement
                    return (int) minElement;
                }
                else {
                    return (int) topElement;
                }
            }
            return -1;
        }

        public int getMin() {
            return (int) minElement;
        }
    }
}
