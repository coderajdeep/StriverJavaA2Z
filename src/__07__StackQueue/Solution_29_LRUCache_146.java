package __07__StackQueue;

import java.util.HashMap;
import java.util.Map;

public class Solution_29_LRUCache_146 {

    public static class LRUCache {

        private static class Node {
            int key;
            int value;
            Node next;
            Node prev;
            Node() {}
            Node(int key, int value) {
                this.key = key;
                this.value = value;
                this.next = null;
                this.prev = null;
            }
        }

        private int size, cap;
        private final Node head, tail;
        private Map<Integer, Node> nodes;

        public LRUCache(int capacity) {
            size = 0;
            cap = capacity;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            nodes = new HashMap<>();
        }

        private void insertAfterHead(Node node) {
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }

        private void deleteNodeFromDDL(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public int get(int key) {
            if (nodes.containsKey(key)) {
                Node node = nodes.get(key);
                deleteNodeFromDDL(node);
                insertAfterHead(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (nodes.containsKey(key)) {
                Node node = nodes.get(key);
                node.value = value;
                deleteNodeFromDDL(node);
                insertAfterHead(node);
            }
            else {
                Node node = new Node(key, value);
                nodes.put(key, node);
                insertAfterHead(node);
                size++;
                if (size > cap) {
                    Node nodeBeforeTail = tail.prev;
                    int keyValue = nodeBeforeTail.key;
                    nodes.remove(keyValue);
                    deleteNodeFromDDL(nodeBeforeTail);
                    size--;
                }
            }
        }

    }
}
