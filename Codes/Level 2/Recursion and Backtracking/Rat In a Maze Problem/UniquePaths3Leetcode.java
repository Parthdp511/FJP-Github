class Solution {
    
    int ans = 0;
    
    public void pathFinder(int[][] grid, boolean[][] visited, int x, int y, int m, int n){
        if(grid[x][y] == 2){
            for(int i=0; i<m; i++)
                for(int j=0; j<n; j++)
                    if(grid[i][j] == 0 && visited[i][j] == false)
                        return;
            ans++;
            return;
        }
        visited[x][y] = true;
        
        if(y < n - 1 && grid[x][y + 1] != -1 && visited[x][y + 1] == false)   pathFinder(grid, visited, x, y + 1, m, n);
        if(x < m - 1 && grid[x + 1][y] != -1 && visited[x + 1][y] == false)   pathFinder(grid, visited, x + 1, y, m, n);
        if(y > 0 && grid[x][y - 1] != -1 && visited[x][y - 1] == false)       pathFinder(grid, visited, x, y - 1, m, n);
        if(x > 0 && grid[x - 1][y] != -1 && visited[x - 1][y] == false)       pathFinder(grid, visited, x - 1, y, m, n);
        
        visited[x][y] = false;
    }
    
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    boolean[][] visited = new boolean[m][n];
                    pathFinder(grid, visited, i, j, m, n);
                }
            }
        }
        return ans;
    }
}