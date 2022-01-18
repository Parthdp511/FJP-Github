import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> ans = getFactors(n);
        for(List<Integer> val : ans){
            System.out.println(val);
        }
    }

    public static List<List<Integer>> getFactors(int n){
        List<List<Integer>> ans = new ArrayList<>();
        if(n == 1)
            return ans;
        List<Integer> tempList = new ArrayList<>();

        factors(n, ans, tempList, n, 2);

        return ans;
    }

    private static void factors(int n, List<List<Integer>>  ans, List<Integer> tempList, int permn, int idx){
        if(n == 1){
            List<Integer> br = new ArrayList<>(tempList);
            ans.add(br);
            return;
        }
        for(int i=idx; i<=n && i < permn; i++){
            if(n % i == 0){
                tempList.add(i);
                factors(n/i, ans, tempList, permn, i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}