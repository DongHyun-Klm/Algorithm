import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] card = new int[N];
		for (int i = 0; i < card.length; i++) {
			card[i] = sc.nextInt();
		}
		// dp[i]는 i개의 카드를 갖기 위해 지불해야 하는 금액의 최대값 
		int[] dp = new int[1001];
		dp[1] = card[0];
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if(i%j==0) {
					dp[i] = Math.min(dp[j]*(i/j), card[i-1]);
				}
				dp[i] = Math.min(dp[i], dp[i-j]+dp[j]);
			}
		}
		System.out.println(dp[N]);
	}
}
