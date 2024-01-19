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
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        ListNode right = head;
        int listSize = 1;
        
        while (right.next != null) {
            listSize++;
            right = right.next;
        }
        if (listSize == 2) {
            head.next = null;
            return head;
        }
        if (listSize == 3) {
            head.next = head.next.next;
            return head;
        }
        ListNode left = head;
        right = head;
        for (int i = 0; i < listSize / 2 - 1; i++) {
            left = left.next;
            right = right.next;
        }
        right = right.next.next;
        left.next = right;
        return head;
    }
}