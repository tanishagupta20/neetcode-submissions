class LRUCache {
    HashMap<Integer, Node> hm;
    int capacity;
    Node head, tail;

    class Node{
        int key, value;
        Node next, prev;
        Node(int key, int val){
            this.key = key;
            this.value = val;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hm = new HashMap<>();
    }

    public void moveToTail(Node node){
        if(node == tail) return;
        if(node == head){
            node.next.prev = null;
            head = node.next;
        }
        else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        
        tail.next = node;
        node.prev = tail;
        node.next = null;
        tail = node;
    }
    
    public int get(int key) {
        int returnedValue;
        if(hm.containsKey(key)){
            returnedValue = hm.get(key).value;
            moveToTail(hm.get(key));
            return returnedValue;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // existing key updated
        if(hm.containsKey(key)){
            Node node = hm.get(key);
            node.value = value;
            moveToTail(node);
            return;
        }

        Node node = new Node(key, value);

        // cache full
        if(hm.size() == capacity){
            if(head == tail){
                hm.remove(head.key);
                head = node;
                tail = node;
                hm.put(key, node);
                return;
            }

            Node n = head;
            head = head.next;
            head.prev = null;
            hm.remove(n.key);
        }

        // space present
        if(head == null){
            head = node;
            tail = node;
        }
        else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        hm.put(key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */