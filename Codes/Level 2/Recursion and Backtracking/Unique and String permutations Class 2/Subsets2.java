class Solution {
    
    public List<Integer> getSubset(int[] nums, int x, int n){
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(((x >> i) & 1) == 1)   res.add(nums[i]);
        }
        return res;
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<List<Integer>, Integer> unique = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<Math.pow(2, n); i++){
            List<Integer> currAns = getSubset(nums, i, n);
            Collections.sort(currAns);
            if(unique.containsKey(currAns) == false){
                ans.add(currAns);
                unique.put(currAns, -1);
            }
        }
        return ans;
    }
}