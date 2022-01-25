class Solution {
    
    public boolean isQueenSafe(int r, int c, boolean[][] vis){
        // row(left)
        for(int j=0; j<c; j++)
            if(vis[r][j] == true)
                return false;
        //col(up)
        for(int i = 0; i < r; i++)
            if(vis[i][c] == true)
                return false;
        
        //left diagonal (up)
        int i = r, j = c;
        while(i >= 0 && j >= 0)
            if(vis[i--][j--] == true)
                return false;
        
        //right diagonal (down)
        i = r; j = c;
        while(j < vis.length && i >= 0)
            if(vis[i--][j++] == true)
                return false;
        return true;
    }
    
    List<List<String>> res;
    
    public void solve(int r, int c, boolean[][] vis, int n, int qpsf){
        if(qpsf == n + 1){
            List<String> ans = new ArrayList<>();
            for(int i=0; i<n; i++){
                String s = "";
                for(int j=0; j<n; j++)
                    if(vis[i][j] == true)   s += "Q";
                    else                    s += ".";
                ans.add(s);
            }
            res.add(ans);
            return;
        }
        if(r == n)  return;
        if(vis[r][c] == false && isQueenSafe(r, c, vis)){
            vis[r][c] = true;
            
            if(c == n-1)    solve(r + 1, 0, vis, n, qpsf + 1);
            else            solve(r, c + 1, vis, n, qpsf + 1);
            
            vis[r][c] = false;
        }
        
        if(c == n-1)    solve(r + 1, 0, vis, n, qpsf);
        else            solve(r, c + 1, vis, n, qpsf);
    }
    
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        
        boolean[][] visited = new boolean[n][n];
        solve(0, 0, visited, n, 1);
        return res;
    }
}