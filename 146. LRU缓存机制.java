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
