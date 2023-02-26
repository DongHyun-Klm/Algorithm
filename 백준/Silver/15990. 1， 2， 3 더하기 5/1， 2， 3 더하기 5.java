import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		long[][] dp = new long[100001][4];
		// dp[n][m] 은 숫자 n을 1, 2, 3의 합으로 나타낼 떄 이 합의 끝 숫자가 m인 방법의 개수.
		dp[1][1] = 1;
		dp[2][2] = 1;
		// 3 = 2 + 1
		dp[3][1] = dp[2][2];
		// 3 = 1 + 2
		dp[3][2] = dp[1][1];
		dp[3][3] = 1;
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			long sum = 0;
			for (int i = 4; i <= n; i++) {
				if(dp[i][1]==0) {
				// i의 합이 1로 끝나는 경우 > i-1에서 2로 끝난경우 + i-1에서 3으로 끝난 경우
				dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1000000009;
				// i의 합이 2로 끝나는 경우 > i-2에서 1로 끝난경우 + i-2에서 3으로 끝난 경우
				dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1000000009;
				// i의 합이 3으로 끝나는 경우 > i-3에서 1로 끝난경우 + i-3에서 2으로 끝난 경우
				dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1000000009;
			}
			}
			for (int i = 1; i <= 3; i++) {
				sum += dp[n][i];
			}
			System.out.println(sum % 1000000009);
		}
	}
}
