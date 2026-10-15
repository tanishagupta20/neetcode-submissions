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
        int carry = 0, sum = 0, num = 0;
        ListNode head = new ListNode(0);
        ListNode ptr = head, ptr1 = l1, ptr2 = l2;
        if(l1 == null && l2 == null) return null;
        else if(l1 == null && l2 != null) return l2;
        else if(l1 != null && l2 == null) return l1;
        else{
            while(ptr1 != null && ptr2 != null){
                sum = ptr1.val + ptr2.val + carry;
                num = sum % 10;
                carry = sum / 10;
                ptr.next = new ListNode(num);
                ptr = ptr.next;
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
            if(ptr1 == null && ptr2 != null){
                while(ptr2 != null){
                    sum = ptr2.val + carry;
                    num = sum % 10;
                    carry = sum / 10;
                    ptr.next = new ListNode(num);
                    ptr = ptr.next;
                    ptr2 = ptr2.next;
                }
            }
            if(ptr2 == null && ptr1 != null){
                while(ptr1 != null){
                    sum = ptr1.val + carry;
                    num = sum % 10;
                    carry = sum / 10;
                    ptr.next = new ListNode(num);
                    ptr = ptr.next;
                    ptr1 = ptr1.next;
                }
            }
            if(carry != 0){
                ptr.next = new ListNode(carry);
                ptr = ptr.next;
            }
        }
        return head.next;
    }
}