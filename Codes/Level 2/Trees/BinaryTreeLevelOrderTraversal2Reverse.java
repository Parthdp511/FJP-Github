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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)    return ans;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while(q.size() > 0){
            int k = q.size();
            List<Integer> currAns = new ArrayList<>();
            while(k-- > 0){
                TreeNode curr = q.getFirst();
                q.removeFirst();
                if(curr.left != null)   q.addLast(curr.left);
                if(curr.right != null)  q.addLast(curr.right);
                currAns.add(curr.val);
            }
            ans.add(currAns);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = ans.size() - 1; i >= 0; i--){
            res.add(ans.get(i));
        }
        return res;
    }
}