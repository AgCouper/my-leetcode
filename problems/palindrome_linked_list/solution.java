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
        if (head == null) {
            return true;
        }

        int len = 0;
        var cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        if (len == 1) {
            return true;
        }

        int checkLen = len / 2;

        cur = head;
        ListNode revHead = null;
        for (int i = 0; i < checkLen; i++) {
            var next = cur.next;
            cur.next = revHead;
            revHead = cur;
            cur = next;
        }


        var cur1 = revHead;
        var cur2 = cur;
        if (len % 2 != 0) {
            cur2 = cur2.next;
        }

        for (int i = 0; i < checkLen; i++) {
            if (cur1.val != cur2.val) {
                return false;
            }

            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return true;

    }
}