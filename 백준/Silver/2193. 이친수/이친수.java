import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =  sc.nextInt();
		long sum = 0;
		// dp[N][M]은 N자리 이친수가 M으로 끝나는 경우의 수
		long[][] dp = new long[91][2];
		// 초기값
		dp[1][1] = 1;
		dp[2][0] = 1;
		for (int i = 3; i <= N; i++) {
			dp[i][0] = dp[i-1][1] + dp[i-1][0];
			dp[i][1] = dp[i-1][0];
		}
		for (int i = 0; i <= 1; i++) {
			sum += dp[N][i];
		}
		System.out.println(sum);
	}
}
