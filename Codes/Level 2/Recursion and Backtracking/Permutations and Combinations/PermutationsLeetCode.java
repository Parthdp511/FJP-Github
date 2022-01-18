class Solution {
    
    public void premuteHelper(int[] nums, List<List<Integer>> ans, List<Integer> currAns, boolean[] visited){
        if(currAns.size() == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(Integer i : currAns){
                temp.add(i);
            }
            ans.add(temp);
            return;
        }
        
        for(int i = 0; i<nums.length; i++){
            if(visited[i] == false){
                visited[i] = true;
                currAns.add(nums[i]);
                premuteHelper(nums, ans, currAns, visited);
                visited[i] = false;
                currAns.remove(currAns.size() - 1);
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currAns = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        
        premuteHelper(nums, ans, currAns, visited);
        
        return ans;
    }
}