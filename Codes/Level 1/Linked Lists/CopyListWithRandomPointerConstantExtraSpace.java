/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)    return null;
        Node curr = head;
        
        // Insert duplicate nodes in between
        while(curr != null){
            Node duplicate = new Node(curr.val);
            duplicate.next = curr.next;
            curr.next = duplicate;
            curr = duplicate.next;
        }
        
        Node original = head;
        while(original != null){
            Node randomNode = original.random;
            if(original.random != null) randomNode = randomNode.next;
            original.next.random = randomNode;
            original = original.next.next;
        }
        
        original = head;
        Node res = head.next, tail = res;
        while(original != null){
            Node duplicate = original.next;
            original.next = original.next.next;
            if(duplicate.next != null)
            duplicate.next = duplicate.next.next;
            original = original.next;
        }
        return res;
    }
}