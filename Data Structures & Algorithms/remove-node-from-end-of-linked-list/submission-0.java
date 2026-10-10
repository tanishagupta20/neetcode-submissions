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
        ListNode ptr = head;
        int len = 0;
        while(ptr != null){
            ptr = ptr.next;
            len++;
        }

        if(n == len){
            head = head.next;
            return head;
        }

        ptr = head;
        ListNode prePtr = null;
        int hops = 0, counter = len - n;
        while(hops != counter){
            prePtr = ptr;
            ptr = ptr.next;
            hops++;
        }

        prePtr.next = ptr.next;
        ptr.next = null;

        return head;
    }
}