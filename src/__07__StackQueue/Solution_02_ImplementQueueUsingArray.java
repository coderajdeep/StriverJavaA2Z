package __07__StackQueue;

public class Solution_02_ImplementQueueUsingArray {
    public static class ArrayQueue {
        private int front;
        private int rear;
        private final int capacity;
        private final int[] array;
        public ArrayQueue() {
            capacity = 100;
            front = 0;
            rear = 0;
            array = new int[capacity];
        }

        public void push(int x) {
            if (rear == capacity) {
                throw new RuntimeException("Queue is full");
            }
            array[rear] = x;
            rear++;
        }

        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            int peekElement = array[front];
            front++;
            return peekElement;
        }

        public int peek() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            return array[front];
        }

        public boolean isEmpty() {
            return front == rear;
        }
    }

}
