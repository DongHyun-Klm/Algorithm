import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[5001];
		Arrays.fill(dp, 2000000000);
		dp[3] = 1;
		dp[5] = 1;
		for (int i = 6; i <= N; i++) {
			dp[i] = dp[i-3] + 1;
			dp[i] = Math.min(dp[i], dp[i-5]+1);
		}
		if(dp[N] >= 2000000000) System.out.println("-1");
		else System.out.println(dp[N]);
	}
}