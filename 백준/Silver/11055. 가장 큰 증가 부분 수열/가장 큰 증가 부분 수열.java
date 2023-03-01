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
		// dp[n]은 n까지의 합이 가장 큰 증가 부분 수열의 합
		int[] dp = new int[N];
		// 초기값
		for (int i = 0; i < dp.length; i++) {
			dp[i] = arr[i];
		}
		// 구하기
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[j]<arr[i]) {
					dp[i] = Math.max(dp[i], dp[j]+arr[i]);
				}
			}
		}
		System.out.println(Arrays.stream(dp).max().getAsInt());
	}
}