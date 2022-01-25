// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    
    public static void findPath(int[][]m, int n, int i, int j, String s, List<String> ans, boolean[][] visited){
        if(i == n-1 && j == n-1){
            String currPath = s;
            ans.add(s);
            return;
        }
        
        visited[i][j] = true;
        if(i != 0 && m[i-1][j] == 1 && visited[i-1][j] == false)    findPath(m, n, i-1, j, s + "U", ans, visited);
        if(i != n-1 && m[i+1][j] == 1 && visited[i+1][j] == false)    findPath(m, n, i+1, j, s + "D", ans, visited);
        if(j != 0 && m[i][j-1] == 1 && visited[i][j-1] == false)    findPath(m, n, i, j-1, s + "L", ans, visited);
        if(j != n-1 && m[i][j+1] == 1 && visited[i][j+1] == false)  findPath(m, n, i, j+1, s + "R", ans, visited);
        visited[i][j] = false;
    }
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        if(m[0][0] == 0)    return ans;
        findPath(m, n, 0, 0, "", ans, visited);
        return ans;
    }
}