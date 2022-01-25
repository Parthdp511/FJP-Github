class Solution {
    
    int[] dx = new int[4];
    int[] dy = new int[4];
    
    public int findMax(int[][] grid, boolean[][] visited, int i, int j, int n, int m){
        visited[i][j] = true;
        int currMax = 0;
        for(int k=0; k<4; k++){
            if(i + dx[k] >= 0 && j + dy[k] < m && i + dx[k] < n && j + dy[k] >= 0 && visited[i + dx[k]][j + dy[k]] == false && grid[i + dx[k]][j + dy[k]] != 0){
                currMax = Math.max(currMax, findMax(grid, visited, i + dx[k], j + dy[k], n, m));
            }
        }
        visited[i][j] = false;
        return grid[i][j] + currMax;
    }
    
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0, n = grid.length, m = grid[0].length;
        dy[0] = 0; dy[1] = 1; dy[2] = 0; dy[3] = -1;
        dx[0] = 1; dx[1] = 0; dx[2] = -1; dx[3] = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                boolean[][] visited = new boolean[n][m];
                maxGold = Math.max(maxGold, findMax(grid, visited, i, j, n, m));
            }
        }
        return maxGold;
    }
}