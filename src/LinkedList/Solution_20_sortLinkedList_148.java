package LinkedList;

public class Solution_20_sortLinkedList_148 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    // Merge sort
    // Time complexity O(nlog(n))
    // Space complexity O(1)
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middleNode = getMiddleNode(head);
        ListNode sortedFirstHalf = sortList(head);
        ListNode sortedSecondHalf = sortList(middleNode);
        return mergeSortedList(sortedFirstHalf, sortedSecondHalf);
    }
    private ListNode mergeSortedList(ListNode first, ListNode second) {
        if (first == null) {
            return second;
        }
        else if (second == null) {
            return first;
        }
        ListNode dummyHead = new ListNode(0), head = dummyHead;
        while (first != null && second != null) {
            if (first.val <= second.val) {
                dummyHead.next = first;
                first = first.next;
            }
            else {
                dummyHead.next = second;
                second = second.next;
            }
            dummyHead = dummyHead.next;
        }
        if (first != null) {
            dummyHead.next = first;
        }
        if (second != null) {
            dummyHead.next = second;
        }
        return head.next;
    }
    private ListNode getMiddleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }
}
