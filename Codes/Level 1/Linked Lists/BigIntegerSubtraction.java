// { Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.subLinkedList(first, second);
            printList(res);
        }
    }
}
// } Driver Code Ends


/* Structure of Linked list node

class Node
{
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}

*/

class Solution
{
    static Node subLinkedList(Node l1, Node l2)
    {
        // code here
        l1 = skipLeadingZeros(l1);
        l2 = skipLeadingZeros(l2);
        
        int s1 = size(l1);
        int s2 = size(l2);
        
        if(s1 < s2) return subLinkedList(l2, l1);
        else if(s1 == s2){
            if(isLarger(l1, l2) < 0)
                return subLinkedList(l2, l1);
            else if(isLarger(l1, l2) == 0)
                return new Node(0);
        }
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        Node dummy = new Node(-1), tail = dummy;
        while(l2 != null && l1 != null){
            if(l1.data < l2.data){
                l1.data += 10;
                adjustBorrow(l1.next);
            }
            tail.next = new Node(l1.data - l2.data);
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        tail.next = l1;
        
        dummy = reverse(dummy.next);
        dummy = skipLeadingZeros(dummy);
        
        return dummy == null ? new Node(0) : dummy;
    }
    
    public static int isLarger(Node head1, Node head2){
        while(head1 != null && head2 != null && head1.data == head2.data){
            head1 = head1.next;
            head2 = head2.next;
        }
        if(head1 == null && head2 == null)  return 0;
        if(head1.data > head2.data) return 1;
        return -1;
    }
    
    public static int size(Node head){
        int s = 0;
        while(head != null){
            s++;
            head = head.next;
        }
        return s;
    }
    
    public static Node reverse(Node head){
        if(head == null || head.next == null)   return head;
        Node prev = null, curr = head;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public static void adjustBorrow(Node node){
        while(node != null && node.data == 0){
            node.data = 9;
            node = node.next;
        }
        if(node != null)
        node.data--;
    }
    
    public static Node skipLeadingZeros(Node head){
        while(head != null && head.data == 0)
            head = head.next;
        return head;
    }
}