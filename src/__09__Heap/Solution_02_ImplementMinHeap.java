package __09__Heap;

public class Solution_02_ImplementMinHeap {
    public static class MinHeap {
        private int capacity;
        private int size;
        private int[] array;

        public MinHeap() {
            this.initializeHeap();
        }

        public void initializeHeap() {
            capacity = 100001;
            array = new int[capacity];
            size = 0;
        }

        public void insert(int key) {
            if (capacity == size) {
                throw new RuntimeException("Heap overflow.");
            }
            array[size++] = key;
            int index = size - 1;
            heapifyUp(index, array);
        }

        public void changeKey(int index, int newVal) {
            if (array[index] == newVal) {
                return;
            }
            array[index] = newVal;
            int parent = getParent(index);
            if (array[index] < array[parent]) {
                heapifyUp(index, array);
            }
            else {
                heapifyDown(index, size, array);
            }
        }

        public void extractMin() {
            if (size == 0) {
                throw new RuntimeException("Empty heap");
            }
            swap(array, 0, size - 1);
            size--;
            heapifyDown(0, size, array);
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int getMin() {
            if (size == 0) {
                throw new RuntimeException("Empty heap");
            }
            return array[0];
        }

        public int heapSize() {
            return size;
        }

        private static int getLeftChild(int index) {
            return (2 * index + 1);
        }

        private static int getRightChild(int index) {
            return (2 * index + 2);
        }

        private static int getParent(int index) {
            return (index - 1) / 2;
        }

        private static void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        private static void heapifyDown(int index, int size, int[] array) {
            while (index < size) {
                int smallest = index;
                int left = getLeftChild(index);
                int right = getRightChild(index);
                if (left < size && array[smallest] > array[left]) {
                    smallest = left;
                }
                if (right < size && array[smallest] > array[right]) {
                    smallest = right;
                }
                if (smallest == index) {
                    break;
                }
                swap(array, index, smallest);
                index = smallest;
            }
        }

        private static void heapifyUp(int index, int[] array) {
            int parent = getParent(index);
            while (index > 0 && array[index] < array[parent]) {
                swap(array, index, parent);
                index = parent;
                parent = getParent(index);
            }
        }
    }
}
