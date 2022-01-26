import java.io.*;
import java.util.*;

public class Main {
  static int counter = 1;

  public static void solution(int totalFriends, boolean[] friendInGroup, String groupSoFar) {
    // write your code here
    int i=0;
    for(int j=1; j<=totalFriends; j++){
        if(friendInGroup[j] == false){
            i = j;
            break;
        }
    }

    if(i == 0){
        System.out.println(counter + "." + groupSoFar);
        counter++;
        return;
    }

    friendInGroup[i] = true;

    solution(totalFriends, friendInGroup, groupSoFar + "(" + i + ") ");

    for(int j=1; j<=totalFriends; j++){
        if(friendInGroup[j] == false){
            friendInGroup[j] = true;
            solution(totalFriends, friendInGroup, groupSoFar + "(" + i + "," + j + ") ");
            friendInGroup[j] = false;
        }
    }
    friendInGroup[i] = false;
  }

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean[] used = new boolean[n + 1];
    solution(n, used, "");
  }
}
