package StackQueue;

public class Solution_01_ImplementStackUsingArray {
    public static class ArrayStack {
        private final int[] array;
        private int top;
        private final int capacity;

        public ArrayStack() {
            capacity = 100;
            array = new int[capacity];
            top = -1;
        }

        public void push(int x) {
            if (top == capacity - 1) {
                throw new RuntimeException("Stack is full");
            }
            else {
                top++;
                array[top] = x;
            }
        }

        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            else {
                int topElement = array[top];
                top--;
                return topElement;
            }
        }

        public int top() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            else {
                return array[top];
            }
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }
}
