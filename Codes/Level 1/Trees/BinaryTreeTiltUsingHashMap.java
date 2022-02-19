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
    
    HashMap<TreeNode, Integer> m;
    int sumTilt;
    
    public int findSum(TreeNode root){
        if(root == null)    return 0;
        int leftSum = findSum(root.left), rightSum = findSum(root.right);
        int currSum = leftSum + rightSum + root.val;
        m.put(root, currSum);
        return currSum;
    }
    
    public void findTilt2(TreeNode root){
        if(root == null || root.left == null && root.right == null) return;
        int leftSum = m.getOrDefault(root.left, 0), rightSum = m.getOrDefault(root.right, 0);
        sumTilt += Math.abs(leftSum - rightSum);
        if(root.left != null)   findTilt2(root.left);
        if(root.right != null)  findTilt2(root.right);
    }
    
    public int findTilt(TreeNode root) {
        m = new HashMap<>();
        sumTilt = 0;
        findSum(root);
        findTilt2(root);
        return sumTilt;
    }
}