import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		visited = new boolean[N][N];
		int tallest = 0, max = 0, cnt; 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				tallest = Math.max(tallest, arr[i][j]);
			}
		}
		// 1부터 가장 큰 건물 아래까지
		for (int i = 0; i <tallest; i++) {
			// visited 초기화, cnt 초기화
			for (int j = 0; j < N; j++) {
				Arrays.fill(visited[j], false); 
			}
			cnt = 0;
			// 조건보고 DFS출발
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if(arr[j][j2] > i && !visited[j][j2]) {
						cnt++;
						DFS(j,j2,i);
					}
				}
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}
	private static void DFS(int r, int c, int rain) {
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if(nr>=0 && nc>=0 && nr<N && nc<N && arr[nr][nc]>rain && !visited[nr][nc]) 
				DFS(nr, nc, rain);
		}
	}
}