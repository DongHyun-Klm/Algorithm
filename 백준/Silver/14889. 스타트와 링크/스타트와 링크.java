import java.util.Scanner;

public class Main {
	static int[][] arr;
	static boolean[] check;
	static int N, min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		check = new boolean[N + 1];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		min = Integer.MAX_VALUE;
		NM(1, 1);
		System.out.println(min);
	}

	// 고르기
	private static void NM(int d, int start) {
		if (d == N / 2 + 1) {
			cal();
		} else {
			for (int i = start; i <= N; i++) {
				check[i] = true;
				NM(d + 1, i + 1);
				check[i] = false;
			}
		}
	}

	// 계산하고 최소값 저장
	private static void cal() {
		int sum1 = 0, sum2 = 0;
		// sum1 구하기
		for (int i = 1; i < N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (check[i] && check[j])
					sum1 += arr[i - 1][j - 1] + arr[j - 1][i - 1];
			}
		}
		// sum2 구하기
		for (int i = 1; i < N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (!check[i] && !check[j])
					sum2 += arr[i - 1][j - 1] + arr[j - 1][i - 1];
			}
		}
		min = Math.min(Math.abs(sum1 - sum2), min);
	}

}