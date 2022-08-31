class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        ListNode head = new ListNode(0, 0, null, null); // dummy head
        ListNode tail = new ListNode(0, 0, head, null); // dummy tail
        head.next = tail;

        int resLength = 0;
        for (int colIdx = 0; colIdx < mat.length; ++colIdx) {
            int[] row = mat[colIdx];
            int rowStrength = 0;
            for (int i : row) {
                if (i == 0) {
                    break;
                } else {
                    rowStrength++;
                }
            }

            ListNode cur = head.next;
            ListNode prev = head;
            while (cur != tail && rowStrength >= cur.val) {
                prev = cur;
                cur = cur.next;
            }

            resLength++;
            prev.next = new ListNode(rowStrength, colIdx, prev, cur);

            if (resLength > k) {
                // delete last
                resLength--;
                prev = tail.prev;
                prev.prev.next = tail;
            }
        }

        int[] res = new int[k];
        ListNode cur = head.next;
        for (int i = 0; i < k; ++i) {
            res[i] = cur.pos;
            cur = cur.next;
        }

        return res;
    }

   public static class ListNode {
        ListNode prev;
        ListNode next;
        int val;
        int pos;

        ListNode(int val, int pos) {
            this.val = val;
            this.pos = pos;

            this.prev = null;
            this.next = null;
        }

        ListNode(int val, int pos, ListNode prev, ListNode next) {
            this.val = val;
            this.pos = pos;

            this.prev = prev;
            this.next = next;

            if (prev != null) {
                prev.next = this;
            }

            if (next != null) {
                next.prev = this;
            }
        }
    }    
}