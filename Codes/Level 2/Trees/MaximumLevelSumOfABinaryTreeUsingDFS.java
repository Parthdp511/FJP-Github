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
    
    public void findSum(long[] arr, TreeNode root, int level){
        if(root == null)    return;
        arr[level] += root.val * 1l;
        if(root.left != null)   findSum(arr, root.left, level + 1);
        if(root.right != null)  findSum(arr, root.right, level + 1);
    }
    
    public int maxLevelSum(TreeNode root) {
        long[] arr = new long[height(root)];
        findSum(arr, root, 0);
        int ans = 0;
        for(int i=0; i<arr.length; i++){
            ans = arr[i] > arr[ans] ? i : ans;
        }
        return ans + 1;
    }
}