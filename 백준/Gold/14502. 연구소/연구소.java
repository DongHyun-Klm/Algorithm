import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M, max;
	static int[][] arr;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		max = -1;
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int[][] arr_copy = new int[N][M];
		for (int i = 0; i < arr_copy.length; i++) {
			arr_copy[i] = arr[i].clone();
		}
		BT(0, arr_copy, 0, 0);
		System.out.println(max);
	}

	private static void BT(int d, int[][] a, int start_r, int start_c) {
		if (d == 3) {
			int[][] arr_copy = new int[N][M];
			int cnt = 0;
			for (int i = 0; i < arr_copy.length; i++) {
				arr_copy[i] = a[i].clone();
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (a[i][j] == 2)
						DFS(arr_copy, i, j);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(arr_copy[i][j] == 0) cnt++;
				}
			}
			max = Math.max(cnt, max);
			return;
		}
		for (int i = start_r; i < N; i++) {
			if (i > start_r)
				start_c = 0;
			for (int j = start_c; j < M; j++) {
				if (a[i][j] == 0) {
					a[i][j] = 1;
					BT(d + 1, a, i, j + 1);
					a[i][j] = 0;
				}
			}
		}
	}

	private static void DFS(int[][] a, int r, int c) {
		a[r][c] = 2;
		for (int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if(nr>=0&&nc>=0&&nr<N&&nc<M&&a[nr][nc] == 0) {
				DFS(a, nr, nc);
			}
		}
	}
}