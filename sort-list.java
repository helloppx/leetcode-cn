/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
// 堆排序    
//         if(head == null || head.next == null) return head;
//         PriorityQueue<ListNode> q = new PriorityQueue<ListNode>((x, y) -> x.val - y.val);
//         while(head != null){
//             q.add(head);
//             head = head.next;
//         }
        
//         head = q.poll();
//         ListNode res = head;
//         while(q.size() != 0){
//             head.next = q.poll();
//             head = head.next;
//         }
//         head.next = null;
//         return res;
        
        
        //归并排序
        if(head == null || head.next == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre_slow = head;
        
        //指针，跨一步，跨两步，来达到分割list的目的
        while(fast != null && fast.next != null) {
            pre_slow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        pre_slow.next = null;
        ListNode a = sortList(head);
        ListNode b = sortList(slow);
        return merge(a, b);
    }
    
    private ListNode merge(ListNode a, ListNode b){
        ListNode head = new ListNode(0);
        ListNode res = head;
        while(a != null && b != null){
            if(a.val < b.val){
                head.next = a;
                a = a.next;
                head = head.next;
                
            }else{
                head.next = b;
                b = b.next;
                head = head.next;
            }
        }
        while(a != null){
            head.next = a;
            a = a.next;
            head = head.next;
        }
        while(b != null){
            head.next = b;
            b = b.next;
            head = head.next;
        }
        return res.next;
    }
}
