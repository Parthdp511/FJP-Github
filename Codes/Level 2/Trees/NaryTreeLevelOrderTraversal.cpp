/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        if(root == NULL)    return {};
        vector<vector<int>> ans;
        deque<Node*> q;
        q.push_back(root);
        while(q.size()){
            int k = q.size();
            vector<int> currAns;
            while(k--){
                Node* curr = q.front();
                q.pop_front();
                for(auto child : curr->children) q.push_back(child);
                currAns.push_back(curr->val);
            }
            ans.push_back(currAns);
        }
        return ans;
    }
};