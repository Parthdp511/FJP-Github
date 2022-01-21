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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1), tail = dummy;
        while(l1 != null && l2 != null){
            int currAns = l1.val + l2.val + carry;
            ListNode curr = new ListNode(currAns % 10);
            carry = currAns / 10;
            tail.next = curr;
            tail = curr;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int currAns = l1.val + carry;
            ListNode curr = new ListNode(currAns % 10);
            carry = currAns / 10;
            tail.next = curr;
            tail = curr;
            l1 = l1.next;
        }
        while(l2 != null){
            int currAns = l2.val + carry;
            ListNode curr = new ListNode(currAns % 10);
            carry = currAns / 10;
            tail.next = curr;
            tail = curr;
            l2 = l2.next;
        }
        if(carry != 0){
            ListNode curr = new ListNode(carry);
            tail.next = curr;
        }
        return dummy.next;
    }
}