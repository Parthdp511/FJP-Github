class Solution {
public:
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    int twoSum6(vector<int> &nums, int target) {
        // write your code here
        sort(nums.begin(), nums.end());
        int start = 0, end = nums.size() - 1, ans = 0;
        while(start < end){
            int currSum = nums[start] + nums[end];
            if(currSum == target){
                ans++;
                int i = start + 1;
                while(i < end && nums[i] == nums[start])    i++;
                start = i;
                int j = end - 1;
                while(j > start && nums[j] == nums[end])    j--;
                end = j;
            }else if(currSum < target){
                start++;
            }else{
                end--;
            }
        }
        return ans;
    }
};