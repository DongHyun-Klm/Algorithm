import java.util.Scanner;

public class Main {
	static int N, M, ans = 1;
	static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	static boolean[][] arr, visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt();
		arr = new boolean[N][M]; visited = new boolean[N][M];
		int r = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(sc.nextInt()==1)arr[i][j] = true;
			}
		}
		cleaner(r,c,d);
		System.out.println(ans);
	}
	private static void cleaner(int r, int c, int d) {
		while (true) {
			visited[r][c] = true;
			boolean flag = false;
			for (int k = 0; k < 4; k++) {
				int nr = r + dir[k][0];
				int nc = c + dir[k][1];
				if(nr<0||nc<0||nr>=N||nc>=M)continue;
				if(visited[nr][nc])continue;
				if(arr[nr][nc]) continue;
				flag = true;
				break;
			}
			//청소 갈 곳 없는 경우
			if(!flag) {
				int nr = r - dir[d][0];
				int nc = c - dir[d][1];
				if(nr>=0&&nc>=0&&nr<N&&nc<M&&!arr[nr][nc]) {
					r = nr; c = nc;
					continue;
				}
				else break;
			}
			//갈 곳 있는 경우
			d--;
			if(d==-1) d=3;
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			if(!arr[nr][nc]&&!visited[nr][nc]) {
				r = nr;
				c = nc;
				ans++;
			}
		}
	}
}