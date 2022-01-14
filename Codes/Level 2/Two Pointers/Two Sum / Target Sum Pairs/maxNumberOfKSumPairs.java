class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        
        int ans = 0, start = 0, end = nums.length - 1;
        while(start < end){
            int currSum = nums[start] + nums[end];
            if(currSum == k){
                ans++;
                start++;
                end--;
            }else if(currSum < k){
                start++;
            }else{
                end--;
            }
        }
        return ans;
    }
}