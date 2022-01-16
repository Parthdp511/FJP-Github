import java.util.*;

class Solution {

    public static class Node{
        Node[] children = new Node[26];
        boolean isEnd = false;
        
        public boolean contains(char ch){
            return children[ch - 'a'] != null;
        }
        
        public void set(char ch){
            children[ch - 'a'] = new Node();
        }
        
        public Node get(char ch){
            return children[ch - 'a'];
        }
        
        public void setEnd(){
            isEnd = true;
        }
        
        public boolean getEnd(){
            return isEnd;
        }
    }

    Node root;

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root = new Node();
        for(String word : products){
            Node curr = root;
            for(int i=0; i<word.length(); i++){
                char ch = word.charAt(i);

                if(curr.contains(ch) == false)
                    curr.set(ch);
                
                curr = curr.get(ch);
            }
            curr.setEnd();
        }



        List<List<String>> res = new ArrayList<>();
        for(int i=0; i<searchWord.length(); i++){
            char ch = searchWord.charAt(i);
            root = root.get(ch);
            if(root.contains(ch) == true){
                List<String> ans = new ArrayList<>();
                DFS(root, searchWord.substring(0, i + 1), ans, 3);
                res.add(ans);
            }else{
                break;
            }
        }

        while(res.size() < searchWord.length()){
            res.add(new ArrayList<>());
        }
        return res;
    }
}