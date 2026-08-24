package __04__LinkedList;

import java.util.HashSet;
import java.util.Set;

public class Solution_22_intersectionOfLinkedList_160 {
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
    public ListNode getIntersectionNodeBestSolution(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode ptrA = headA, ptrB = headB;
        while (ptrA != null && ptrB != null) {
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        while (ptrA != null && headA != null) {
            ptrA = ptrA.next;
            headA = headA.next;
        }
        while (ptrB != null && headB != null) {
            ptrB = ptrB.next;
            headB = headB.next;
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    // Time complexity O(n)
    // Space complexity O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        if (lengthA == 0 || lengthB == 0) {
            return null;
        }
        ListNode small = lengthA <= lengthB ? headA : headB;
        ListNode large = lengthA > lengthB ? headA : headB;
        int diff = Math.abs(lengthA-lengthB);
        for (int i=0; i<diff; i++) {
            large = large.next;
        }
        while (small != null && large != null) {
            if (small == large) {
                return large;
            }
            small = small.next;
            large = large.next;
        }
        return null;
    }
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }
    // Time complexity O(n)
    // Space complexity O(n)
    public ListNode getIntersectionNodeHashingSolution(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
