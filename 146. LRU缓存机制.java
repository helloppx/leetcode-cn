class LRUCache {
    int[] key = null;
    int[] value = null;
    int size = 0;

    public LRUCache(int capacity) {
        key = new int[capacity];
        value = new int[capacity];
    }
    
    public int get(int _key) {
        int i = find(_key);
        if(i != -1) {
            int res = value[i];
            toHead(i);
            return res;
        }
        return -1;
    }

    private int find(int _key) {
        for(int i = 0; i < size; i++) {
            if(key[i] == _key) {
               return i;
            }
        }
        return -1;
    }
    
    public void put(int _key, int _value) {
        int flag = find(_key);
        if(flag == -1){
            if(size == key.length){
                toTail(size - 1);
            }else{
                toTail(size);
                size++;
            }
        }else{
            toHead(flag);
        }
        key[0] = _key;
        value[0] = _value;
    }

    private void toTail(int j) {
        for(; j > 0; j--) {
            key[j] = key[j - 1];
            value[j] = value[j - 1];
        }
    }

    private void toHead(int i) {
        int k = key[i];
        int v = value[i];

        while(i > 0) {
            key[i] = key[i - 1];
            value[i] = value[i - 1];
            i--;
        }
        key[0] = k;
        value[0] = v;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


class LRUCache {
    private static class Node {
        public int key;
        public int value;
        public Node pre;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity = 0;
    private int size = 0;
    private Node head = null;
    private Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node res = map.get(key);
        if(res == null) return -1;
        moveToHead(res);
        return head.value;
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        if(head == null) {
            size = 1;
            head = node;
            head.next = head;
            head.pre = head;
            map.put(key, head);
            return;
        }
        int x = get(key);
        if(x != -1) {
            head.value = value;
            return;
        }
        if(size == capacity){
            map.remove(head.pre.key);
            head.pre.key = key;
            head.pre.value = value;
            head = head.pre;
            map.put(key, head);
        }else{
            size++;
            node.pre = head.pre;
            head.pre.next = node;

            node.next = head;
            head.pre = node;

            head = node;
            map.put(key, head);
        }
    }

    private void moveToHead(Node curr) {
        if(curr == head) return;
        curr.pre.next = curr.next;
        curr.next.pre = curr.pre;
 
        curr.pre = head.pre;
        head.pre.next = curr;

        curr.next = head;
        head.pre = curr;

        head = curr;
    }
}
 
 
 
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
