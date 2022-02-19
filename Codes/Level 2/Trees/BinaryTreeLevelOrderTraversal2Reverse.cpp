/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        vector<vector<int>> ans;
        if(root == NULL)    return ans;
        deque<TreeNode*> q;
        q.push_back(root);
        while(q.size()){
            int k = q.size();
            vector<int> currAns;
            while(k--){
                TreeNode* curr = q.front();
                q.pop_front();
                if(curr->left != NULL)   q.push_back(curr->left);
                if(curr->right != NULL)  q.push_back(curr->right);
                currAns.push_back(curr->val);
            }
            ans.push_back(currAns);
        }
        for(int i=0; i<ans.size()/2; i++){
            vector<int> temp = ans[i];
            ans[i] = ans[ans.size() - 1 - i];
            ans[ans.size() - 1 - i] = temp;
        }
        return ans;
    }
};