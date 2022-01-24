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
    
    public void display(ListNode head){
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
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
    
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1), tail = dummy;
        while(head1 != null && head2 != null){
            tail.next = head1;
            head1 = head1.next;
            tail = tail.next;
            tail.next = head2;
            head2 = head2.next;
            tail = tail.next;
        }
        if(head1 != null)   tail.next = head1;
        if(head2 != null)   tail.next = head2;
        return dummy.next;
    }
    
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode prev = null, slow = head, fast = head;
        while(fast != null && fast.next != null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = null;
        ListNode newHead = reverse(slow);
        head = merge(head, newHead);
    }
}