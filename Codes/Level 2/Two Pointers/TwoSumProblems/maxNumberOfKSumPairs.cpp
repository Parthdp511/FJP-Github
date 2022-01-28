class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());
        int start = 0, end = nums.size() - 1, ans = 0;
        while(start < end){
            int currSum = nums[start] + nums[end];
            if(currSum == k){
                ans++, start++, end--;
            }else if(currSum < k){
                start++;
            }else{
                end--;
            }
        }
        return ans;
    }
};