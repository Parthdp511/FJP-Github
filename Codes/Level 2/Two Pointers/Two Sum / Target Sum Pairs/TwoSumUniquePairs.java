public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1, ans = 0;
        while(start < end){
            int currSum = nums[start] + nums[end];
            if(currSum == target){
                ans++;
                int i = start, j = end;
                while(i < end && nums[i] == nums[start]) i++;
                start = i;
                while(j > start && nums[j] == nums[end]) j--;
                end = j;
            }else if(currSum < target){
                start++;
            }else{
                end--;
            }
        }
        return ans;
    }
}