import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		// dp[n]은 수열 A의 index n까지 증가하는 부분 수열중 가장 긴 부분 수열의 길이
		int[] dp = new int[N];
		// 초기값
		Arrays.fill(dp, 1);
		// 수열 A 입력 받기
		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}
		// dp구하기
		for (int i = 1; i <= N-1; i++) {
			for (int j = 0; j < i; j++) {
				if(A[i]>A[j]) {
					dp[i] = Math.max(dp[j]+1, dp[i]);
				}
			}
		}
        Arrays.sort(dp);
		System.out.println(dp[N-1]);
	}
}
