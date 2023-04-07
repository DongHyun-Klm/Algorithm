import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int N, M, L;
	static int[][] arr;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static boolean[][] visited;
	static class node {
		int r, c, dist;
		node(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			int r = sc.nextInt(), c = sc.nextInt();
			L = sc.nextInt();
			arr = new int[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) 
				for (int j = 0; j < M; j++) 
					arr[i][j] = sc.nextInt();
			BFS(r, c);
			int cnt = 0;
			for (int i = 0; i < N; i++) 
				for (int j = 0; j < M; j++) 
					if(visited[i][j]) cnt++;
			System.out.printf("#%d %d\n",tc,cnt);
		}
	}
	private static void BFS(int r, int c) {
		Queue<node> queue = new LinkedList<>();
		queue.add(new node(r, c, 0));
		visited[r][c] = true;
		while (!queue.isEmpty()) {
			node now = queue.poll();
			if(now.dist >= L-1) continue;
			for (int i = 0; i < 4; i++) {
				int nr = now.r + dir[i][0];
				int nc = now.c + dir[i][1];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if (visited[nr][nc]) continue;
				if(arr[nr][nc]==0) continue;
				if (!chk(now.r, now.c, nr, nc, i)) continue;
				queue.add(new node(nr, nc, now.dist+1));
				visited[nr][nc] = true;
			}

		}
	}
	// d: 0 - 하 / 1 - 우 / 2 - 상 / 3 - 좌 
	// 내 구조물과 이동할 곳의 구조물, 이동할 방향을 보고 갈 수 있는지 확인하는 메서드
	private static boolean chk(int r, int c, int nr, int nc, int d) {
		int start = arr[r][c];
		int target = arr[nr][nc];
		if(d==0&&(start==1||start == 2||start == 5||start == 6)) {
			if(target==1||target==2||target==4||target==7) return true;
		}
		if(d==1&&(start==1||start == 3||start == 4||start == 5)) {
			if(target==1||target==3||target==6||target==7) return true;
		}
		if(d==2&&(start==1||start == 2||start == 4||start == 7)) {
			if(target==1||target==2||target==5||target==6) return true;
		}
		if(d==3&&(start==1||start == 3||start == 6||start == 7)) {
			if(target==1||target==3||target==4||target==5) return true;
		}
		return false;
	}
}