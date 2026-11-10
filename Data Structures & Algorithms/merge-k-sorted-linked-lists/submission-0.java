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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length <= 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((l1, l2) -> l1.val - l2.val);

        for (ListNode l : lists) {
            while (l != null) {
                pq.offer(l);
                l = l.next;
            }
        }

        if (pq.size() <= 0) return null;

        ListNode head = pq.poll();
        ListNode s = head;

        while (!pq.isEmpty()) {
            ListNode n = pq.poll();
            head.next = n;
            head = head.next;
        }
        head.next = null;

        return s;
    }
}
