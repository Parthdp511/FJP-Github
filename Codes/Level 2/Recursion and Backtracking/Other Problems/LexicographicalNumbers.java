class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<String> ans = new ArrayList<>();
        for(int i = 1; i <= n; i++)
            ans.add(String.valueOf(i));
        Collections.sort(ans);
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n; i++)
            res.add(Integer.parseInt(ans.get(i)));
        return res;    
    }
}