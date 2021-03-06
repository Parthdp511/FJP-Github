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
    
    public void findTreePaths(TreeNode root, String curr, List<String> ans){
        if(root == null)    return;
        if(root.left == null && root.right == null){
            ans.add(curr + root.val);
            return;
        }
        curr += root.val + "->";
        if(root.left != null)  findTreePaths(root.left, curr, ans);
        if(root.right != null)  findTreePaths(root.right, curr, ans);
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        findTreePaths(root, "", ans);
        return ans;
    }
}