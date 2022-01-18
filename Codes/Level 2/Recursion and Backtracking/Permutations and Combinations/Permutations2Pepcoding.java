import java.io.*;
import java.util.*;

public class Main {

  public static void permutations(int currBox,int currItem, int n, int k, boolean[] visited, String boxes){
    // write your code here
    if(currBox == n){
        if(currItem == k + 1)
            System.out.println(boxes);
        return;
    }
    
    //current Box choice -> Try to place not placed items, do not place any item
    for(int i=0; i<k; i++){
        if(visited[i] == false){
            visited[i] = true;
            permutations(currBox + 1,currItem + 1, n, k, visited, boxes + (i + 1));
            visited[i] = false;
        }
    }
    permutations(currBox + 1, currItem, n, k, visited, boxes + "0");
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    
    String boxes = "";
        
    boolean[] visited = new boolean[ritems];
    permutations(0, 1, nboxes, ritems, visited, boxes);
  }

}