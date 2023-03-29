import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			p = new int[V + 1];
			int[][] arr = new int[E][3];
			for (int i = 0; i < E; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
				arr[i][2] = sc.nextInt();
			}
			Arrays.sort(arr, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});
			for (int i = 1; i <= V; i++) {
				p[i] = i;
			}
			long ans = 0;
			int pick = 0;
			int i = 0;
			while (pick != V - 1) {
				int nx = findSet(arr[i][0]);
				int ny = findSet(arr[i][1]);
				if (nx != ny) {
					union(nx, ny);
					ans += arr[i][2];
					pick++;
				}
				i++;
			}
			System.out.printf("#%d %d\n", tc + 1, ans);
		}
	}

	private static int findSet(int i) {
		if (i == p[i])
			return i;
		p[i] = findSet(p[i]);
		return p[i];
	}

	private static void union(int nx, int ny) {
		if (nx > ny)
			p[ny] = nx;
		else
			p[nx] = ny;
	}
}