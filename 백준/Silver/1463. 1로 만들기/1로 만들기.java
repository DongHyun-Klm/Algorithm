import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		// 초기값(안해도 됨)
		dp[N] = 0;
		for (int i = N-1; i > 0; i--) {
			dp[i] = dp[i+1] + 1;
			if(i <= N/2) dp[i] = Math.min(dp[i * 2] + 1, dp[i]);
			if(i <= N/3) dp[i] = Math.min(dp[i * 3] + 1, dp[i]);
		}
		System.out.println(dp[1]);
	}
}