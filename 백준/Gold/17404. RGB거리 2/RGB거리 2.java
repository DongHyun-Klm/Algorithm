import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][3];
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// dp[n][0]은 마지막 빨강 선택했을 때, dp[n][1]은 초록, dp[n][2]는 파랑
		// n번째 집까지의 최소 비용
		int[][] dp = new int[N+1][3];
		int[] min = new int[3];
		// 초기값 빨강의 경우
		dp[1][0] = arr[1][0];
		dp[1][1] = 1000000000;
		dp[1][2] = 1000000000;
		for (int i = 2; i <= N; i++) {
			dp[i][0] = Math.min(dp[i-1][1]+arr[i][0], dp[i-1][2]+arr[i][0]);
			dp[i][1] = Math.min(dp[i-1][0]+arr[i][1], dp[i-1][2]+arr[i][1]);
			dp[i][2] = Math.min(dp[i-1][0]+arr[i][2], dp[i-1][1]+arr[i][2]);
		}
		min[0] = Math.min(dp[N][1],dp[N][2]);
		// 초기값 초록의 경우 
		dp = new int[N+1][3];
		dp[1][0] = 1000000000;
		dp[1][1] = arr[1][1];
		dp[1][2] = 1000000000;
		for (int i = 2; i <= N; i++) {
			dp[i][0] = Math.min(dp[i-1][1]+arr[i][0], dp[i-1][2]+arr[i][0]);
			dp[i][1] = Math.min(dp[i-1][0]+arr[i][1], dp[i-1][2]+arr[i][1]);
			dp[i][2] = Math.min(dp[i-1][0]+arr[i][2], dp[i-1][1]+arr[i][2]);
		}
		min[1] = Math.min(dp[N][0],dp[N][2]);
		// 초기값 파랑의 경우
		dp = new int[N+1][3];
		dp[1][0] = 1000000000;
		dp[1][1] = 1000000000;
		dp[1][2] = arr[1][2];
		for (int i = 2; i <= N; i++) {
			dp[i][0] = Math.min(dp[i-1][1]+arr[i][0], dp[i-1][2]+arr[i][0]);
			dp[i][1] = Math.min(dp[i-1][0]+arr[i][1], dp[i-1][2]+arr[i][1]);
			dp[i][2] = Math.min(dp[i-1][0]+arr[i][2], dp[i-1][1]+arr[i][2]);
		}
		min[2] = Math.min(dp[N][0],dp[N][1]);
		System.out.println(Arrays.stream(min).min().getAsInt());
	}
}