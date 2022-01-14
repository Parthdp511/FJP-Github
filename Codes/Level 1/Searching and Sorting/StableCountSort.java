import java.io.*;
import java.util.*;

public class StableCountSort {

  public static void countSort(int[] arr, int min, int max) {
   //write your code here
   int n = arr.length;
   int[] freq = new int[max - min + 1];
   for(int i=0; i<n; i++){
       freq[arr[i] - min]++;
   }
   
   int[] preSum = new int[max - min + 1];
   preSum[0] = freq[0];
   for(int i=1; i<freq.length; i++){
       preSum[i] = preSum[i - 1] + freq[i];
   }
   
   int[] res = new int[n];
   for(int i=n-1; i >= 0; i--){
       preSum[arr[i] - min]--;
       res[preSum[arr[i] - min]] = arr[i];
   }
   
   for(int i=0; i<n; i++)
    arr[i] = res[i];
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    countSort(arr,min,max);
    print(arr);
  }

}