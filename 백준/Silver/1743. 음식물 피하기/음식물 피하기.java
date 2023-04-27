import java.util.Scanner;

public class Main {
	static int N, M, K, max, cnt;
	static int[][] arr, dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt(); K = sc.nextInt();
		arr = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < K; i++) {
			arr[sc.nextInt()-1][sc.nextInt()-1] = 1;
		}
		max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j]==1&&!visited[i][j]) {
					cnt = 0;
					DFS(i,j);
					max = Math.max(cnt, max);
				}
			}
		}
		System.out.println(max);
	}
	private static void DFS(int r, int c) {
		cnt++;
		visited[r][c] = true;
		for (int k = 0; k < 4; k++) {
			int nr = r + dir[k][0];
			int nc = c + dir[k][1];
			if(nr>=N||nc>=M||nr<0||nc<0||visited[nr][nc]) continue;
			if(arr[nr][nc]==1) DFS(nr,nc);
		}
	}
}