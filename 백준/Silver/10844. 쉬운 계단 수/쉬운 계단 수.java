import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long sum = 0;
		// dp[N][M]는 N자리의 계단 수들중 끝이 M으로 끝나는 경우의 개수
		long dp[][] = new long[101][10];
		// 초기값 : 1자리의 계단 수중 1~9로 끝나는 경우> 모두 1
		Arrays.fill(dp[1], 1);
		// 0은 안됨
		dp[1][0] = 0;
		
		for (int i = 2; i <= N; i++) {
			// 끝자리가 0인 경우는 그 전의 수가 반드시 1이여야 함
			dp[i][0] = dp[i-1][1]%1000000000;
			// 끝자리가 9인 경우는 그 전의 수가 반드시 8이여야 함
			dp[i][9] = dp[i-1][8]%1000000000;
			// 1~8은 +1,-1 두가지 모두 가능
			for (int j = 1; j <= 8; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1000000000;
			}
		}
		for (int i = 0; i <= 9; i++) {
			sum += dp[N][i];
		}
		System.out.println(sum%1000000000);
	}
}
