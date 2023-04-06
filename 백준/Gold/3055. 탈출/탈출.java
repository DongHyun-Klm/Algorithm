import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int R, C;
	static char[][] arr;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static class node{
		int r, c, dist;
		boolean wt;
		node(int r, int c, int dist, boolean wt) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.wt = wt;
		}
		@Override
		public String toString() {
			return "node [r=" + r + ", c=" + c + ", dist=" + dist + ", wt=" + wt + "]";
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt(); C = sc.nextInt();
		arr = new char[R][C];
		for (int i = 0; i < R; i++) {
			arr[i] = sc.next().toCharArray();
		}
		BFS();
	}

	private static void BFS() {
		Queue<node> queue = new LinkedList<>();
		boolean[][][] visited = new boolean[R][C][2];
		for (int i = 0; i < R; i++) 
			for (int j = 0; j < C; j++) 
				if(arr[i][j]=='*') {
					queue.add(new node(i, j, 0, true));
					visited[i][j][1] = true;
				}
		for (int i = 0; i < R; i++) 
			for (int j = 0; j < C; j++) 
				if(arr[i][j] == 'S') {
					queue.add(new node(i, j, 0, false));
					visited[i][j][0] = true;
				}
		while (!queue.isEmpty()) {
			node now = queue.poll();
			// 물의 경우
			if(now.wt) {
				for (int k = 0; k < 4; k++) {
					int nr = now.r + dir[k][0];
					int nc = now.c + dir[k][1];
					if(nr<0||nc<0||nr>=R||nc>=C) continue;
					if(visited[nr][nc][1]) continue;
					if(arr[nr][nc]=='.'||arr[nr][nc]=='S') {
						visited[nr][nc][1] = true;
						visited[nr][nc][0] = true;
						queue.add(new node(nr, nc, 0, true));
					}
				}
			}
			// 도치의 경우
			else {
				for (int k = 0; k < 4; k++) {
					int nr = now.r + dir[k][0];
					int nc = now.c + dir[k][1];
					if(nr<0||nc<0||nr>=R||nc>=C) continue;
					if(visited[nr][nc][0]) continue;
					if(visited[nr][nc][1]) continue;
					if(arr[nr][nc]=='.') {
						visited[nr][nc][0] = true;
						queue.add(new node(nr, nc, now.dist+1, false));
					}
					else if(arr[nr][nc] == 'D') {
						System.out.println(now.dist+1);
						return;
					}
				}
			}
		}
		System.out.println("KAKTUS");
	}
}