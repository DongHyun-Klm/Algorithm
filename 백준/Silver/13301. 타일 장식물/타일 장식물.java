import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long dp[] = new long[81];
		long dp2[] = new long[81];
		dp[1] = 1; dp[2] = 2;
		dp2[1] = 4;
		for (int i = 2; i < dp2.length; i++) {
			if(i>2)dp[i] = dp[i-1] + dp[i-2]; 
			dp2[i] = dp2[i-1] + dp[i-1] * 2;
		}
		System.out.println(dp2[N]);
	}
}