import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt(), M = sc.nextInt();
			int[] arr1 = new int[N];
			int[] arr2 = new int[M];
			int[] cnt = new int[N+M+1];
			for (int j = 1; j <= N; j++) {
				arr1[j-1] = j;
			}
			for (int j = 1; j <= M; j++) {
				arr2[j-1] = j;
			}
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					cnt[arr1[j]+arr2[j2]]++;
				}
			}
			int max = Integer.MIN_VALUE;
			for (int j : cnt) {
				max = Math.max(j, max);
			}
			System.out.print("#"+(i+1)+" ");
			for (int j = 0; j < cnt.length; j++) {
				if(cnt[j]==max)System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}
