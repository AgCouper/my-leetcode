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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode tail = null;
        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode l;

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        int v1 = l1.val;
        int v2 = l2.val;
        if (v1 < v2) {
            l = l1;
            l1 = l1.next;
        } else {
            l = l2;
            l2 = l2.next;
        }

        head = l;
        head.next = null;
        tail = head;

        while (l1 != null && l2 != null) {
            v1 = l1.val;
            v2 = l2.val;
            
            if (v1 < v2) {
                l = l1;
                l1 = l1.next;
            } else {
                l = l2;
                l2 = l2.next;
            }

            tail.next = l;
            l.next = null;
            tail = l;
        }

        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }

        return head;
    }
}