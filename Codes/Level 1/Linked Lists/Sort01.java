/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode solve(ListNode A) {
        ListNode lDummy = new ListNode(-1), rDummy = new ListNode(-1), lTail = lDummy, rTail = rDummy;
        while(A != null){
            if(A.val == 0){
                lTail.next = A;
                A = A.next;
                lTail = lTail.next;
            }else{
                rTail.next = A;
                A = A.next;
                rTail = rTail.next;
            }
        }
        lTail.next = rDummy.next;
        rTail.next = null;
        return lDummy.next;
    }
}
