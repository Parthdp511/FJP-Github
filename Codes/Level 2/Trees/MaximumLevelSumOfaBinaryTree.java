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
    public int maxLevelSum(TreeNode root) {
        int maxSum = root.val, mLevel = 1, currLevel = 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while(q.size() > 0){
            int k = q.size(), currSum = 0;
            while(k-- > 0){
                TreeNode curr = q.getFirst();
                q.removeFirst();
                if(curr.left != null)   q.addLast(curr.left);
                if(curr.right != null)  q.addLast(curr.right);
                currSum += curr.val;
            }
            currLevel++;
            if(currSum > maxSum){
                maxSum = currSum;
                mLevel = currLevel;
            }
        }
        return mLevel;
    }
}