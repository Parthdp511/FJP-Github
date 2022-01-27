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
    
    public Node makeNew(Node head, HashMap<Node, Node> hm){
        Node dummy = new Node(-1), tail = dummy;
        while(head != null){
            Node curr = new Node(head.val);
            hm.put(head, curr);
            tail.next = curr;
            tail = curr;
            head = head.next;
        }
        return dummy.next;
    }
    
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hm = new HashMap<>();
        Node newHead = makeNew(head, hm);
        while(head != null){
            hm.get(head).random = hm.get(head.random);
            head = head.next;
        }
        return newHead;
    }
}