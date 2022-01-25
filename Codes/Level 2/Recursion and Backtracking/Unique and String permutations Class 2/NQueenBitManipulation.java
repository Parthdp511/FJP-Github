import java.util.BitSet;

class Solution {
    static List<List<String>> res;
    
    public static boolean isQueenSafe(int r, int c, int n, BitSet ld, BitSet rd, BitSet col){
        return ((ld.get(r - c + n - 1) == true) || (rd.get(r + c) == true) || (col.get(c) == true)) ? false : true;
    }

    public static void nqueen(int r, boolean[][] chess, BitSet ld, BitSet rd, BitSet col) {
        int n = chess.length;
        if (r == n) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String curr = "";
                for (int j = 0; j < n; j++) {
                    if (chess[i][j] == true) {
                        curr = curr + "Q";
                    } else {
                        curr = curr + ".";
                    }
                }
                ans.add(curr);
            }
            res.add(ans);
            return;
        }

        
        for(int c=0; c<n; c++){
            if(isQueenSafe(r, c, n, ld, rd, col)){
                chess[r][c] = true;
                ld.set(r - c + n - 1, true);
                rd.set(r + c, true);
                col.set(c, true);
                
                nqueen(r + 1, chess, ld, rd, col);
                ld.set(r - c + n - 1, false);
                rd.set(r + c, false);
                col.set(c, false);
                chess[r][c] = false;
            }
        }    
    }

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        boolean[][] chess = new boolean[n][n];
        BitSet leftDiagnol = new BitSet(2 * n - 1);
        BitSet rightDiagnol = new BitSet(2 * n - 1);
        BitSet column = new BitSet(n);
        
        nqueen(0, chess, leftDiagnol, rightDiagnol, column);
        return res;
        
    }
}