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
    
    public int height(TreeNode root){
        if(root == null)    return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root == null)    return true;
        int h1 = height(root.left), h2 = height(root.right);
        if(Math.abs(h1 - h2) <= 1)   return isBalanced(root.right) && isBalanced(root.left);
        return false;
    }
}   