package Heap;

public class Heap {
    public static class MinHeap {
        private int[] array;
        private final int size;
        public MinHeap(int size) {
            this.size = size;
            array = new int[this.size];
        }
    }
}
