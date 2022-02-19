/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)    return ans;
        Deque<Node> q = new ArrayDeque<>();
        q.addLast(root);
        while(q.size() > 0){
            int k = q.size();
            List<Integer> currAns = new ArrayList<>();
            while(k-- > 0){
                Node curr = q.peek();
                q.removeFirst();
                for(Node child : curr.children) q.addLast(child);
                currAns.add(curr.val);
            }
            ans.add(currAns);
        }
        return ans;
    }
}