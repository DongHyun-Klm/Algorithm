import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int[] p;
	static int[] rank;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(), E = sc.nextInt();
		p = new int[V + 1];
		rank = new int[V+1];
		for (int i = 1; i < p.length; i++) {
			p[i] = i;
		}
		int[][] arr = new int[E][3];
		for (int i = 0; i < E; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		int ans = 0;
		int pick = 0;
		for (int i = 0; i < E; i++) {
			int x = arr[i][0];
			int y = arr[i][1];
			if (findSet(x) != findSet(y)) {
				ans += arr[i][2];
				pick++;
				union(x, y);
			}
			if (pick == V - 1)
				break;
		}
		System.out.println(ans);
	}

	private static void union(int x, int y) {
		if (rank[x] > rank[y])
			p[findSet(y)] = findSet(x);
		else {
			p[findSet(x)] = findSet(y);
			rank[y]++;
		}
	}

	private static int findSet(int x) {
		if (x != p[x])
			p[x] = findSet(p[x]);
		return p[x];
	}
}