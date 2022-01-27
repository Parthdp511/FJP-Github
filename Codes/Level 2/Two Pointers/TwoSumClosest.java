public class Solution {
    /**
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // write your code here
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1, diff = Integer.MAX_VALUE;
        while(start < end){
            int currSum = nums[start] + nums[end];
            diff = Math.min(diff, Math.abs(currSum - target));
            if(currSum < target)    start++;
            else                    end--;
        }
        return diff;
    }
}