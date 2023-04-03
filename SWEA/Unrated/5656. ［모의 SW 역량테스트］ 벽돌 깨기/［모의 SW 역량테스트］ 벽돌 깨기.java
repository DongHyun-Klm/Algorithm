import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	static int N, W, H, min;
	static int[][] arr;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			min = Integer.MAX_VALUE;
			arr = new int[H][W];
			visited = new boolean[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int[][] arr_c = new int[H][W];

			for (int c = 0; c < W; c++) {
				// 매 낙하지점마다 배열 clone해서 DFS보내기
				for (int i = 0; i < H; i++) {
					arr_c[i] = arr[i].clone();
				}
				DFS(1, c, arr_c);
			}
			System.out.printf("#%d %d\n", tc + 1, min);
		}
	}

	private static void DFS(int d, int c, int[][] a) {
		if (d == N + 1) {
			// 남은 벽돌 개수 세기
			int cnt = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (a[i][j] != 0)
						cnt++;
				}
			}
			min = Math.min(min, cnt);
			return;
		}
		// 맨 위 벽돌 찾기
		int r = -1;
		for (int i = 0; i < H; i++) {
			if (a[i][c] != 0) {
				r = i;
				break;
			}
		}
		// 벽돌 없다면 그냥 다음으로 보내기
		if (r != -1) {
			// 벽돌 부수기
			bomb(r, c, a);
			// 벽돌 바닥에 붙이기
			drop(a);
		}
		// 다음 구슬 낙하
		int[][] arr_c = new int[H][W];
		for (int i = 0; i < W; i++) {
			for (int h = 0; h < H; h++) {
				arr_c[h] = a[h].clone();
			}
			DFS(d + 1, i, arr_c);
		}
	}

	// 벽돌 뿌시기
	private static void bomb(int r, int c, int[][] a) {
		int number = a[r][c];
		a[r][c] = 0;
		for (int i = 1; i < number; i++) {
			for (int k = 0; k < 4; k++) {
				int nr = r + i * dir[k][0];
				int nc = c + i * dir[k][1];
				if (nr >= 0 && nc >= 0 && nr < H && nc < W && a[nr][nc] != 0) {
					bomb(nr, nc, a);
				}
			}
		}
	}

	// 벽돌 바닥에 붙이기
	private static void drop(int[][] a) {
		for (int i = 0; i < W; i++) {
			Stack<Integer> stk = new Stack<>();
			for (int j = 0; j < H; j++) {
				if (a[j][i] != 0) {
					stk.add(a[j][i]);
					a[j][i] = 0;
				}
			}
			int size = stk.size();
			for (int j = 0; j < size; j++) {
				a[H - 1 - j][i] = stk.pop();
			}
		}
	}
}