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
    
    public String search(Node curr, String word){
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            
            if(curr.getEnd() == true){
                return word.substring(0, i);
            }
            
            if(curr.contains(ch) == false)
                return word;
            
            curr = curr.get(ch);
        }
        return word;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        Node root = new Node();
        for(String s:dictionary){
            insert(s, root);
        }
        
        sentence = sentence.trim();
        String[] words = sentence.split(" ");
        
        StringBuilder ans = new StringBuilder("");
        
        for(int i=0; i<words.length; i++){
            ans.append(search(root, words[i]));
            if(i != words.length - 1)   ans.append(" ");
        }
        return ans.toString();
    }
}