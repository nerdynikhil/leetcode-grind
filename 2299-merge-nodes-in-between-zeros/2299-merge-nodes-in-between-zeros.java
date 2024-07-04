/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        ListNode temp = head.next;
        int intervalSum = 0;

        while (temp != null) {
            if (temp.val == 0) {
                current.next = new ListNode(intervalSum);
                current = current.next;
                intervalSum = 0;
            } else {
                intervalSum += temp.val;
            }
            temp = temp.next;
        }

        return dummy.next;
    }
}