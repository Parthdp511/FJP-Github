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
    
    public int findCurr(TreeNode root, int target){
        if(root == null)    return 0;
        return findCurr(root.left, target - root.val) + findCurr(root.right, target - root.val) + (root.val == target ? 1 : 0);
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)    return 0;
        return findCurr(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }
}