class Solution {
public:
    int countElements(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int i = 0, j = nums.size() - 1;
        while(i < nums.size() - 1 && nums[i] == nums[i+1])
            i++;
        while(j > 0 && nums[j] == nums[j-1])
            j--;
        if(nums[i] == nums[j])  return 0;
        return j - i - 1;
    }
};