/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast != slow) {
            slow = slow.next;
            if(fast.next == null) fast = null;
            else fast = fast.next.next;
        }
        if(fast == null) return false;
        return true;
    }
}
