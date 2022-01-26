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
    
    public ListNode SkipZeroSum(ListNode node){
        int sum = 0;
        ListNode temp = node;
        
        while(temp != null){
            sum += temp.val;
            if(sum == 0)
                return temp.next;
            temp = temp.next;
        }
        return node;
    }
    
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy, temp = head;
        while(temp != null){
            ListNode node = SkipZeroSum(temp);
            
            if(node != temp){
                prev.next = node;
                temp = node;
            }else{
                prev = temp;
                temp = temp.next;
            }
        }
        return dummy.next;
    }
}