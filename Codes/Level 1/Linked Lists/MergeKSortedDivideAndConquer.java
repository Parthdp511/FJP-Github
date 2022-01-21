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
    
    ListNode merge2SortedLists(ListNode head1, ListNode head2) {
     // This is a "method-only" submission. 
     // You only need to complete this method
     if(head1 == null)  return head2;
     if(head2 == null)  return head1;
     ListNode dummy = new ListNode(-1), tail = dummy;
     while(head1 != null && head2 != null){
         if(head1.val < head2.val){
             tail.next = head1;
             head1 = head1.next;
         }else{
             tail.next = head2;
             head2 = head2.next;
         }
         tail = tail.next;
     }
     if(head1 != null)  tail.next = head1;
     if(head2 != null)  tail.next = head2;
     return dummy.next;
   } 
    
    public ListNode helper(ListNode[] lists, int left, int right){
        if(left > right)    return null;
        if(left==right) return lists[left];
        int mid = left + (right - left)/2;
        ListNode leftMerged = helper(lists, left, mid);
        ListNode rightMerged = helper(lists, mid + 1, right);
        return merge2SortedLists(leftMerged, rightMerged);
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        return helper(lists, 0, lists.length - 1);
    }
}