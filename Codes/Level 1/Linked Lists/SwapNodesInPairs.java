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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode newHead = head.next, prev = null;
        while(head != null && head.next != null){
            ListNode first = head, second = head.next;
            head = head.next.next;
            if(prev != null)    prev.next = second;
            prev = first;
            first.next = head;
            second.next = first;
        }
        return newHead;
    }
}