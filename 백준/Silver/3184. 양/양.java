import java.util.Scanner;

public class Main {
	static int R, C, sheep, wolf;
	static char[][] arr;
	static boolean[][] visited;
	static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt(); C = sc.nextInt();
		int[] count = new int[2];
		arr = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			arr[i] = sc.next().toCharArray();
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(visited[i][j]) continue;
				if(arr[i][j]!= '#') {
					sheep = 0; wolf = 0;
					DFS(i,j);
					if(sheep>wolf)count[0] += sheep;
					else count[1] += wolf;
				}
			}
		}
		System.out.println(count[0] + " " + count[1]);
	}
	private static void DFS(int r, int c) {
		visited[r][c] = true;
		if(arr[r][c] == 'v') wolf++;
		if(arr[r][c] == 'o') sheep++;
		for (int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if(nr>=0 && nc>=0 && nr<R && nc<C && !visited[nr][nc] && arr[nr][nc]!= '#')
				DFS(nr, nc);
		}
	}
}