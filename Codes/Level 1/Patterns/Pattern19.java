package Patterns;

import java.util.Scanner;

public class Pattern19 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==n/2 || j==n/2)
                    System.out.print("*\t");
                else if((i==0 && j<n/2) || (j==0 && i>=n/2))
                    System.out.print("*\t");
                else if((i==n-1 && j>=n/2) || (j==n-1 && i<=n/2))
                    System.out.print("*\t");
                else
                    System.out.print("\t");
            }System.out.println("");
        }
    }
}
