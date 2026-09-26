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

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode rabbit = head, turtle = head;
        while(rabbit != null && rabbit.next != null){
            rabbit = rabbit.next.next;
            turtle = turtle.next;
            if(rabbit == turtle) return true;
        }

        return false;
    }
}
