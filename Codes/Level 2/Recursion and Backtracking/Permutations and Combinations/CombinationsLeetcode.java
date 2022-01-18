class Solution {
    
    public void combine(List<List<Integer>> combinations, List<Integer> currCombination, int ipsf, int currBox, int k, int n){
        if(currBox == n){
            if(currCombination.size() == k){
                // deep copy
                List<Integer> temp = new ArrayList<>();
                for(Integer i : currCombination)
                    temp.add(i);
                combinations.add(temp);
            }
            return;
        }
        
        currCombination.add(ipsf + 1);
        
        combine(combinations, currCombination, ipsf + 1, currBox + 1, k, n);
        
        currCombination.remove(currCombination.size() - 1);
        
        combine(combinations, currCombination, ipsf + 1, currBox + 1, k, n);
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> currCombination = new ArrayList<>();
        
        combine(combinations, currCombination, 0, 0, k, n);
        
        return combinations;
    }
}