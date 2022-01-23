class Solution {
public:
    
    void combine(vector<pair<int, int>> &v, vector<vector<int>> &ans, vector<int> currAns, int target, int currIdx){
        if(target == 0){
            ans.push_back(currAns);
            return;
        }
        if(currIdx >= v.size()) return;
        int currCoin = v[currIdx].first, currFreq = v[currIdx].second;
        for(int i=1; i<= currFreq; i++){
            currAns.push_back(currCoin);
            if(target - i * currCoin >= 0){
                combine(v, ans, currAns, target - i*currCoin, currIdx + 1);
            }
        }
        for(int i=1; i<= currFreq; i++)
            currAns.pop_back();
        combine(v, ans, currAns, target, currIdx + 1);
    }
    
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<pair<int, int>> v;
        sort(candidates.begin(), candidates.end());
        for(int i=0; i<candidates.size(); i++){
            int num = candidates[i];
            int freq = 1;
            while(i<candidates.size() - 1 && candidates[i+1] == candidates[i]){
                i++;
                freq++;
            }
            v.push_back({candidates[i], freq});
        }
        for(auto i:v)   cout<<i.first<<" "<<i.second<<"\n";
        vector<vector<int>> ans;
        vector<int> currAns;
        combine(v, ans, currAns, target, 0);
        return ans;
    }
};