import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int[] fee = new int[4];
			int[] plan = new int[13];
			int[] dp = new int[13];
			for (int i = 0; i < fee.length; i++) {
				fee[i] = sc.nextInt();
			}
			for (int i = 1; i < plan.length; i++) {
				plan[i] = sc.nextInt();
			}
			// 초기값(1월 요금 최소값)
			dp[1] = Math.min(plan[1] * fee[0], fee[1]);
			// dp[n]은 n월의 요금 최소값
			for (int i = 2; i <= 12; i++) {
				// 1일 이용권 1달 이용권 비교
				dp[i] = dp[i - 1] + Math.min(plan[i] * fee[0], fee[1]);
				// 3달 이용권과 비교
				if(i>=3) dp[i] = Math.min(dp[i], dp[i-3] + fee[2]);
			}
			// 마지막으로 연간 요금제와 비교
			dp[12] = Math.min(dp[12], fee[3]);
			System.out.printf("#%d %d\n", tc, dp[12]);
		}
	}
}