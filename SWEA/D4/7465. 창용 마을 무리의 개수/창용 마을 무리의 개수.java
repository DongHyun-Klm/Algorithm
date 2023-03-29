import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static int N, M;
	static int[] P;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			N = sc.nextInt(); M = sc.nextInt();
			P = new int[N+1];
			for (int i = 1; i <= N; i++) {
				P[i] = i;
			}
			for (int i = 0; i < M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				if(x > y) {
					int temp = x;
					x = y;
					y = temp;
				}
				int nx = findSet(x);
				int ny = findSet(y);
				if(nx!=ny) union(nx, ny);
			}
			// 부모 다른애 세기
			Set<Integer> set = new HashSet<>();
			for (int i = 1; i <= N; i++) {
				set.add(findSet(i));
			}
			System.out.printf("#%d %d\n",tc+1,set.size());
		}
	}
	
	private static int findSet(int x) {
		if(x!=P[x]) {
			P[x] = findSet(P[x]);
			return P[x];
		}
		else return x;
	}

	private static void union(int nx, int ny) {
		P[ny] = nx;
	}
}