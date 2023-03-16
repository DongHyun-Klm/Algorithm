import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		int[][] arr = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int K = sc.nextInt();
		for (int tc = 0; tc < K; tc++) {
			int i = sc.nextInt(), j = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt(), sum =0;
			for (int k = i; k <= x; k++) {
				for (int k2 = j; k2 <= y; k2++) {
					sum += arr[k][k2];
				}
			}
			System.out.println(sum);
		}
	}
}