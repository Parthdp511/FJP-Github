class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        vector<int> pos, neg;
        for(auto num : nums){
            if(num > 0) pos.push_back(num);
            else    neg.push_back(num);
        }
        int i = 0;
        vector<int> ans;
        while(i < nums.size() / 2){
            ans.push_back(pos[i]);
            ans.push_back(neg[i]);
            i++;
        }
        return ans;
    }
};