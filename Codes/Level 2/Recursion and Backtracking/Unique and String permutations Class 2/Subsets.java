class Solution {

    public List<Integer> getSubset(int[] nums, int x, int n){
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(((x>>i) & 1) == 1)  res.add(nums[i]);
        }
        return res;
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<Math.pow(2, n); i++){
            List<Integer> currAns = getSubset(nums, i, n);
            ans.add(currAns);
        }
        return ans;
    }
}