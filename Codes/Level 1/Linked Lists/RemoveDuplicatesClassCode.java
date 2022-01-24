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
        ListNode dummy = new ListNode(-1), tail = dummy;
        while(head != null){
            tail.next = head;
            tail = head;
            while(head.next != null && head.next.val == head.val){
                head = head.next;
            }
            head = head.next;
        }
        tail.next = null;
        return dummy.next;
    }
}