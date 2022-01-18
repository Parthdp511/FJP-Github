class Solution {
    
    HashMap<List<Integer>, Integer> m = new HashMap<>();
    
    public void permute(List<List<Integer>> ans, List<Integer> currAns, int[] nums, boolean[] visited){
        if(currAns.size() == nums.length){
            if(m.containsKey(currAns) == false){
                List<Integer> temp = new ArrayList<>();
                for(Integer i : currAns)
                    temp.add(i);
                ans.add(temp);
                m.put(currAns, 1);
            }
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            if(visited[i] == false){
                visited[i] = true;
                currAns.add(nums[i]);
                permute(ans, currAns, nums, visited);
                currAns.remove(currAns.size() - 1);
                visited[i] = false;
            }
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currAns = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permute(ans, currAns, nums, visited);
        return ans;
    }
}