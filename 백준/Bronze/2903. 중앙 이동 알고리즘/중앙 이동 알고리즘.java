import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[16];
		int w = 3;
		for (int i = 1; i < dp.length; i++) {
			dp[i] = w * w;
			w = 2 * w - 1;
		}
		System.out.println(dp[N]);
	}
}