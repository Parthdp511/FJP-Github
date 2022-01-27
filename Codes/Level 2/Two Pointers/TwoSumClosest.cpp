class Solution {
public:
    /**
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    int twoSumClosest(vector<int> &nums, int target) {
        // write your code here
        sort(nums.begin(), nums.end());
        int start = 0, end = nums.size() - 1, diff = INT_MAX;
        while(start < end){
            int currSum = nums[start] + nums[end];
            diff = min(diff, abs(currSum - target));
            if(currSum == target)   return 0;
            else if(currSum < target)   start++;
            else                        end--;
        }
        return diff;
    }
};