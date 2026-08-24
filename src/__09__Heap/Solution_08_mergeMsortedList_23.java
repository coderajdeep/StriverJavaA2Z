package __09__Heap;

import java.util.PriorityQueue;

public class Solution_08_mergeMsortedList_23 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
            val = 0;
            next = null;
        }

        ListNode(int val) {
            this.val = val;
            next = null;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    private static class Pair {
        private ListNode node;
        private int position;
        private Pair(ListNode node, int position) {
            this.node = node;
            this.position = position;
        }
    }

    // Time complexity O(m*n*log(m))
    // Time complexity O(m)
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.node.val - b.node.val);
        int size = lists.length;
        for (int i=0; i<size; i++) {
            if (lists[i] != null) {
                pq.offer(new Pair(lists[i], i));
            }
        }
        ListNode dummy = new ListNode(0), head = dummy;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            dummy.next = pair.node;
            dummy = dummy.next;
            lists[pair.position] = lists[pair.position].next;
            if (lists[pair.position] != null) {
                pq.offer(new Pair(lists[pair.position], pair.position));
            }
        }
        return head.next;
    }

    // Time complexity O(m*n*log(m))
    // Time complexity O(m)
    public ListNode mergeKListsBetterDataStructure(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<> ((a, b) -> a.val - b.val);
        int size = lists.length;
        for (int i=0; i<size; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }
        ListNode dummy = new ListNode(0), head = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            dummy.next = node;
            dummy = dummy.next;
            node = node.next;
            if (node != null) {
                pq.offer(node);
            }
        }
        return head.next;
    }
}
