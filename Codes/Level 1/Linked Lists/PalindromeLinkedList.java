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
    
    public ListNode findMiddle(ListNode head){
        ListNode slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if(fast == null)    //even nodes
            return prev;
        return slow;
    }
    
    public ListNode reverse(ListNode head){
        ListNode curr = head, prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        if(head == null)    return false;
        ListNode middle = findMiddle(head);
        ListNode reversed = reverse(middle.next);
        while(head != null && reversed != null){
            if(head.val != reversed.val)
                return false;
            head = head.next;
            reversed = reversed.next;
        }
        return true;
    }
}