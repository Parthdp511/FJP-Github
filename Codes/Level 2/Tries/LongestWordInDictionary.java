class Solution {
    public static class Node{
        private Node[] children = new Node[26];
        private boolean isEnd = false;
        
        public Node get(char ch){
            return children[ch - 'a'];
        }
        
        public boolean getEnd(){
            return isEnd;    
        }
        
        public void setEnd(){
            isEnd = true;
        }
        
        public void add(char ch){
            children[ch - 'a'] = new Node();
        }
        
        public boolean contains(char ch){
            return (children[ch - 'a'] != null);
        }
    }
    
    public void insert(String word, Node root) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(curr.contains(ch) == false)
                curr.add(ch);
            curr = curr.get(ch);
        }
        curr.setEnd();
    }
    String res = "";
    
    public void DFS(Node root, String ansSoFar){
        if(root.isEnd == false) return;
        if(ansSoFar.length() > res.length()){
            res = ansSoFar;
        }
        
        for(char ch = 'a'; ch <= 'z'; ch++){
            if(root.contains(ch) == true)
                DFS(root.get(ch), ansSoFar + ch);
        }
    }
    
    public String longestWord(String[] words) {
        Node root = new Node();
        for(int i=0; i<words.length; i++)
            insert(words[i], root);
        
        root.isEnd = true;
        DFS(root, "");
        
        return res;
    }
}