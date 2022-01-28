class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashMap<List<Integer>, Integer> unique = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i < nums.length - 1; i++){
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int currSum = nums[i] + nums[left] + nums[right];
                if(currSum == 0){
                    List<Integer> currAns = new ArrayList<>();
                    currAns.add(nums[i]); currAns.add(nums[left]); currAns.add(nums[right]);
                    if(unique.containsKey(currAns) == false){
                        unique.put(currAns, 1);
                        res.add(currAns);
                    }
                    left++;
                    right--;
                }else if(currSum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }
}