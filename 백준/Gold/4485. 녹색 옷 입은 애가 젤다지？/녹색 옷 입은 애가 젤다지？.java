import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 1;
		while (true) {
			int N = sc.nextInt();
			if (N == 0) break;
			int[][] arr = new int[N][N];
			for (int i = 0; i < arr.length; i++) 
				for (int j = 0; j < arr.length; j++) 
					arr[i][j] = sc.nextInt();
			int[][] dist = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			for (int i = 0; i < dist.length; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			dist[0][0] = arr[0][0];
			for (int i = 0; i < N*N-1; i++) {
				int idx_r = -1;
				int idx_c = -1;
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < dist.length; j++) {
					for (int j2 = 0; j2 < dist.length; j2++) {
						if(!visited[j][j2]&&min>dist[j][j2]) {
							idx_r = j;
							idx_c = j2;
							min = dist[j][j2];
						}
					}
				}
				visited[idx_r][idx_c] = true;
				for (int k = 0; k < 4; k++) {
					int nr = idx_r + dir[k][0];
					int nc = idx_c + dir[k][1];
					if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
					if (visited[nr][nc]) continue;
					if(min+arr[nr][nc] < dist[nr][nc]) 
						dist[nr][nc] = min+arr[nr][nc];
				}
			}
			System.out.printf("Problem %d: %d\n",count++,dist[N-1][N-1]);
		}
	}
}