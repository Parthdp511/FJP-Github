class MapSum {
    
    public static class Node{
        private Node[] children = new Node[26];
        private int val = 0;
        private int preSum = 0;
        
        public Node get(char ch){
            return children[ch - 'a'];
        }
        
        public boolean contains(char ch){
            return children[ch - 'a'] != null;
        }
        
        public void add(char ch){
            children[ch - 'a'] = new Node();
        }
        
        public int getVal(){
            return this.val;
        }
        
        public void setVal(int val){
            this.val = val;
        }
        
        public int getPref(){
            return this.preSum;
        }
        
        public void setPref(int val){
            this.preSum = val;
        }
    }
    
    Node root;
    
    public MapSum() {
        root = new Node();    
    }
    
    public int Search(String word){
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(curr.contains(ch) == false){
                return 0;
            }
            curr = curr.get(ch);
        }
        return curr.getVal();
    }
    
    public void insert(String key, int val) {
        int oldVal = Search(key);
        
        Node curr = root;
        
        for(int i=0; i<key.length(); i++){
            curr.setPref(curr.getPref() + (val - oldVal));
            
            char ch = key.charAt(i);
            
            if(curr.contains(ch) == false)
                curr.add(ch);
            
            curr = curr.get(ch);
        }
        
        curr.setPref(curr.getPref() + (val - oldVal));
        curr.setVal(val);
    }
    
    public int sum(String prefix) {
        Node curr = root;
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            
            if(curr.contains(ch) == false)
                return 0;
            
            curr = curr.get(ch);
        }
        return curr.getPref();
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */