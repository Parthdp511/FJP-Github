/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Deque<Node> q = new ArrayDeque<>();
        if(root == null)    return root;
        q.addLast(root);
        while(q.size() > 0){
            int k = q.size();
            Node curr = null, prev = null;
            while(k-- > 0){
                curr = q.getFirst();
                q.removeFirst();
                if(prev != null)    prev.next = curr;
                prev = curr;
                if(curr.left != null)   q.addLast(curr.left);
                if(curr.right != null)  q.addLast(curr.right);
            }
        }
        return root;
    }
}