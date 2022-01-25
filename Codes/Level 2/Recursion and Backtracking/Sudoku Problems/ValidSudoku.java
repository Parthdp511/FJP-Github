class Solution {
    
    public boolean checkRow(char[][] board, int r){
        int[] vis = new int[9];
        for(int j=0; j<9; j++)
            if(board[r][j] != '.')  vis[board[r][j] - '1']++;
        for(int i=0; i<9; i++)
            if(vis[i] >= 2)
                return false;
        return true;
    }
    
    public boolean checkCol(char[][] board, int c){
        int[] vis = new int[9];
        for(int i=0; i<9; i++)
            if(board[i][c] != '.')  vis[board[i][c] - '1']++;
        for(int i=0; i<9; i++)
            if(vis[i] >= 2)
                return false;
        return true;
    }
    
    public boolean checkSubGrids(char[][] board){
        int[] vis = new int[9];
        for(int i=0; i<3; i++)  for(int j=0; j<3; j++)  if(board[i][j] != '.')  vis[board[i][j] - '1']++;
        for(int i=0; i<9; i++)
            if(vis[i] >= 2) return false;
            else        vis[i] = 0;
        
        for(int i=0; i<3; i++)  for(int j=3; j<6; j++)  if(board[i][j] != '.')  vis[board[i][j] - '1']++;
        for(int i=0; i<9; i++)
            if(vis[i] >= 2) return false;
            else        vis[i] = 0;
        
        for(int i=0; i<3; i++)  for(int j=6; j<9; j++)  if(board[i][j] != '.')  vis[board[i][j] - '1']++;
        for(int i=0; i<9; i++)
            if(vis[i] >= 2) return false;
            else        vis[i] = 0;
        
        for(int i=3; i<6; i++)  for(int j=0; j<3; j++)  if(board[i][j] != '.')  vis[board[i][j] - '1']++;
        for(int i=0; i<9; i++)
            if(vis[i] >= 2) return false;
            else        vis[i] = 0;
        
        for(int i=3; i<6; i++)  for(int j=3; j<6; j++)  if(board[i][j] != '.')  vis[board[i][j] - '1']++;
        for(int i=0; i<9; i++)
            if(vis[i] >= 2) return false;
            else        vis[i] = 0;
        
        for(int i=3; i<6; i++)  for(int j=6; j<9; j++)  if(board[i][j] != '.')  vis[board[i][j] - '1']++;
        for(int i=0; i<9; i++)
            if(vis[i] >= 2) return false;
            else        vis[i] = 0;
        
        for(int i=6; i<9; i++)  for(int j=0; j<3; j++)  if(board[i][j] != '.')  vis[board[i][j] - '1']++;
        for(int i=0; i<9; i++)
            if(vis[i] >= 2) return false;
            else        vis[i] = 0;
        
        for(int i=6; i<9; i++)  for(int j=3; j<6; j++)  if(board[i][j] != '.')  vis[board[i][j] - '1']++;
        for(int i=0; i<9; i++)
            if(vis[i] >= 2) return false;
            else        vis[i] = 0;
        
        for(int i=6; i<9; i++)  for(int j=6; j<9; j++)  if(board[i][j] != '.')  vis[board[i][j] - '1']++;
        for(int i=0; i<9; i++)
            if(vis[i] >= 2) return false;
            else        vis[i] = 0;
        
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++)
            if(checkRow(board, i) == false)
                return false;
        
        for(int j=0; j<9; j++)
            if(checkCol(board, j) == false)
                return false;
        
        return checkSubGrids(board);
    }
}