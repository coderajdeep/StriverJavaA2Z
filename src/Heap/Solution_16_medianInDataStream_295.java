package Heap;

import java.util.PriorityQueue;

public class Solution_16_medianInDataStream_295 {
    public static class MedianFinder {

        private final PriorityQueue<Integer> minHeap, maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<> ();
            maxHeap = new PriorityQueue<> ((a, b) -> b - a);
        }

        public void addNum(int num) {
            // This condition should be on top
            if (maxHeap.isEmpty()) {
                maxHeap.offer(num);
            }
            else if (maxHeap.size() == minHeap.size()) {
                // Here non of the heap is empty
                if (minHeap.peek() < num) {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(num);
                }
                else {
                    maxHeap.offer(num);
                }
            }
            else {
                // Control flow will come here when maxHeap.size() > minHeap.size()
                if (maxHeap.peek() <= num) {
                    minHeap.offer(num);
                }
                else {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(num);
                }
            }
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                return (double) maxHeap.peek();
            }
            else {
                return (double) ((maxHeap.peek() + minHeap.peek()) / 2.0);
            }
        }
    }
}
