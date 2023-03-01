import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		// dp[n][0]은 n자리 까지의 포도주를 먹을 때 최대 양(arr[n] 먹을떄) + 0이면 n 전전꺼 먹음
		// dp[n][1]이면 n 전에꺼 먹음
		// dp[n][2]이면 n 전이랑 전전꺼 먹음 (arr[n] 못먹는다)
		int[][] dp = new int[n][3];
		// 초기값
		dp[0][0] = arr[0];
		if(n>1) {
		dp[1][0] = arr[1];
		dp[1][1] = dp[0][0] + arr[1];
		}
		// 구하기
		for (int i = 2; i < dp.length; i++) {
			dp[i][0] = arr[i] + Math.max(dp[i-2][0], Math.max(dp[i-2][1], dp[i-2][2]));
			dp[i][1] = arr[i] + Math.max(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = dp[i-2][0] + arr[i-1];
		}
		System.out.println(Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2])));
	}
}