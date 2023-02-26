import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dp = new int[11];
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
		int N = sc.nextInt();
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i <= N; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		System.out.println(dp[N]);
		}
	}
}
