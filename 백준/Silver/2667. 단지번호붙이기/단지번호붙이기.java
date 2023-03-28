import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int N, cnt;
	static int[][] arr;
	static boolean[][] visited;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}}; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		visited = new boolean[N][N];
		ArrayList<Integer> danzi = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			char[] c = sc.next().toCharArray();
			for (int j = 0; j < N; j++) {
				arr[i][j] = c[j] - '0';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 방문안했고 1이면 dfs출발
				if(!visited[i][j] && arr[i][j] == 1) {
					cnt = 0;
					DFS(i, j);
					danzi.add(cnt);
				}
			}
		}
		Collections.sort(danzi);
		System.out.println(danzi.size());
		for (Integer integer : danzi) {
			System.out.println(integer);
		}
	}
	private static void DFS(int r, int c) {
		cnt++;
		visited[r][c] = true;
		if(arr[r][c] == 1) {
			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];
                // index확인, 1인지 확인, 방문했는지 확인
				if(nr>=0 && nc>=0 && nr<N && nc<N && arr[nr][nc] ==1 && !visited[nr][nc]) 
					DFS(nr, nc);
			}
		}
	}
}