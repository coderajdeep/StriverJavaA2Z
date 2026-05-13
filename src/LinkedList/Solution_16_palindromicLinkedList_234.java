package LinkedList;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_16_palindromicLinkedList_234 {
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
    // Space complexity O(n)
    // Not modifying the linkedList
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            if (stack.pop().val != curr.val) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }

    // Time complexity O(n)
    // Space complexity O(1)
    // Modifying the linkedList
    public boolean isPalindromeBestSolution(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        fast = head;
        slow = getReverseedList(slow);
        while (fast != null && slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    private ListNode getReverseedList(ListNode head) {
        ListNode prev = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
