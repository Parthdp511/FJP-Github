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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        if(root == NULL)    return ans;
        deque<TreeNode*> q;
        int counter = 0;
        q.push_back(root);
        while(q.size()){
            int k = q.size();
            vector<int> currAns;
            while(k--){
                TreeNode* curr = q.front();
                q.pop_front();
                if(curr->left)  q.push_back(curr->left);
                if(curr->right) q.push_back(curr->right);
                currAns.push_back(curr->val);
            }
            if(counter++ % 2)   reverse(currAns.begin(), currAns.end());
            ans.push_back(currAns);
        }
        return ans;
    }
};