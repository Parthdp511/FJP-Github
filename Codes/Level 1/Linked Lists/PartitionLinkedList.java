/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode rDummy = new ListNode(-1), lDummy = new ListNode(-1), rTail = rDummy, lTail = lDummy;
        while(head != null){
            if(head.val < x){
                lTail.next = head;
                lTail = head;
                head = head.next;
            }else{
                rTail.next = head;
                rTail = head;
                head = head.next;
            }
        }
        lTail.next = rDummy.next;
        rTail.next = null;
        return lDummy.next;
    }
}