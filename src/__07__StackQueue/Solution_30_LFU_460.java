package __07__StackQueue;

import java.util.HashMap;
import java.util.Map;

public class Solution_30_LFU_460 {

    public static class LFUCache {

        private static class Node {
            int key, value, freq;
            Node prev, next;
            // key : 0, value : 0, freq : 0, prev = null, next = null
            Node() {}
            Node(int k, int v) {
                key = k;
                value = v;
                freq = 1;
            }
        }

        private static class DLL {
            int count;
            Node head, tail;
            DLL() {
                count = 0;
                head = new Node();
                tail = new Node();
                head.next = tail;
                tail.prev = head;
            }
            boolean isEmpty() {
                return count == 0;
            }
            void addFront(Node node) {
                node.next = head.next;
                head.next.prev = node;
                node.prev = head;
                head.next = node;
                count++;
            }
            void remove(Node node) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                count--;
            }
            Node removeLast() {
                if (isEmpty()) {
                    return null;
                }
                Node last = tail.prev;
                remove(last);
                return last;
            }
        }

        int size, cap, minFreq;
        Map<Integer, Node> nodes;
        Map<Integer, DLL> freqMap;

        public LFUCache(int capacity) {
            size = 0;
            minFreq = 0;
            cap = capacity;
            nodes = new HashMap<>();
            freqMap = new HashMap<> ();
        }

        void updateFreqMap(Node node) {
            int freq = node.freq;
            DLL oldList = freqMap.get(freq);
            oldList.remove(node);
            if (oldList.isEmpty()) {
                freqMap.remove(freq);
                if (freq == minFreq) {
                    minFreq++;
                }
            }
            node.freq++;
            freqMap.computeIfAbsent(freq + 1, k -> new DLL()).addFront(node);
        }

        public int get(int key) {
            Node node = nodes.get(key);
            if (node == null) {
                return -1;
            }
            updateFreqMap(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (cap == 0) {
                return;
            }
            Node node = nodes.get(key);
            if (node != null) {
                node.value = value;
                updateFreqMap(node);
                return;
            }
            if (cap == size) {
                DLL minFreqList = freqMap.get(minFreq);
                Node last = minFreqList.removeLast();
                nodes.remove(last.key);
                size--;
                if (minFreqList.isEmpty()) {
                    freqMap.remove(minFreq);
                }
            }
            Node temp = new Node(key, value);
            nodes.put(key, temp);
            minFreq = 1;
            size++;
            freqMap.computeIfAbsent(1, k -> new DLL()).addFront(temp);
        }
    }

}
