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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while(q.size() > 0){
            Long k = (long)q.size(), currSum = 0*1l, currNodes = 0*1l;
            while(k-- > 0){
                TreeNode curr = q.getFirst();
                q.removeFirst();
                currSum += curr.val;
                currNodes++;
                if(curr.left != null)   q.addLast(curr.left);
                if(curr.right != null)  q.addLast(curr.right);
            }
            ans.add((double)currSum/currNodes);
        }
        return ans;
    }
}