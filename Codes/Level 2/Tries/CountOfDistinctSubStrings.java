// { Driver Code Starts
import java.util.*;

class suffix
{
     int index;  
    int rank[] = new int[2];
}

class UniqueSubStr
{
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            GfG g = new GfG();
            System.out.println(g.countDistinctSubstring(st));
        }
    }
}// } Driver Code Ends


/*You are required to complete this method */
class GfG
{

    public static class Node{
        Node[] children = new Node[26];
        
        public Node get(char ch){
            return children[ch - 'a'];
        }
        
        public void set(char ch){
            children[ch - 'a'] = new Node();
        }
    }
   
     
    public static int countDistinctSubstring(String s)
    {
       //your code here
       Node root = new Node();
       int count = 1;
       for(int i=0; i<s.length(); i++){
            Node curr = root;
            for(int j=i; j<s.length(); j++){
                if(curr.get(s.charAt(j)) == null){
                    curr.set(s.charAt(j));
                    count++;
                }
                curr = curr.get(s.charAt(j));
            }
       }
       return count;
    }
}