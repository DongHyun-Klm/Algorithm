import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), day = sc.nextInt();
		int[] temperature = new int[N];
		for (int i = 0; i < N; i++) {
			temperature[i] = sc.nextInt();
		}
		int[] dp  = new int[N];
		// 초기값
		dp[0] = temperature[0];
		for (int i = 1; i < day; i++) {
			dp[i] = dp[i-1] + temperature[i];  
		}
		for (int i = day; i < dp.length; i++) {
			dp[i] = dp[i-1] + temperature[i] - temperature[i-day]; 
		}
		int max = Integer.MIN_VALUE;
		for (int i = day-1; i < dp.length; i++) {
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
	}
}