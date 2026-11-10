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
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode start = head;

        Stack<ListNode> s = new Stack();
        int size = 1;
        while (head != null) {
            size++;
            s.push(head);
            head = head.next;
        }

        head = start;
        int i = 0;
        while (i < size / 2) {
            ListNode n = s.pop();
            n.next = head.next;
            head.next = n;
            head = n.next;
            i++;
        }
        if (head != null) head.next = null;
        head = start;
    }
}
