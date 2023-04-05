import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] dih = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static boolean[][][] vistied;
	static int K, W, H;
	static int[][] arr;

	static class node {
		int r;
		int c;
		int horse;
		int dist;

		node(int r, int c, int horse, int dist) {
			this.r = r;
			this.c = c;
			this.horse = horse;
			this.dist = dist;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		arr = new int[H][W];
		vistied = new boolean[H][W][K+1];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		BFS();
	}

	private static void BFS() {
		Queue<node> queue = new LinkedList<>();
		queue.add(new node(0, 0, 0, 0));
		vistied[0][0][0] = true;
		while (!queue.isEmpty()) {
			node now = queue.poll();
			if(now.r == H-1 && now.c == W-1) {
				System.out.println(now.dist);
				return;
			}
			// 말 기회 다 썻으면
			if (now.horse == K) {
				// 원숭이처럼 움직이자
				for (int i = 0; i < 4; i++) {
					int nr = now.r + dir[i][0];
					int nc = now.c + dir[i][1];
					if (nr >= 0 && nc >= 0 && nr < H && nc < W && !vistied[nr][nc][now.horse] && arr[nr][nc] == 0) {
						vistied[nr][nc][now.horse] = true;
						queue.add(new node(nr, nc, now.horse, now.dist + 1));
					}
				}
			}
			// 기회 남았으면
			else {
				// 말처럼 움직이자
				for (int i = 0; i < 8; i++) {
					int nr = now.r + dih[i][0];
					int nc = now.c + dih[i][1];
					if (nr >= 0 && nc >= 0 && nr < H && nc < W && !vistied[nr][nc][now.horse+1] && arr[nr][nc] == 0) {
						vistied[nr][nc][now.horse+1] = true;
						queue.add(new node(nr, nc, now.horse + 1, now.dist + 1));
					}
				}
				// 원숭이처럼 움직이자
				for (int i = 0; i < 4; i++) {
					int nr = now.r + dir[i][0];
					int nc = now.c + dir[i][1];
					if (nr >= 0 && nc >= 0 && nr < H && nc < W && !vistied[nr][nc][now.horse] && arr[nr][nc] == 0) {
						vistied[nr][nc][now.horse] = true;
						queue.add(new node(nr, nc, now.horse, now.dist + 1));
					}
				}
			}
		}
		System.out.println(-1);
	}
}