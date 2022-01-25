class Solution {
    
    List<List<String>> res;
    
    public boolean isSafe(int r, int c, boolean[][] vis){
        for(int j = 0; j < c; j++)
            if(vis[r][j] == true)
                return false;
        
        for(int i = 0; i < r; i++)
            if(vis[i][c] == true)
                return false;
        
        for(int i = r, j = c; i >= 0 && j >= 0; i--, j--)
            if(vis[i][j] == true)
                return false;
        
        for(int i = r, j = c; i >= 0 && j < vis.length; i--, j++)
            if(vis[i][j] == true)
                return false;
        
        return true;
    }
    
    public void solve(int n, boolean[][] vis, int r, int qpsf){
        if(r == n){
            if(qpsf == n){
                List<String> ans = new ArrayList<>();
                for(int i=0; i<n; i++){
                    String s = "";
                    for(int j=0; j<n; j++)
                        if(vis[i][j] == true)   s += "Q";
                        else                    s += ".";
                    ans.add(s);
                }
                res.add(ans);
            }
            return;
        }
        for(int j=0; j<n; j++){
            if(isSafe(r, j, vis) == true){
                vis[r][j] = true;
                solve(n, vis, r + 1, qpsf + 1);
                vis[r][j] = false;
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        boolean[][] vis = new boolean[n][n];
        solve(n, vis, 0, 0);
        return res;
    }
}