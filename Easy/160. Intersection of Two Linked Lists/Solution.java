/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int listALength = 0, listBLength = 0;
        ListNode a = headA, b = headB;
        
        while (a != null) {
            listALength++;
            a = a.next;
        }
        while (b != null) {
            listBLength++;
            b = b.next;
        }
        // reset a and b back to start
        a = headA; b = headB;
        // move along one list so that it's caught up to the second list position-wise
        int diff = Math.abs(listALength - listBLength);
        if (listALength > listBLength) {
            for (int i = 0; i < diff; i++) {
                a = a.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                b = b.next;
            }
        }
        
        //traverse the lists together until you get a match
        while (a != null && b != null) {
            if (a == b) return a;
            a = a.next;
            b = b.next;
        }
        return null;
    }
}