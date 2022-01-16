class StreamChecker {
    
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

        public boolean getEnd(){
            return isEnd;
        }

        public void setEnd(){
            isEnd = true;
        }
    }

    int maxLength = 0;
    Node root;

    public StreamChecker(String[] words) {
        root = new Node();
        for(String word : words){
            maxLength = Math.max(maxLength, word.length());
            Node curr = root;
            for(int i=word.length() - 1; i >= 0; i--){
                char ch = word.charAt(i);

                if(curr.contains(ch) == false)
                    curr.set(ch);
                
                curr = curr.get(ch);
            }
            curr.setEnd();
        }
    }

    StringBuilder sb = new StringBuilder("");
    
    public boolean query(char letter) {
        sb.append(letter);

        Node curr = root;
        int counter = 0;
        for(int i = sb.length() - 1; i>=0 && counter <= maxLength; i--){
            if(curr.getEnd() == true)
                return true;
            
            char ch = sb.charAt(i);
            if(curr.contains(ch) == false)
                return false;

            curr = curr.get(ch);
            counter++;
        }
        
        if(curr.getEnd() == true)
            return true;

        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */