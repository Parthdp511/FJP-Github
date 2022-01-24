import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode reverse(ListNode head){
        ListNode curr = head, prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void unfold(ListNode head) {
        ListNode dummy1 = new ListNode(-1), dummy2 = new ListNode(-1);
        ListNode tail1 = dummy1, tail2 = dummy2;
        while(head != null){
            tail1.next = head;
            head = head.next;
            tail1 = tail1.next;
            if(head != null){
                tail2.next = head;
                head = head.next;
                tail2 = tail2.next;
            }
        }
        tail1.next = null;
        tail2.next = null;
        tail1.next = null;
        ListNode reversed = reverse(dummy2.next);
        tail1.next = reversed;
        head = dummy1.next;
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }
}