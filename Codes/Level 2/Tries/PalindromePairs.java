import java.util.*;

class Solution {

    public static class Node{
        Node[] children = new Node[26];
        int isEnd = -1;

        public boolean contains(char ch){
            return children[ch - 'a'] != null;
        }

        public void set(char ch){
            children[ch - 'a'] = new Node();
        }

        public Node get(char ch){
            return children[ch - 'a'];
        }

        public int getEnd(){
            return isEnd;
        }

        public void setEnd(int i){
            isEnd = i;
        }
    }

    int maxLength = 0;
    Node root;

    public List<Integer> checkPalin(String word, )

    public List<List<Integer>> palindromePairs(String[] words) {
        Node root = new Node();
        for(int i=0; i<words.length; i++){
            String word = words[i];
            Node curr = root;
            for(int j=0; j<word.length(); j++){
                char ch = word.charAt(j);

                if(curr.contains(ch) == false)
                    curr.set(ch);
                
                curr = curr.get(ch);
            }
            curr.setEnd(i);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<words.length(); i++){
            
        }

        return res;
    }
}