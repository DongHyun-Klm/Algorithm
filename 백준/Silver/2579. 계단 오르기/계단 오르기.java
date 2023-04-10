import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[301];
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		int[][] dp = new int[301][2];
		// do[n][0]은 1번 연속
		// dp[n][1]은 2번 연속
		dp[1][0] = arr[1];
		dp[1][1] = arr[1];
		dp[2][0] = arr[2];
		dp[2][1] = arr[1] + arr[2];
		for (int i = 3; i <= N; i++) {
			dp[i][0] = Math.max(dp[i-2][1], dp[i-2][0]) + arr[i];
			dp[i][1] = dp[i-1][0] + arr[i];
		}
		System.out.println(Math.max(dp[N][0], dp[N][1]));
	}
}