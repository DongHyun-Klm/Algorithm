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
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[i]<arr[j]) dp[i] = Math.max(dp[i], dp[j]+1);
			}
		}
		System.out.println(Arrays.stream(dp).max().getAsInt());
	}
}