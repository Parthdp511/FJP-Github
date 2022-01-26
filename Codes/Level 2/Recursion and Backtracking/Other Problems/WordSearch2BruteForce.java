class Solution {
    
    int[] dx, dy;
    
    public boolean findWord(char[][] board, String word, int idx, boolean[][] vis, int x, int y, int m, int n){
        if(idx == word.length())
            return true;
        vis[x][y] = true;
        
        for(int i=0; i<4; i++){
            int X = x + dx[i], Y = y + dy[i];
            if(X >= 0 && Y >= 0 && X < m && Y < n && vis[X][Y] == false && board[X][Y] == word.charAt(idx)){
                boolean res = findWord(board, word, idx + 1, vis, X, Y, m, n);
                if(res == true)     return true;
            }
        }
        vis[x][y] = false;
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        
        return false;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        dx = new int[]{-1, 0, 1, 0};
        dy = new int[]{0, -1, 0, 1};
        int m = board.length, n = board[0].length;
        Arrays.sort(words);
        for(int k=0; k<words.length; k++){
            String word = words[k];
            boolean flag = false;
            boolean[][] visited = new boolean[m][n];
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(board[i][j] == word.charAt(0)){
                        visited[i][j] = true;
                        boolean res = findWord(board, word, 1, visited, i, j, m, n);
                        if(res == true){
                            ans.add(word);
                            flag = true;
                            break;
                        }
                    }
                }
                if(flag == true)    break;
            }
        }
        return ans;
    }
}