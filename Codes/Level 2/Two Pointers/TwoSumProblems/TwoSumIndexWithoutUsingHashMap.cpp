class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<pair<int, int>> v;
        for(int i=0; i<nums.size(); i++)    v.push_back({nums[i], i});
        sort(v.begin(), v.end());
        int left = 0, right = v.size() - 1;
        while(left < right){
            int currSum = v[left].first + v[right].first;
            if(currSum < target){
                left++;
            }else if(currSum > target){
                right--;
            }else{
                return {v[left].second, v[right].second};
            }
        }
        return {-1, -1};
    }
};