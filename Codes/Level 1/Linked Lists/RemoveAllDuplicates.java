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
        ListNode dummy = new ListNode(-1), temp = head, tail = dummy;
        while(temp != null){
            int freq = 1;
            while(temp.next != null && temp.next.val == temp.val){
                temp = temp.next;
                freq++;
            }
            if(freq == 1){
                tail.next = new ListNode(temp.val);
                tail = tail.next;
            }
            temp = temp.next;
        }
        return dummy.next;
    }
}