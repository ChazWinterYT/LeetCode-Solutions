/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        slow = reversed(slow);

        while (slow != null) {
            if (slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    private ListNode reversed(ListNode head) {
        ListNode prev = null;
        while (head != null) {          //ex: 3, 2, 1   head: 3     prev: null
            ListNode next = head.next;  //next: 2           next: 1     next: null
            head.next = prev;           //head.next = null  h.n = 3     h.n = 2
            prev = head;                //prev = 3          prev: 2     prev: 1
            head = next;                //head: 2           head: 1     head: null
        }
        return prev;
    }
}