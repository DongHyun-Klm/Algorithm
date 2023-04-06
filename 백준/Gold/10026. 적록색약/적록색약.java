import java.util.Scanner;

public class Main {
	static int N;
	static char[][] arr;
	static boolean[][][] visited;
	static int[] count;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new char[N][N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next().toCharArray();
		}
		count = new int[2];
		visited = new boolean[N][N][2];
		// 일반 사람
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j][0]) {
					count[0]++;
					DFS1(i,j);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j] == 'R') arr[i][j] = 'G';
			}
		}
		// 색약
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j][1]) {
					count[1]++;
					DFS2(i,j);
				}
			}
		}
		System.out.print(count[0] + " " + count[1]);
	}
	private static void DFS1(int r, int c) {
		visited[r][c][0] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if(nr<0||nc<0||nr>=N||nc>=N) continue;
			if(visited[nr][nc][0]) continue;
			if(arr[r][c] ==  arr[nr][nc]) DFS1(nr, nc);
		}
	}
	private static void DFS2(int r, int c) {
		visited[r][c][1] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if(nr<0||nc<0||nr>=N||nc>=N) continue;
			if(visited[nr][nc][1]) continue;
			if(arr[r][c] ==  arr[nr][nc]) DFS2(nr, nc);
		}
		
	}
}