/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA, temp2 = headB;
        while(temp1 != temp2){
            if(temp1 != null)
                temp1 = temp1.next;
            else
                temp1 = headB;
            if(temp2 != null)
                temp2 = temp2.next;
            else
                temp2 = headA;
        }
        return temp1;
    }
}