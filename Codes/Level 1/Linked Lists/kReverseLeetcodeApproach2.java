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
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        int len1 = findLength(head);
        
        ListNode temp = head;
        int x = k - 1;
        
        // Moving the kth node as that will be out resultant headnode
        while(x > 0){
            temp = temp.next;
            x--;
        }
        
        ListNode newhead = temp, curr = head, first = head, prev = null, next1 = null;
        while(len1 - k >= 0){
            
            // Reversing the LL the same pointer iterative way
            for(int i = 0; i < k; i++){
                next1 = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next1;
            }
            len1 = len1 - k;
            
            // If we have reached the final group, we will connect the left nodes
            if(len1 - k < 0)
                first.next = next1;
            else{
                x = k - 1;
                temp = next1;
                while(x > 0){
                    temp = temp.next;
                    x--;
                }
                first.next = temp;
                first = next1;
                prev = null;
            }
        }
        return newhead;
    }
}