package StackQueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_03_ImplementStackUsingQueue_225 {
    private static class MyStack {
        private final Queue<Integer> queue;
        public MyStack() {
            queue = new ArrayDeque<>();
        }

        public void push(int x) {
            int size = queue.size();
            queue.offer(x);
            while (size > 0) {
                queue.offer(queue.poll());
                size--;
            }
        }

        public int pop() {
            if (empty()) {
                throw new RuntimeException("Empty stack");
            }
            else {
                return queue.poll();
            }
        }

        public int top() {
            if (empty()) {
                throw new RuntimeException("Empty stack");
            }
            else {
                return queue.peek();
            }
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
