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
    
    public int minNode(ListNode[] lists){
        int min = Integer.MAX_VALUE, index = -1;
        ListNode curr = lists[0];
        for(int i=0; i<lists.length; i++){
            if(lists[i] != null && lists[i].val < min){
                curr = lists[i];
                min = lists[i].val;
                index = i;
            }
        }
        return index;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy, tail = dummy;
        
        while(true){
            int min = minNode(lists);
            if(min == -1) break;
            
            tail.next = lists[min];
            lists[min] = lists[min].next;
            tail = tail.next;
        }
        return dummy.next;
    }
}