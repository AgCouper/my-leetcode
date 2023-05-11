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
        if (head == null || head.next == null) {
            return head;
        }

        var cur = head.next;
        var curVal = head.val;
        var tail = head;
        tail.next = null;

        while (cur != null) {
            if (cur.val != curVal) {
                curVal = cur.val;

                tail.next = cur;
                tail = cur;
                cur = cur.next;
                tail.next = null;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}