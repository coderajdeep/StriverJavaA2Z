package LinkedList;

public class Solution_17_OddEvenSegrregation_328 {
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

    // Time complexity O(n)
    // Space complexity O(1)
    // Best solution for this problem
    public ListNode oddEvenListBestSolution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    // Time complexity O(n)
    // Space complexity O(1)
    // This will work with lots of scenario
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        boolean isOdd = true;
        ListNode evenDummy = new ListNode(-1), oddDummy = new ListNode(-1), evenDummyStart = evenDummy, oddDummyStart = oddDummy;
        while (head != null) {
            if (isOdd) {
                oddDummy.next = head;
                oddDummy = oddDummy.next;
            }
            else {
                evenDummy.next = head;
                evenDummy = evenDummy.next;
            }
            head = head.next;
            isOdd = !isOdd;
        }
        evenDummy.next = null; // Terminate even list
        oddDummy.next = evenDummyStart.next;
        return oddDummyStart.next;
    }

    // Time complexity O(n)
    // Space complexity O(n)
    public ListNode oddEvenListWithExtraSpace(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        boolean isOdd = true;
        ListNode evenDummy = new ListNode(-1), oddDummy = new ListNode(-1), evenDummyStart = evenDummy, oddDummyStart = oddDummy;
        while (head != null) {
            if (isOdd) {
                oddDummy.next = new ListNode(head.val);
                oddDummy = oddDummy.next;
            }
            else {
                evenDummy.next = new ListNode(head.val);
                evenDummy = evenDummy.next;
            }
            head = head.next;
            isOdd = !isOdd;
        }
        oddDummy.next = evenDummyStart.next;
        return oddDummyStart.next;
    }
}
