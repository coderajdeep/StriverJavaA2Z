package StackQueue;

public class Solution_06_ImplementQueueUsingLinkedList {
    public static class LinkedListQueue {
        private static class Queue {
            private int value;
            private Queue next;
            private Queue(int value) {
                this.value = value;
                this.next = null;
            }
        }

        private Queue front;
        private Queue rear;

        public LinkedListQueue() {
            front = null;
            rear = null;
        }

        public void push(int x) {
            Queue newNode = new Queue(x);
            if (isEmpty()) {
                front = rear = newNode;
            }
            else {
                rear.next = newNode;
                rear = newNode;
            }
        }

        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("Empty queue.");
            }
            int peekElement = front.value;
            if (front == rear) {
                front = null;
                rear = null;
            }
            else {
                front = front.next;
            }
            return peekElement;
        }

        public int peek() {
            if (isEmpty()) {
                throw new RuntimeException("Empty queue.");
            }
            return front.value;
        }

        public boolean isEmpty() {
            return front == null && rear == null;
        }
    }

}
