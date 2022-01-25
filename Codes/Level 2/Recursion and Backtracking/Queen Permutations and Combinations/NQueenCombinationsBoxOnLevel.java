class Solution {
    
    List<List<String>> res;
    
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
    
    
    public void nQueen(int r, int c, boolean[][] visited, int n, int placed){
        if(r == n){
            if(placed == n){
                List<String> ans = new ArrayList<>();
                for(int i=0; i<n; i++){
                    String curr = "";
                    for(int j=0; j<n; j++)
                        if(visited[i][j] == true)   curr += "Q";
                        else                        curr += ".";
                    ans.add(curr);
                }
                res.add(ans);
            }
            return;
        }
        if(visited[r][c] == false && isQueenSafe(r, c, visited)){
            visited[r][c] = true;
            
            if(c == n - 1)  nQueen(r + 1, 0, visited, n, placed + 1);
            else            nQueen(r, c + 1, visited, n, placed + 1);
            
            visited[r][c] = false;
        }
        if(c == n - 1)  nQueen(r + 1, 0, visited, n, placed);
        else            nQueen(r, c + 1, visited, n, placed);
            
    }
    
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        
        boolean[][] visited = new boolean[n][n];
        nQueen(0, 0, visited, n, 0);
        return res;
    }
}