import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int n = sc.nextInt();
			int[][] arr = new int[2][n];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			// dp[n][m]은 arr[n][m]을 뽑았을 때의 스티커 점수 최대값
			// 스티커는 왼쪽에서 오른쪽으로 뜯는다는 가정
			int[][] dp = new int[2][n];
			// 초기값
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			if(n>1) {
			dp[0][1] = arr[1][0] + arr[0][1];
			dp[1][1] = arr[1][1] + arr[0][0];
			}
			for (int i = 2; i <= n - 1; i++) {
				dp[0][i] = Math.max(dp[1][i - 1] + arr[0][i], dp[1][i - 2] + arr[0][i]);
				dp[1][i] = Math.max(dp[0][i - 1] + arr[1][i], dp[0][i - 2] + arr[1][i]);
			}
			System.out.println(Math.max(dp[1][n-1], dp[0][n-1]));
		}
	}
}