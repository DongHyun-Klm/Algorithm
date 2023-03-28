import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] arr;
	static boolean[][] visited;
	static int w, h;
	static int[][] dir = {{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			w = sc.nextInt(); h = sc.nextInt();
			if(w==0 && h==0) break;
			int cnt = 0;
			arr = new int[h][w];
			visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++)	arr[i][j] = sc.nextInt();
			}
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++)	{
					// 땅이고 방문한적 없다면
					if(arr[i][j]==1 && !visited[i][j]) {
						cnt++;
						DFS(i,j);
					}
				}
			}
			System.out.println(cnt);
		}
	}
	// 8방향 보며 땅 찾기
	private static void DFS(int r, int c) {
		visited[r][c] = true;
		for (int i = 0; i < 8; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			// index검사, 땅인지 검사, 방문했는지 검사
			if(nr>=0 && nc>=0 && nr<h && nc<w && arr[nr][nc]==1 && !visited[nr][nc]) 
				DFS(nr, nc);
		}
	}
}