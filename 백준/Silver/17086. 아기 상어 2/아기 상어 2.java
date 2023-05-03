import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class info{
		int r, c, dist;
		info (int r, int c, int dist){
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
	static int N, M;
	static int[][] arr;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt();
		arr = new int[N][M];
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j]==0) {
					max = Math.max(max, bfs(i,j));
				}
			}
		}
		System.out.println(max);
	}
	private static int bfs(int r, int c) {
		boolean[][] visited = new boolean[N][M];
		Queue<info> q = new LinkedList<>();
		q.add(new info(r, c, 0));
		visited[r][c] = true;
		while (!q.isEmpty()) {
			info now = q.poll();
			for (int k = 0; k < 8; k++) {
				int nr = now.r + dir[k][0];
				int nc = now.c + dir[k][1];
				if(nr<0||nc<0||nr>=N||nc>=M) continue;
				if(visited[nr][nc]) continue;
				if(arr[nr][nc]==1) {
					return now.dist+1;
				}
				else {
					q.add(new info(nr, nc, now.dist+1));
					visited[nr][nc] = true;
				}
			}
		}
		return 0;
	}
}