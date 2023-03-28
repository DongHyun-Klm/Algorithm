import java.util.Scanner;

public class Main {
	static int M, N;
	static int[][] arr;
	static boolean[][] visited;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			M = sc.nextInt();
			N = sc.nextInt();
			int K = sc.nextInt(), cnt = 0;
			arr = new int[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[y][x] = 1;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 1 && !visited[i][j]) {
						DFS(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	private static void DFS(int r, int c) {
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if (nr >= 0 && nc >= 0 && nr < N && nc < M && arr[nr][nc] == 1 && !visited[nr][nc])
				DFS(nr, nc);
		}
	}
}