import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] T = new int[20];
		int[] P = new int[20];
		for(int i=1;i<=N;i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		// dp[n]은 n일의 받을 수 있는 최대 금액
		int[] dp = new int[20];
		// 초기값
		dp[T[1]] = P[1];
		// dp[N]구하기
		for (int i = 2; i <= N; i++) {
			dp[i] = Math.max(dp[i-1], dp[i]);
			if(i+T[i]-1 <=N)
			dp[i+T[i]-1] = Math.max(dp[i-1] + P[i], dp[i+T[i]-1]); 
		}
		System.out.println(dp[N]);
	}
}