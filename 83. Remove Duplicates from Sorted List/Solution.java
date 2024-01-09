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
    public ListNode deleteDuplicates(ListNode head) {
        //edge case, if head is null, just return null
        if (head == null) return null;
        //create a ListNode at the head of the given list
        ListNode noDupes = head;
        //noDupes will traverse the list
        //if the next value of the list is a duplicate, skip to the next node
        //if it's unique, make it the next node
        while (noDupes.next != null) {
            if (noDupes.val == noDupes.next.val) {
                noDupes.next = noDupes.next.next;
            } else {
                noDupes = noDupes.next;
            }
        }
        return head;
    }
    /* helper method to print the list when debugging
        print by doing 
        System.out.print("List is: ");
                printList(head);

    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    */
}

