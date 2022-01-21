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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while(temp != null){
            ListNode start = temp, end = temp.next;
            while(end != null && end.val == start.val){
                end = end.next;
            }
            start.next = end;
            temp = end;
        }
        return head;
    }
}