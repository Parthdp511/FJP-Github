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
    
    public int getSize(ListNode head){
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
        
        ListNode currDummy = new ListNode(-1), curr = currDummy;
        int size = getSize(head);
        
        while(size > 0){
            if(size >= k){
                ListNode prevDummy = new ListNode(-1), prev = prevDummy;
                
                for(int i=0; i<k; i++){
                    ListNode temp = head;
                    head = head.next;
                    temp.next = prevDummy.next;     // Adding in front of prev
                    prevDummy.next = temp;
                }
                curr.next = prevDummy.next;
                while(curr.next!=null)  curr = curr.next;
                size -= k;
            }else{
                curr.next = head;
                break;
            }
        }
        return currDummy.next;
    }
}