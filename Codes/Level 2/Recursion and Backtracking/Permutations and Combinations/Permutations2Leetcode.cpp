class Solution {
public:
    
    map<vector<int>, int> m;
    
    void permute(vector<vector<int>> &ans, vector<int> &currAns, vector<int> &nums, vector<bool> &visited){
        if(currAns.size() == nums.size()){
            if(m.find(currAns) == m.end()){
                ans.push_back(currAns);
                m[currAns]++;
            }
            return;
        }
        
        for(int i=0; i<nums.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                currAns.push_back(nums[i]);
                permute(ans, currAns, nums, visited);
                currAns.pop_back();
                visited[i] = false;
            }
        }
    }
    
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> currAns;
        vector<bool> visited(nums.size());
        
        permute(ans, currAns, nums, visited);
        
        return ans;
    }
};