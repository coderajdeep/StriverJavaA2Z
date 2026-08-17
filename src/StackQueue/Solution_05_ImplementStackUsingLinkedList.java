package StackQueue;

public class Solution_05_ImplementStackUsingLinkedList {
    public static class LinkedListStack {
        // Why static inner class in preferred here
        // https://chatgpt.com/share/69d76121-8cc8-83a6-a7ca-05dc63c1e93e
        private static class Stack {
            private final int value;
            private Stack next;
            private Stack(int value) {
                this.value = value;
                this.next = null;
            }
        }
        private Stack top;
        public LinkedListStack() {
            top = null;
        }

        public void push(int x) {
            Stack newNode = new Stack(x);
            if (isEmpty()) {
                top = newNode;
            }
            else {
                newNode.next = top;
                top = newNode;
            }
        }

        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("Empty stack");
            }
            else {
                int peekElement = top.value;
                top = top.next;
                return peekElement;
            }
        }

        public int top() {
            if (isEmpty()) {
                throw new RuntimeException("Empty stack");
            }
            else {
                return top.value;
            }
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

    // Below solution is not good
    // We tried to use only one class to acive stack behavior
    public static class LinkedListStackAnotherSolution {

        private LinkedListStackAnotherSolution next;
        private LinkedListStackAnotherSolution top;
        private int value;

        public LinkedListStackAnotherSolution() {
            next = null;
            top = this;
        }
        public LinkedListStackAnotherSolution(int value) {
            next = null;
            this.value = value;
        }

        public void push(int x) {
            LinkedListStackAnotherSolution node = new LinkedListStackAnotherSolution(x);
            node.next = top;
            top = node;
        }

        public int pop() {
            int topElement = top.value;
            top = top.next;
            return topElement;
        }

        public int top() {
            return top.value;
        }

        public boolean isEmpty() {
            return top.next == null;
        }
    }


}
