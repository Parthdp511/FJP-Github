class Solution {
    
    public static class Node{
        private Node[] children = new Node[26];
        private boolean isEnd = false;
        
        public boolean contains(char ch){
            return this.children[ch - 'a'] != null;
        }
        
        public Node get(char ch){
            return this.children[ch - 'a'];
        }
        
        public void set(char ch){
            this.children[ch - 'a'] = new Node();
        }
        
        public boolean getEnd(){
            return this.isEnd;
        }
        
        public void setEnd(boolean end){
            this.isEnd = end;
        }
    }
    
    public void insert(String word, Node root){
        Node curr = root;
        
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            
            if(curr.contains(ch) == false)
                curr.set(ch);
            
            curr = curr.get(ch);
        }
        curr.setEnd(true);
    }
    
    String res = "";
    
    public void DFS(Node curr, String ans){
        int count = 0;
        
        if(ans.length() > res.length()){
            res = ans;
        }
        
        if(curr.getEnd() == true)
            return;
        
        char child = 'a';
        for(char ch = 'a'; ch <= 'z'; ch++){
            if(curr.contains(ch) == true){
                count++;
                child = ch;
            }
        }
        
        if(count == 1){
            DFS(curr.get(child), ans + child);
        }
    }
    
    public String longestCommonPrefix(String[] strs) {
        Node root = new Node();
        for(int i=0; i<strs.length; i++)
            insert(strs[i], root);
        
        DFS(root, "");
        
        return res;
    }
}