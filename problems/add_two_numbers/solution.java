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
        ListNode head = null;
        ListNode tail = null;
    
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val = 0;
            
            if (l1 == null) {
                val = l2.val + carry;
                carry = 0;
                if (val >= 10) {
                    val = val - 10;
                    carry = 1;
                }
                
                l2 = l2.next;
            } else if (l2 == null) {
                val = l1.val + carry;
                carry = 0;
                if (val >= 10) {
                    val = val - 10;
                    carry = 1;
                }
                
                l1 = l1.next;                
            } else {
                val = l1.val + l2.val + carry;
                carry = 0;
                if (val >= 10) {
                    val = val - 10;
                    carry = 1;
                }
                
                l1 = l1.next;
                l2 = l2.next;
            }
            
            ListNode n = new ListNode(val, null);
            if (head == null) {
                head = n;
                tail = n;
            } else {
                tail.next = n;
                tail = n;
            }
        }
        
        if (carry != 0) {
            ListNode n = new ListNode(1, null);
            tail.next = n;
        }
        
        return head;
    }
}