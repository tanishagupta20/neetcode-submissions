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
    public ListNode reverse(ListNode start, ListNode end){
        ListNode curr = start, prev = null, next = null;
        while(curr != end){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupTail = dummy;
        ListNode start = head;

        while(start != null){
            ListNode end = start;
            int count = 0;

            while(count < k && end != null) {
                end = end.next;
                count++;
            }

            if (count < k) break;
            ListNode newGroupHead = reverse(start, end);
            prevGroupTail.next = newGroupHead;

            start.next = end;
            prevGroupTail = start;
            start = end;
        }
        
        return dummy.next;
    }
}