/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode _head = head;
        int jump = 0;
        while(l1 != null || l2 != null){
            int x = 0;
            int y = 0;
            if(l1 != null) {x = l1.val; l1 = l1.next;}
            if(l2 != null) {y = l2.val; l2 = l2.next;}
            int val = jump + x + y;
            if(val >= 10) {
                val = val - 10;
                jump = 1;
            }else{
                jump = 0;
            }
            ListNode node = new ListNode(val);
            head.next = node;
            head = node;
        }
        if(jump == 1){
            head.next = new ListNode(1);
        }
        return _head.next;
    }
}
