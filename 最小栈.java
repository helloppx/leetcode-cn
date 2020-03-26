class MinStack {
    static class Node{
        Node next;
        Node pre;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }

    Node head = new Node(0);
    Node pointer = head;
    Integer min = null;

    /** initialize your data structure here. */
    public MinStack() {

    }
    
    public void push(int v) {
        Node x = new Node(v);
        pointer.next = x;
        x.pre = pointer;
        pointer = x;
        
        if(min == null || min > v) min = v;
    }
    
    public void pop() {
        if(pointer != head) {
            Node x = pointer.pre;
            pointer.pre = null;
            pointer = x;
            pointer.next = null;
        }
        min = null;
        Node tmp = head.next;
        while(tmp != null){
            if(min == null || min > tmp.val) min = tmp.val;
            tmp = tmp.next;
        }
    }
    
    public int top() {
        return pointer.val;
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
