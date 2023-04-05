import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] arr;
	static boolean[][][] visited;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static class node {
		int r; 
		int c;
		int dist;
		boolean brk;
		node(int r, int c, int dist, Boolean brk){
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.brk = brk;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		visited = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			char[] c = sc.next().toCharArray();
			for (int j = 0; j < M; j++) {
				arr[i][j] = c[j]-'0';
			}
		}
		BFS();
	}

	private static void BFS() {
		Queue<node> queue = new LinkedList<>();
		queue.add(new node(0, 0, 1, false));
		visited[0][0][0] = true;
		while (!queue.isEmpty()) {
			node now = queue.poll();
			if(now.r == N-1 && now.c == M-1) {
				System.out.println(now.dist);
				return;
			}
			for (int k = 0; k < 4; k++) {
				int nr = now.r + dir[k][0];
				int nc = now.c + dir[k][1];
				// 벽을 이미 1번 부순경우
				if(now.brk) {
					if(nr>=0&&nc>=0&&nr<N&&nc<M&&!visited[nr][nc][1]&&arr[nr][nc]==0) {
						visited[nr][nc][1] = true;
						queue.add(new node(nr, nc, now.dist + 1, true));
					}
				}
				// 아직 벽을 부순적이 없는 경우
				else {
					// 0이면 그냥 이동
					if(nr>=0&&nc>=0&&nr<N&&nc<M&&!visited[nr][nc][0]&&arr[nr][nc]==0) {
						visited[nr][nc][0] = true;
						queue.add(new node(nr, nc, now.dist+1, false));
					}
					// 1이면 부수기
					if(nr>=0&&nc>=0&&nr<N&&nc<M&&!visited[nr][nc][0]&&arr[nr][nc]==1) {
						visited[nr][nc][1] = true;
						queue.add(new node(nr, nc, now.dist+1, true));
					}
				}
			}
		}
		System.out.println(-1);
	}
}