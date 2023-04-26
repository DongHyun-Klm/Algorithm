import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][] arr;
	static int N,M,K,x2,y2;
	static int[][] visited;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static class info{
		int r, c;
		info(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr= new char[N][M]; visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken())-1, y1 = Integer.parseInt(st.nextToken())-1;
		x2 = Integer.parseInt(st.nextToken())-1; y2  = Integer.parseInt(st.nextToken())-1;
		BFS(x1, y1);
	}
	private static void BFS(int x1, int y1) {
		Queue<info> q = new LinkedList<>();
		q.add(new info(x1, y1));
		visited[x1][y1] = 1;
		while (!q.isEmpty()) {
			info now = q.poll();
			for (int k = 0; k < 4; k++) {
				for (int i = 1; i <= K; i++) {
					int nr = now.r + dir[k][0] * i;
					int nc = now.c + dir[k][1] * i;
					if(nr>=N||nc>=M||nr<0||nc<0) break;
					if(arr[nr][nc]=='#') break;
					if(visited[nr][nc]!=0&&visited[nr][nc]<=visited[now.r][now.c]) break;
					if(visited[nr][nc]!=0) continue;
					if(nr==x2&&nc==y2) {
						System.out.println(visited[now.r][now.c]);
						return;
					}
					q.add(new info(nr, nc));
					visited[nr][nc] = visited[now.r][now.c] + 1;
				}
			}
		}
		System.out.println(-1);
	}
}