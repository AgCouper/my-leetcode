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
    public ListNode middleNode(ListNode head) {
        ListNode tailRunner = head;
        ListNode middleRunner = head;

        while (tailRunner.next != null) {
            middleRunner = middleRunner.next;
            tailRunner = tailRunner.next;
            if (tailRunner.next != null) {
                tailRunner = tailRunner.next;
            }
        }

        return middleRunner;        
    }
}