class Solution {
public:
    
    map<vector<int>, int> m;
    
    void combine(vector<int> &candidates, vector<vector<int>> &ans, vector<int> currAns, int currSum, int target){
        if(currSum == target){
            sort(currAns.begin(), currAns.end());
            if(m.find(currAns) == m.end()){
                ans.push_back(currAns);
                m[currAns]++;
            }
            return;
        }
        for(int i=0; i<candidates.size(); i++){
            if(currSum + candidates[i] <= target){
                currAns.push_back(candidates[i]);
                combine(candidates, ans, currAns, currSum + candidates[i], target);
                currAns.pop_back();
            }
        }
    }
    
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<vector<int>> ans;
        vector<int> currAns;
        combine(candidates, ans, currAns, 0, target);
        return ans;
    }
};