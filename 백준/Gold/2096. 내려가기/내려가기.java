import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][3];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		// 최대 구하기
		int[][] dp = new int[N][3];
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]) + arr[i][0];
			dp[i][1] = Math.max(dp[i - 1][2], Math.max(dp[i - 1][0], dp[i - 1][1])) + arr[i][1];
			dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]) + arr[i][2];
		}
		System.out.print(Math.max(dp[N-1][2], Math.max(dp[N-1][0], dp[N-1][1])));
		System.out.print(" ");
		// 최소구하기
		dp = new int[N][3];
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][0];
			dp[i][1] = Math.min(dp[i - 1][2], Math.min(dp[i - 1][0], dp[i - 1][1])) + arr[i][1];
			dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][2];
		}
		System.out.print(Math.min(dp[N-1][2], Math.min(dp[N-1][0], dp[N-1][1])));
	}
}