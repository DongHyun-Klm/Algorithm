import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		// dp[n]은 n까지의 연속된 수를 선택한 경우중 합이 가장 큰 경우
		int[] dp = new int[n];
		// 초기값
		dp[0] = arr[0];
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(arr[i], dp[i-1]+arr[i]);
		}
		System.out.println(Arrays.stream(dp).max().getAsInt());
	}
}
