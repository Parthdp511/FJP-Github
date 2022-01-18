import java.io.*;
import java.util.*;

public class Main {

  public static void combinations(int[] boxes, int ci, int ti, int lb){
    // write your code here
    if(ci == ti + 1){
        for(int box : boxes)
            if(box == 1)   System.out.print("i");
            else    System.out.print("-");
        System.out.println();
        return;
    }
    
    
    for(int i=lb ; i < boxes.length; i++){
        boxes[i] = 1;
        combinations(boxes, ci + 1, ti, i + 1);
        boxes[i] = 0;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(new int[nboxes], 1, ritems, 0);
  }

}