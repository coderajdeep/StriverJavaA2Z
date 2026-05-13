package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_04_ImplementQueueUsingStack_232 {
    public static class MyQueue {

        private final Deque<Integer> input;
        private final Deque<Integer> output;

        public MyQueue() {
            input = new ArrayDeque<>();
            output = new ArrayDeque<> ();
        }

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            if (empty()) {
                throw new RuntimeException("Queue is empty");
            }
            else {
                if (output.isEmpty()) {
                    while (!input.isEmpty()) {
                        output.push(input.pop());
                    }
                }
                return output.pop();
            }
        }

        public int peek() {
            if (empty()) {
                throw new RuntimeException("Queue is empty");
            }
            else {
                if (output.isEmpty()) {
                    while (!input.isEmpty()) {
                        output.push(input.pop());
                    }
                }
                return output.peek();
            }
        }

        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }
}
