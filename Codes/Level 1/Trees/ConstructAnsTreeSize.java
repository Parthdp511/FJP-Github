import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();

    Node(){
      this.data = 0;
      this.children = new ArrayList<>();
    }
    
    Node(int val){
      this.data = val;
      this.children = new ArrayList<>();
    }
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = new Node(arr[0]);

    Stack<Node> st = new Stack<>();
    st.push(root);
    for(int i=1; i<arr.length; i++){
      if(arr[i] == -1){
        st.pop();
      }else{
        Node curr = st.peek(), newChild = new Node(arr[i]);
        curr.children.add(newChild);
        st.push(newChild);
      }
    }
    return root;
  }

  public static int size(Node node){
    // write your code here
    int currAns = 1;
    for(Node child : node.children){
      currAns += size(child);
    }
    return currAns;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    int sz = size(root);
    System.out.println(sz);
    // display(root);
  }

}