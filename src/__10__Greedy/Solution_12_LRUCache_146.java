package __10__Greedy;

import java.util.HashMap;
import java.util.Map;

public class Solution_12_LRUCache_146 {

    public static class LRUCache {

        private static class Node {
            int key, value;
            Node next, prev;
            Node() {}
            Node(int k, int v) {
                key = k;
                value = v;
            }
        }

        private Node head, tail;
        private int cap, size;
        private Map<Integer, Node> nodes;

        public LRUCache(int capacity) {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            nodes = new HashMap<>();
            cap = capacity;
            size = 0;
        }

        private void addFront(Node node) {
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }

        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public int get(int key) {
            Node node = nodes.get(key);
            if (node == null) {
                return -1;
            }
            remove(node);
            addFront(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = nodes.get(key);
            if (node != null) {
                remove(node);
                addFront(node);
                node.value = value;
                return;
            }
            if (cap == size) {
                Node last = tail.prev;
                remove(last);
                nodes.remove(last.key);
                size--;
            }
            Node temp = new Node(key, value);
            size++;
            nodes.put(key, temp);
            addFront(temp);
        }

    }
}
