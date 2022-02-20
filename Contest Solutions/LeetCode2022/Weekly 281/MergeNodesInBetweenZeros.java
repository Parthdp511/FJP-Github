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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1), head2 = dummy, tail = dummy;
        while(head != null){
            int currSum = 0;
            while(head != null && head.val != 0){
                currSum += head.val;
                head = head.next;
            }
            tail.next = new ListNode(currSum);
            tail = tail.next;
            head = head.next;
        }
        return dummy.next.next;
    }
}