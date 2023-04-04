import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] arr;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] c = sc.next().toCharArray();
			for (int j = 0; j < M; j++) {
				arr[i][j] = c[j] - '0';
			}
		}
		BFS();
		System.out.println(arr[N-1][M-1]);
	}

	private static void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		queue.add(0);
		while (!queue.isEmpty()) {
			int r = queue.poll();
			int c = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];
				if(nr==0&&nc==0) continue;
				if(nr>=0&&nc>=0&&nr<N&&nc<M&&arr[nr][nc]==1) {
					arr[nr][nc] = arr[r][c] + 1;
					queue.add(nr);
					queue.add(nc);
				}
			}
		}
	}
}