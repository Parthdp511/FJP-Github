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

    public int diameter(TreeNode root){
        if(root == null)    return 0;
        int h1 = diameter(root.left), h2 = diameter(root.right);
        ans = Math.max(ans, 1 + h1 + h2);
        return Math.max(h1, h2) + 1;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        diameter(root);
        return ans - 1;
    }
}

// Without global variable use
class Solution {
    public int diameter(TreeNode root, int[] ans){
        if(root == null)    return 0;
        int h1 = diameter(root.left, ans), h2 = diameter(root.right, ans);
        ans[0] = Math.max(ans[0], 1 + h1 + h2);
        return Math.max(h1, h2) + 1;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = new int[1];
        diameter(root, ans);
        return ans[0] - 1;
    }
}