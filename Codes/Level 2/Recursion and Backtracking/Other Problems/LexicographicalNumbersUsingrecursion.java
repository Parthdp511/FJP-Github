class Solution {
    
    List<Integer> res;
    
    public void lexicalOrder(int input, int n){
        if(input > n)   return;
        
        res.add(input);
        
        for(int i=0; i<10; i++){
            lexicalOrder(input * 10 + i, n);
        }
    }
    
    public List<Integer> lexicalOrder(int n) {
        res = new ArrayList<>();
        for(int i=1; i<10; i++){
            lexicalOrder(i, n);
        }
        return res;
    }
}