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
        int n1, n2, c = 0;
        ListNode h = null, t = null;
        while (l1 != null || l2 != null) {
            n1 = l1 == null? 0 : l1.val;
            n2 = l2 == null? 0 : l2.val;
            int s = n1 + n2 + c;
            c = s / 10;
            int n = s % 10;

            var ln = new ListNode(n);
            
            l1 = l1 == null? null : l1.next;
            l2 = l2 == null? null : l2.next;

            if (h == null) {
                h = t = ln;
            } else {
                t.next = ln;
                t = ln;
            }
        }

        if (c != 0) {
            var ln = new ListNode(c);
            t.next = ln;
            t = ln;
        }

        return h;   
    }
}