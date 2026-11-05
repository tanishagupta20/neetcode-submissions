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
        if(lists.length == 0) return null;
        ListNode head = null, current = null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null) pq.offer(lists[i]);
        }
        while(!pq.isEmpty()){
            ListNode smallest = pq.poll();
            ListNode next = smallest.next;
            if(head == null) head = smallest;
            else current.next = smallest;
            current = smallest;
            if(next != null) pq.offer(next);
        }
        return head;
    }
}
