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
        int overhead = 0;
        ListNode res = new ListNode();
        ListNode head = res;
        while (l1 != null && l2 != null) {
            int sum = overhead + l1.val + l2.val;
            overhead = sum / 10;
            head.next = new ListNode(sum % 10);
            head = head.next;

            l1 = l1.next;
            l2 = l2.next;
        }
        while (overhead > 0) {
            int sum = overhead;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            } else if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            overhead = sum / 10;
            head.next = new ListNode(sum % 10);
            head = head.next;
        }

        if (l1 != null) {
            head.next = l1;
        } else if (l2 != null) {
            head.next = l2;
        }
        return res.next;
    }
}
