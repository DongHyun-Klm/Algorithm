import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		// dp[n]은 dp[n]까지의 최장 증가 수열의 길이
		int[] dp = new int[N];
		// dp[n]은 dp[n]까지의 최장 감소 수열의 길이
		int[] dp2 = new int[N];
		// 초기값
		Arrays.fill(dp, 1);
		Arrays.fill(dp2, 1);
		// 구하기
		for (int i = 1; i < N; i++) {
			if (arr[i] >= arr[i - 1])
				dp[i] = Math.max(dp[i], dp[i - 1] + 1);
		}
		// 구하기
		for (int i = 1; i < N; i++) {
			if (arr[i] <= arr[i - 1])
				dp2[i] = Math.max(dp2[i], dp2[i - 1] + 1);
		}
		int max = Math.max(Arrays.stream(dp).max().getAsInt(), Arrays.stream(dp2).max().getAsInt());
		System.out.println(max);
	}
}