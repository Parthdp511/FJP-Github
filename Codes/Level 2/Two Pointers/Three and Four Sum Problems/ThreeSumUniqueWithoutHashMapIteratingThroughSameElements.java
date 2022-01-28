class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i < nums.length - 1; i++){
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int currSum = nums[i] + nums[left] + nums[right];
                if(currSum == 0){
                    List<Integer> currAns = new ArrayList<>();
                    currAns.add(nums[i]); currAns.add(nums[left]); currAns.add(nums[right]);
                    res.add(currAns);
                    while(left < nums.length - 1 && nums[left] == nums[left + 1])   left++;
                    left++;
                    while(right > 0 && nums[right] == nums[right - 1])  right--;
                    right--;
                }else if(currSum < 0){
                    left++;
                }else{
                    right--;
                }
                while(i < nums.length - 1 && nums[i] == nums[i + 1])    i++;
            }
        }
        return res;
    }
}