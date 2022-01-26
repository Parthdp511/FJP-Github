class Solution {
    
    HashMap<List<Integer>, Integer> unique;
    
    public void combine(int[] candidates, int target, List<Integer> currAns, List<List<Integer>> ans){
        if(target == 0){
            List<Integer> temp = new ArrayList<>();
            for(Integer i : currAns)    temp.add(i);
            Collections.sort(temp);
            if(unique.containsKey(temp) == false){
                ans.add(temp);
                unique.put(temp, 1);
            }
            return;
        }
        
        for(int i=0; i<candidates.length; i++){
            if(target - candidates[i] >= 0){
                currAns.add(candidates[i]);
                combine(candidates, target - candidates[i], currAns, ans);
                currAns.remove(currAns.size() - 1);
            }
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currAns = new ArrayList<>();
        unique = new HashMap<>();
        combine(candidates, target, currAns, ans);
        return ans;
    }
}