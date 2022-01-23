import java.io.*;
import java.util.*;

public class Main {

    public static void queenCombinations(int qpsf, int tq, int row, int col,  String mat){
        if(row == tq){
            if(qpsf == tq){
                System.out.println(mat);
            }
            return;
        }
        if(col == tq - 1){
            // Apni Row ka last element, agli row ke pehle element par jana hai
            
            // yes
            queenCombinations(qpsf + 1, tq, row + 1, 0, mat + 'q' + '\n');
            
            // no
            queenCombinations(qpsf, tq, row + 1, 0, mat + '-' + '\n');
        }else{
            // yes
            queenCombinations(qpsf + 1, tq, row, col + 1, mat + 'q');
            
            // no
            queenCombinations(qpsf, tq, row, col + 1, mat + '-');
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        queenCombinations(0, n, 0, 0, "");
    }
}