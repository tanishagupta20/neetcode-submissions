/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node newList = new Node(head.val);
        HashMap<Node, Node> hm = new HashMap<>();
        Node curr = head.next, curr2 = newList, head2 = newList;
        hm.put(head, curr2);
        while(curr != null){
            Node n = new Node(curr.val);
            curr2.next = n;
            curr2 = n;
            hm.put(curr, n);
            curr = curr.next;
        }

        curr = head;
        while(curr != null){
            hm.get(curr).random = hm.get(curr.random);
            curr = curr.next;
        }

        return head2;
    }
}