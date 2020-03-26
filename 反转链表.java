/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // ListNode res = null;

    // public ListNode reverseList(ListNode head) {
    //     ListNode tmp = reverse(head);
    //     if(tmp != null) tmp.next = null;
    //     return res;
    // }

    // private ListNode reverse(ListNode node){
    //     if(node == null) return null;
    //     ListNode tmp = reverse(node.next);
    //     if(tmp != null) tmp.next = node;
    //     else res = node;
    //     return node;
    // }


    public ListNode reverseList(ListNode head) {
        ListNode late = null;
        while(head != null){
            ListNode tmp = head.next;
            head.next = late;
            late = head;
            head = tmp;
        }
        return late;
    }
}
