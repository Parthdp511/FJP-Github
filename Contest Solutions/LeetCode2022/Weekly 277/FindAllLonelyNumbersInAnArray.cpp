class Solution {
public:
    vector<int> findLonely(vector<int>& nums) {
        vector<int> ans;
        map<int, int> m;
        for(auto num : nums)    m[num]++;
        for(auto num : nums){
            if(m[num] == 1 && m.find(num - 1) == m.end() && m.find(num + 1) == m.end())
                ans.push_back(num);
        }
        return ans;
    }
};