class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val, Node prev, Node next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    int cap;
    Map<Integer, Node> kv;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        cap = capacity;
        kv = new HashMap();
    }
    
    public int get(int key) {
        if (!kv.containsKey(key)) return -1;
        Node n = kv.get(key);
        if (n.prev != null) {
            if (n == tail) {
                tail = n.prev;
            }
            n.prev.next = n.next;
        }
        if (n.next != null) {
            if (n == head) {
                head = n.next;
            }
            n.next.prev = n.prev;
        }
        if (n != tail) {
            n.prev = tail;
            n.next = null;
            tail.next = n;
            tail = tail.next;
        }
        return kv.get(key).val;
    }
    
    public void put(int key, int value) {
        if (!kv.containsKey(key)) {
            if (kv.size() >= cap) {
                kv.remove(head.key);
                head = head.next;
                if (head != null) {
                    head.prev = null;
                } else {
                    tail = null;
                }
            }
            Node nn = new Node(key, value, tail, null);
            kv.put(key, nn);
            if (tail != null) {
                tail.next = nn;
                tail = tail.next;
            } else {
                tail = nn;
                head = nn;
            }
        } else {
            Node n = kv.get(key);
            n.val = value;            
            if (n.prev != null) {
                if (n == tail) {
                    tail = n.prev;
                }
                n.prev.next = n.next;
            }
            if (n.next != null) {
                if (n == head) {
                    head = n.next;
                }
                n.next.prev = n.prev;
            } 
            if (n != tail) {
                n.prev = tail;
                n.next = null;
                tail.next = n;
                tail = tail.next;
            }
        }
    }
}
