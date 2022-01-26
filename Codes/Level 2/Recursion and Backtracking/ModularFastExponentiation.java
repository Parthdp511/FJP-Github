import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static long xpown(long x, long n, long p) {
		if(n == 0)  return 1;
		long currAns = xpown(x, n/2, p);
		long ans = (currAns * currAns)%p;
		if(n%2 == 0)    return ans;
		return (ans * x)%p;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner scn = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
			int x = scn.nextInt();
			int n = scn.nextInt();

            long ans = xpown(x,n,1000000007);
			System.out.println(ans);
		}
}