import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j <= i; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		// dp[n][m]은 n행 m열까지 맨 위층에서 아래층으로 내려올 때, 선택된 수의 합의 최대값
		int[][] dp = new int[n][n];
		// 초기값
		dp[0][0] = arr[0][0];
		// 구하자
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j] + arr[i][j];
				} else if (j == i) {
					dp[i][j] = dp[i - 1][j - 1] + arr[i][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + arr[i][j];
				}
			}
		}
		// 마지막 행의 최대값 구하기
		int max = -1;
		for (int i = 0; i < dp.length; i++) {
			max = Math.max(max, dp[n-1][i]); 
		}
		System.out.println(max);
	}
}