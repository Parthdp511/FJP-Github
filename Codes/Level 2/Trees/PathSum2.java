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
    public void pathSum2(TreeNode root, int target, List<Integer> currAns, List<List<Integer>> ans){
        if(root == null)    return;
        if(root.left == null && root.right == null){
            if(target == root.val){
                currAns.add(root.val);
                List<Integer> temp = new ArrayList<>();
                for(Integer i : currAns)    temp.add(i);
                ans.add(temp);
                currAns.remove(currAns.size() - 1);
            }
            return;
        }
        currAns.add(root.val);
        pathSum2(root.left, target - root.val, currAns, ans);
        pathSum2(root.right, target - root.val, currAns, ans);
        currAns.remove(currAns.size() - 1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currAns = new ArrayList<>();
        if(root == null)    return ans;
        pathSum2(root, targetSum, currAns, ans);
        return ans;
    }
}