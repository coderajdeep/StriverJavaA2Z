package __09__Heap;

public class BasicHeap {
    private static final int CAPACITY = 100;
    public static class MinHeap {
        private int[] array;
        private int size;
        private final int capacity;
        public MinHeap(int capacity) {
            this.capacity = Math.max(capacity, CAPACITY);
            this.size = 0;
            array = new int[this.capacity];
        }
        public void setSize(int size) {
            this.size = size;
        }
        public int getSize() {
            return this.size;
        }
        private int getParent(int index) {
            return (index - 1) / 2;
        }
        private int getLeftChild(int index) {
            return (2 * index + 1);
        }
        private int getRightChild(int index) {
            return (2 * index + 2);
        }


    }
    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    public static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
