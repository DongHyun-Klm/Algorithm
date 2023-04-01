import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][2];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < N; j++) {
					arr[j][i] = sc.nextInt();
				}
			}
			double E = sc.nextDouble();
			long[][] edge = new long[N*(N-1)/2][3];
			p = new int[N];
			for (int i = 0; i < N; i++) {
				p[i] = i;
			}
			int cnt = 0;
			for (int i = 1; i < N; i++) {
				for (int j = 0; j < i; j++) {
					edge[cnt][0] = i;
					edge[cnt][1] = j;
					edge[cnt][2] = (long) (Math.pow(arr[i][0] - arr[j][0], 2) + Math.pow(arr[i][1] - arr[j][1], 2));
					cnt++;
				}
			}
			Arrays.sort(edge, new Comparator<long[]>() {
				@Override
				public int compare(long[] o1, long[] o2) {
					return Long.compare(o1[2], o2[2]);
				}
			});

			// 크루스칼
			int pick = 0;
			long ans = 0;
			for (int i = 0; i < edge.length; i++) {
				if (findSet((int)edge[i][1]) == findSet((int)edge[i][0]))
					continue;
				ans += edge[i][2];
				union(findSet((int)edge[i][1]), (int) edge[i][0]);
				pick++;
				if (pick == N - 1) break;
			}
			System.out.printf("#%d %d\n", tc + 1, Math.round(ans * E));
		}
	}

	private static void union(int i, int j) {
		p[findSet(j)] = findSet(i);
	}

	private static int findSet(int i) {
		if (i != p[i])
			p[i] = findSet(p[i]);
		return p[i];
	}
}