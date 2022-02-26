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
    
    public int sumTree(TreeNode root){
        if(root == null)    return 0;
        root.val += sumTree(root.left) + sumTree(root.right);
        return root.val;
    }
    
    long maxProd, total;
    
    public void helper(TreeNode root){
        if(root == null) return;
        
        long leftSubTree = (root.left == null) ? 0l : root.left.val;
        long leftProd = leftSubTree * (total - leftSubTree);
        long rightSubTree = (root.right == null) ? 0l : root.right.val;
        long rightProd = rightSubTree * (total - rightSubTree);
        
        maxProd = Math.max(maxProd, Math.max(leftProd, rightProd));
        
        helper(root.left);
        helper(root.right);
    }
    
    public int maxProduct(TreeNode root) {
        if(root == null)    return 0;
        total = sumTree(root);
        maxProd = 0l;
        helper(root);
        return (int)(maxProd%1000000007l);
    }
}