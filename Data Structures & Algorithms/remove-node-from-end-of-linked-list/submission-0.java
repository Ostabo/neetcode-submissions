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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode s = head;
        int size = 1;
        while (head != null) {
            size++;
            head = head.next;
        }
        if (n > size) return s;
        head = s;
        ListNode last = null;
        for (int i = 1; i < size - n; i++) {
            last = head;
            head = head.next;
        }

        if (last != null)
            last.next = head.next;
        else return s.next;

        return s;
    }
}
