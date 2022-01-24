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
    
    public int findLength(ListNode head){
        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        return count;
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int n = findLength(head);
        k = k % n;
        if(k%n == 0)    return head;
        int toSwap = n - k - 1;
        ListNode curr = head;
        while(toSwap-- > 0){
            curr = curr.next;
        }
        ListNode newHead = curr.next;
        curr.next = null;
        curr = newHead;
        while(curr.next != null)
            curr = curr.next;
        curr.next = head;
        return newHead;
    }
}   