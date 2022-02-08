import java.io.*;
import java.util.*;

public class Main {

  public static class MinStack {
    Stack<Integer> allData;
    Stack<Integer> minData;
    int minVal;
    public MinStack() {
      allData = new Stack<>();
      minData = new Stack<>();
      minVal = Integer.MAX_VALUE;
    }


    int size() {
      // write your code here  
      return allData.size();
    }

    void push(int val) {
      // write your code here
      minVal = Math.min(minVal, val);
      allData.push(val);
      minData.push(minVal);
    }

    int pop() {
      // write your code here
      minData.pop();
      return allData.pop();
    }

    int top() {
      // write your code here
      return allData.peek();
    }

    int min(){
  	  // write your code here
      return minData.peek();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MinStack st = new MinStack();

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("push")){
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if(str.startsWith("pop")){
        int val = st.pop();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("top")){
        int val = st.top();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("size")){
        System.out.println(st.size());
      } else if(str.startsWith("min")){
        int val = st.min();
        if(val != -1){
          System.out.println(val);
        }
      }
      str = br.readLine();
    }
  }
}