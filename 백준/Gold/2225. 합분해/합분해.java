import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), K = sc.nextInt();
		// DP[n][m]은 0~n까지의 정수 m개를 더해서 합이 n이 되는 경우의 수
		long[][] DP = new long[201][201];
		// 초기값
		for (int i = 1; i < DP.length; i++) {
			DP[1][i] = i;
		}
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				for (int j2 = 1; j2 <= j; j2++) {
					DP[i][j] += DP[i - 1][j2] % 1000000000;
				}
			}
		}
		System.out.println(DP[N][K] % 1000000000);
	}
}