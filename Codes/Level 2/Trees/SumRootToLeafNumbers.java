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
    
    int ans;
    
    public void findSum(TreeNode root, int currAns){
        if(root == null)    return;
        if(root.left == null && root.right == null){
            ans += currAns*10 + root.val;
            return;
        }
        findSum(root.left, currAns*10 + root.val);
        findSum(root.right, currAns*10 + root.val);
    }
    
    public int sumNumbers(TreeNode root) {
        ans = 0;
        findSum(root, 0);
        return ans;
    }
}