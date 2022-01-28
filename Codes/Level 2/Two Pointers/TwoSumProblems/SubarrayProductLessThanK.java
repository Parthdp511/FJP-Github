class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1)  return 0;
        int left = 0, right = 0;
        int ans = 0, prod = 1;
        while(right < nums.length){
            prod *= nums[right];
            right++;
            
            while(left <= right && prod >= k){
                prod /= nums[left];
                left++;
            }
            ans += (right - left);
        }
        return ans;
    }
}