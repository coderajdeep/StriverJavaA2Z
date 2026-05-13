package LinkedList;

public class Solution_09_ReverseDoublyLinkedList {
    public static class ListNode {
        public int data;
        public ListNode prev, next;
        public ListNode(int val) {
            this.data = val;
            this.prev = null;
            this.next = null;
        }
    }
    public ListNode reverseDLL(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            head.prev = head.next;
            head.next = prev;
            prev = head;
            head = head.prev;
        }
        return prev;
    }
}
