import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		int[][] arr = new int[N][M];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int[][] dp = new int[N][M];
		// 초기값
		dp[0][0] = arr[0][0];
		for (int i = 1; i < M; i++) {
			dp[0][i] = dp[0][i-1] + arr[0][i];
		}
		for (int i = 1; i < N; i++) {
			dp[i][0] = dp[i-1][0] + arr[i][0];
		}
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + arr[i][j];
			}
		}
		System.out.println(dp[N-1][M-1]);
	}
}