package __07__StackQueue;

public class Solution_Q3_CircularQueue_622 {
    public static class MyCircularQueue {

        private int front, rear, size;
        private final int cap;
        private final int[] arr;

        public MyCircularQueue(int k) {
            cap = k;
            size = 0;
            front = 0;
            rear = 0;
            arr = new int[cap];
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            size++;
            rear = rear % cap;
            arr[rear] = value;
            rear++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            size--;
            front++;
            if (size == 0) {
                front = rear = 0;
            }
            else {
                front = front % cap;
            }
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return arr[front];
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return arr[rear-1];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return cap == size;
        }
    }
}
