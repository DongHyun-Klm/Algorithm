import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N, K, cnt;
	static int[][] arr;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			cnt = Integer.MIN_VALUE;
			int max = Integer.MIN_VALUE;
			int ans = Integer.MIN_VALUE;
			arr = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
					max = Math.max(max, arr[i][j]);
				}
			}
			ArrayList<Integer> start = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == max) {
						start.add(i);
						start.add(j);
					}
				}
			}
			for (int i = 0; i < start.size()/2; i++) {
				cnt = 0;
				visited[start.get(2 *i)][start.get(2*i+1)] = true;
				DFS(start.get(2 *i), start.get(2*i+1), 0, false);
				for (int j = 0; j < N; j++) {
					Arrays.fill(visited[j], false);
				}
				ans = Math.max(cnt, ans);
			}
			System.out.printf("#%d %d\n",tc,ans+1);
		}
	}

	private static void DFS(int r, int c, int d, boolean chk) {
		cnt = Math.max(d, cnt);
		// 땅 판적 있다면
			if (chk) {
				for (int k = 0; k < 4; k++) {
					int nr = r + dir[k][0];
					int nc = c + dir[k][1];
					if (nr<0||nc<0||nr>=N||nc>=N||visited[nr][nc])continue;
					if(arr[nr][nc] < arr[r][c]) {
						visited[nr][nc] = true;
						DFS(nr, nc, d+1, chk);
						visited[nr][nc] = false;
					}
				}
			}
			// 아직 땅 판적 없다면
			else {
				for (int k = 0; k < 4; k++) {
					int nr = r + dir[k][0];
					int nc = c + dir[k][1];
					if (nr<0||nc<0||nr>=N||nc>=N||visited[nr][nc])continue;
					// 나보다 작으면 내려가기
					if(arr[nr][nc] < arr[r][c]) {
						visited[nr][nc] = true;
						DFS(nr, nc, d+1, false);
						visited[nr][nc] = false;
					}
					// 나보다 크거나 같으면 깍아서 내려가기
					for (int i = 1; i <= K; i++) {
						if(arr[nr][nc]-i < arr[r][c]) {
							arr[nr][nc] -= i;
							visited[nr][nc] = true;
							DFS(nr, nc, d+1, true);
							arr[nr][nc] += i;
							visited[nr][nc] = false;
						}
					}
				}
			}
		}

}