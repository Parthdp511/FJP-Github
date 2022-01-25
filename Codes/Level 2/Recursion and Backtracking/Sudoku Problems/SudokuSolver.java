class Solution {
    public boolean isSudokuValid(char[][] board, int row, int col, char ch){
        // row element
        for(int j=0; j<9; j++)
            if(board[row][j] == ch)
                return false;
        
        // col element
        for(int i=0; i<9; i++)
            if(board[i][col] == ch)
                return false;
        
        // submatrix
        int subRow = (row/3) * 3;
        int subCol = (col/3) * 3;
        for(int i=subRow; i < subRow + 3; i++)
            for(int j=subCol; j < subCol + 2; j++)
                if(board[i][j] == ch)
                    return false;
        return true;
    }
    
    public boolean solveSudoku(char[][] board, int row, int col){
        if(row == 9){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    System.out.print(board[i][j] + " ");
                }System.out.println();
            }
            return true; // positive base case
        }
        
        int nextRow = (col == 8) ? row + 1 : row;
        int nextCol = (col == 8) ? 0 : col + 1;
        if(board[row][col] != '.'){
            // already filled
            boolean res = solveSudoku(board, nextRow, nextCol);
            if(res == true) return true;
        }else{
            //empty cell, check all options
            for(int i=1; i<=9; i++){
                if(isSudokuValid(board, row, col, (char)(i + '0')) == true){
                    board[row][col] = (char)(i + '0');
                    
                    boolean res = solveSudoku(board, nextRow, nextCol);
                    if(res == true) return true;
                    
                    board[row][col] = '.';
                }
            }
        }
        
        return false;   // Sudoku is not solvable
    }
    
    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0, 0); 
    }
}