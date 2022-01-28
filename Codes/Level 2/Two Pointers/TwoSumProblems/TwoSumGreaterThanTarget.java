public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // write your code here
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, count = 0;
        while(left < right){
            int currSum = nums[left] + nums[right];
            if(currSum > target){
                right--;
                count += right - left + 1;
            }else{
                left++;
            }
        }
        return count;
    }
}