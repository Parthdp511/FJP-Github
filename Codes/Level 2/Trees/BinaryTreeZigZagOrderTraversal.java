/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)    return ans;
        Deque<TreeNode> q = new ArrayDeque<>();
        int counter = 0;
        q.addLast(root);
        while(q.size() > 0){
            List<Integer> currAns = new ArrayList<>();
            int k = q.size();
            while(k-- > 0){
                TreeNode curr = q.getFirst();
                q.removeFirst();
                if(curr.left != null)   q.addLast(curr.left);
                if(curr.right != null)  q.addLast(curr.right);
                currAns.add(curr.val);
            }
            ans.add(currAns);
            if(counter++%2 == 1) Collections.reverse(currAns);
        }
        return ans;
    }
}