import java.io.*;
import java.util.*;

public class Sort01 {

  public static void sort01(int[] arr) {
    int right = 0, left = 0;
    while(right < arr.length){
        if(arr[right] == 1){
            right++;
        }else{
            swap(arr, right, left);
            right++;
            left++;
        }
    }
  }

// used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping index " + i + " and index " + j);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int[] arr) {
    for (int i = 0 ; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0 ; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    sort01(arr);
    print(arr);
  }

}