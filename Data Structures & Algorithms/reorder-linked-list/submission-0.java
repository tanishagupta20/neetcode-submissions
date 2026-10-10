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
        // find the mid;
        ListNode end = head;
        int len = 0;
        while(end != null){
            end = end.next;
            len++;
        }

        int mid = len % 2 == 0 ? len / 2 : (len / 2) + 1;
        int hops = 0;

        ListNode head2 = head;
        ListNode beforeHead2 = null;
        while(hops != mid){
            beforeHead2 = head2;
            head2 = head2.next;
            hops++;
        }

        beforeHead2.next = null;

        // reverse the second half
        ListNode prev = null, next = null, curr = head2;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head2 = prev;

        // merge
        ListNode ptr1 = head, ptr2 = head2, ptr1Next = null, ptr2Next = null;
        while(ptr2 != null){
            ptr1Next = ptr1.next;
            ptr2Next = ptr2.next;

            ptr1.next = ptr2;
            ptr2.next = ptr1Next;

            ptr1 = ptr1Next;
            ptr2 = ptr2Next;
        }
    }
}