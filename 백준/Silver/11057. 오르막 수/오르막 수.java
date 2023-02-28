import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// dp[n][m]은 n자리의 오르막 수중 m으로 끝나는 수
		int[][] dp = new int[1001][10];
		// 초기값
		for (int j = 0; j < 10; j++) {
			dp[1][j] = 1;
		}
		// 구하기
		for (int i = 2; i <= N; i++) {
			dp[i][0] = dp[i-1][0]%10007;
			for (int j = 1; j < 10; j++) {
				dp[i][j] = (dp[i][j-1] + dp[i-1][j])%10007;
			}
		}
		// 출력
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += dp[N][i];
		}
		System.out.println(sum%10007);
	}
}
