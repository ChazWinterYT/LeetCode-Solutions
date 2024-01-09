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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode start = new ListNode(-1);
        ListNode current = start;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            } 
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;   //if sum > 10, we need a carry bit
            sum = sum % 10;     //if sum > 10, we only need the last digit
            
            ListNode newNode = new ListNode(sum);
            current.next = newNode;
            current = current.next;
        }
        // if there is a carry left over, we need a node for it
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        
        return start.next;
    }
}