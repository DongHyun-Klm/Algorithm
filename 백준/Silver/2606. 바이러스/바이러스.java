import java.util.Scanner;

public class Main {
	static boolean[] visited;
	static int N, M, cnt;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt();
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		cnt = 0;
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		DFS(1);
		System.out.println(cnt);
	}
	private static void DFS(int i) {
		visited[i] = true;
		for (int j = 1; j <= N; j++) {
			if(arr[i][j] == 1 && !visited[j]) {
				DFS(j);
				cnt++;
			}
		}
	}
}