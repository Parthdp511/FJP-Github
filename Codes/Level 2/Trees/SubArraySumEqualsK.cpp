class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int n = nums.size(), ans = 0;
        map<int, int> m;
        m[0] = 1;
        vector<int> preSum(n, nums[0]);
        for(int i=1; i<n; i++)  preSum[i] = preSum[i - 1] + nums[i];
        for(int i=0; i<n; i++){
            if(m.find(preSum[i] - k) != m.end()){
                ans += m[preSum[i] - k];
            }
            m[preSum[i]]++;
        }
        return ans;
    }
};