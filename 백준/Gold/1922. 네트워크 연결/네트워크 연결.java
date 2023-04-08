import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		p = new int[N+1];
		for(int i=1;i<=N;i++) p[i] = i;
		int[][] arr = new int[M][3];
		for (int i = 0; i < M; i++) {
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
		int pick = 0;
		int ans = 0;
		for (int i = 0; i < M; i++) {
			int x = findSet(arr[i][0]);
			int y = findSet(arr[i][1]);
			if(x != y) {
				pick++;
				ans += arr[i][2];
				union(x, y);
			}
			if(pick == N-1) break;
		}
		System.out.println(ans);
	}

	private static void union(int x, int y) {
		p[x] = y;
	}

	private static int findSet(int i) {
		if(i != p[i]) p[i] = findSet(p[i]);
		return p[i];
	}
}