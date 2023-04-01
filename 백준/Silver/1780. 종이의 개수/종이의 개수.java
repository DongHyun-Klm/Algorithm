import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int N;
	static boolean[][] visited;
	static int[] cnt = new int[3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		paper(N, 0, 0);
		for (int i = 0; i < 3; i++) {
			System.out.println(cnt[i]);
		}
	}

	private static void paper(int n, int r, int c) {
//		if (n == 1)
//			return;
		int num = arr[r][c];
		boolean flag = true;
		o: for (int i = r; i < r + n; i++) {
			for (int j = c; j < c + n; j++) {
				if (arr[i][j] != num) {
					flag = false;
					break o;
				}
			}
		}
		if (flag)
			cnt[num + 1]++;
		else {
			// 9개 영역
			for (int i = 0; i < 9; i++) {
				// 탐색 시작점
				int nr = (i / 3 * n / 3) % n + r;
				int nc = (i * n / 3) % n + c;
				paper(n / 3, nr, nc);
			}
		}
	}
}