/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Queue<ListNode> queue = new LinkedList<>();
        ListNode res = head;
        
        int c = 0;
        while(head != null) {
            c++;
            if(queue.size() == n+1){
                queue.poll();
            }
            queue.offer(head);
            head = head.next;
        }
        if(c == n) {
            return res.next;
        }
        head = queue.poll();
        head.next = head.next.next;
        return res;
    }
}
