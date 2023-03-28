import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, H;
	static int[][][] arr;
	static int[][] dir = { { 1, 0, 0 }, { -1, 0, 0 }, { 0, 0, -1 }, { 0, 0, 1 }, { 0, 1, 0 }, { 0, -1, 0 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();
		arr = new int[H][N][M];
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[k][i][j] = sc.nextInt();
				}
			}
		}
		BFS();
		int max = 0;
		boolean flag = false;
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 0이 남아있다면 -1 출력하자
					if (arr[k][i][j] == 0) {
						flag = true;
						break;
					}
					// 없다면 max값 찾기
					max = Math.max(max, arr[k][i][j]);
				}
			}
		}
		if (flag)
			System.out.println("-1");
		else
			System.out.println(max - 1);
	}

	private static void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		int cnt = 0;
		// 시작점이 여러개인 경우도 있으니 여기서 찾아서 넣기
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[k][i][j] == 1) {
						queue.add(k);
						queue.add(j);
						queue.add(i);
					}
				}
			}
		}
		while (!queue.isEmpty()) {
			int z = queue.poll();
			int x = queue.poll();
			int y = queue.poll();
			for (int i = 0; i < 6; i++) {
				int nz = z + dir[i][0];
				int nr = y + dir[i][1];
				int nc = x + dir[i][2];
				if (nz >= 0 && nr >= 0 && nc >= 0 && nz<H && nr < N && nc < M && arr[nz][nr][nc] == 0) {
					queue.add(nz);
					queue.add(nc);
					queue.add(nr);
					// 몇 번째 날에 익은 토마토인지 알기 위해 +1
					arr[nz][nr][nc] = arr[z][y][x] + 1;
				}
			}
		}
	}
}