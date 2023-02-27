import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// int[n]은 숫자 n을 1,2,3 으로 나타낸 방법의 수
		long[] dp = new long[1000001];
		// 초기값
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			for (int i = 4; i <= N; i++) {
				if(dp[i]==0)
				dp[i] = dp[i - 1] % 1000000009 + dp[i - 2] % 1000000009 + dp[i - 3] % 1000000009;
			}
			System.out.println(dp[N] % 1000000009);
		}
	}
}
