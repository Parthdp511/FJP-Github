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
    static class Pair{
        boolean isBalanced = true;
        int height = 0;
        Pair(int h, boolean cond){
            isBalanced = cond;
            height = h;
        }
    }
    
    public Pair isBalancedHelper(TreeNode root) {
        if(root == null) return new Pair(0, true);
        
        Pair left = isBalancedHelper(root.left);
        Pair right = isBalancedHelper(root.right);
        
        Pair curr = new Pair(Math.max(left.height, right.height) + 1, (left.isBalanced && right.isBalanced && (Math.abs(left.height - right.height) <= 1)));
        return curr;
    }
    
    public boolean isBalanced(TreeNode root){
        return isBalancedHelper(root).isBalanced;
    }
}