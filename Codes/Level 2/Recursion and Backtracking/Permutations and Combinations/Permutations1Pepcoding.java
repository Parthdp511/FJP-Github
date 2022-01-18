import java.io.*;
import java.util.*;

public class Main {

  public static void permutations(int[] boxes, int ci, int ti, boolean[] visited){
    // write your code here
    if(ci == ti + 1){
        for(int box : boxes)
            System.out.print(box);
        System.out.println("");
        return;
    }
    
    for(int i=0; i<boxes.length; i++){
        if(visited[i] == false){
            visited[i] = true;
            boxes[i] = ci;
            permutations(boxes, ci + 1, ti, visited);
            boxes[i] = 0;
            visited[i] = false;
        }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    boolean[] visited = new boolean[nboxes];
    permutations(new int[nboxes], 1, ritems, visited);
  }

}