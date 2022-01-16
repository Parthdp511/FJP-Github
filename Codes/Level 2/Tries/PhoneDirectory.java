// Partially accepted code 163/ 205

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    
    public static class Node{
        Node[] children = new Node[26];
        boolean isEnd = false;
        
        public void setChild(char ch){
            children[ch - 'a'] = new Node();
        }
        
        public Node getChild(char ch){
            return children[ch - 'a'];
        }
        
        public boolean contains(char ch){
            return children[ch - 'a'] != null;
        }
        
        public void setEnd(){
            isEnd = true;
        }
        
        public boolean getEnd(){
            return isEnd;
        }
    }
    
    static Node root;
    static ArrayList<ArrayList<String>> ans;
    static ArrayList<String> currAns;
    
    public static void insert(Node curr, String word){
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            
            if(curr.contains(ch) == false){
                curr.setChild(ch);
            }
            
            curr = curr.getChild(ch);
        }
        curr.setEnd();
    }
    
    public static void printAllContacts(Node curr, String word){
        if(curr.getEnd() == true){
           currAns.add(word);
        }
        
        for(char c = 'a'; c <= 'z'; c++){
            if(curr.contains(c) == true){
                printAllContacts(curr.getChild(c), word + c);
            }
        }
    }
    
    public static void printContacts(String prefix, Node curr){
        currAns = new ArrayList<>();
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            
            if(curr.contains(ch) == false){
                currAns.add("0");
                ans.add(currAns);
                return;
            }
            
            curr = curr.getChild(ch);
        }
        
        if(curr.getEnd() == true){
            currAns.add(prefix);
            ans.add(currAns);
        }
        printAllContacts(curr, prefix);
        ans.add(currAns);
    }
    
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        // code here
        root = new Node();
        for(String word : contact){
            insert(root, word);
        }
        
        StringBuilder sb = new StringBuilder("");
        ans = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            sb.append(s.charAt(i));
            
            printContacts(sb.toString(), root);
        }
        
        return ans;
    }
}