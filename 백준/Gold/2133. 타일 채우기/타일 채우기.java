import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// dp[n][0]은 3*2 세트로만 만든경우 dp[n][1]은 내가 3*4 세트로 끝나는 경우
		long[] dp = new long[N + 1];
		// 초기값
		dp[0] = 1;
		if (N >= 2)dp[2] = 3;
		// dp[N]을 구하자
		for (int i = 2; i < dp.length; i += 2) {
			dp[i] = dp[i-2]*3;
			for (int j = 0; j < i-2; j += 2) {
				dp[i] += dp[j]*2;
			}
		}
		// 합 구하기
		System.out.println(dp[N]);
	}
}