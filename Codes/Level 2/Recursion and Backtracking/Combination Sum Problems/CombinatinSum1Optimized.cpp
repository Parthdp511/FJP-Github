class Solution {
public:
    
    void combine(vector<vector<int>> &ans, vector<int> currAns, vector<int> &candidates, int target, int currSum, int currIndex){
        if(currSum == target){
            ans.push_back(currAns);
            return;
        }
        for(int i=currIndex; i<candidates.size(); i++){
            if(currSum + candidates[i] <= target){
                currAns.push_back(candidates[i]);
                combine(ans, currAns, candidates, target, currSum + candidates[i], i);
                currAns.pop_back();
            }
        }
    }
    
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<vector<int>> ans;
        vector<int> currAns;
        combine(ans, currAns, candidates, target, 0, 0);
        return ans;
    }
};