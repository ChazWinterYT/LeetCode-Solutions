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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return mergeKListsRecursive(lists, 0, lists.length - 1);
    }

    private ListNode mergeKListsRecursive(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeKListsRecursive(lists, start, mid);
        ListNode right = mergeKListsRecursive(lists, mid + 1, end);
        return mergeTwoSortedLists(left, right);
    }

    private ListNode mergeTwoSortedLists(ListNode node1, ListNode node2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                current.next = node1;
                node1 = node1.next;
            } else {
                current.next = node2;
                node2 = node2.next;
            }
            current = current.next;
        }

        if (node1 != null) {
            current.next = node1;
        } else {
            current.next = node2;
        }

        return dummyHead.next;
    }
}
