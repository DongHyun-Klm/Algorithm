import java.util.Scanner;

public class Solution {
	static int[] taste, kal, select;
	static int maxHappy, L, N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			N = sc.nextInt(); maxHappy = Integer.MIN_VALUE;
			L = sc.nextInt();
			taste = new int[N];
			kal = new int[N];
			for (int j = 0; j < N; j++) {
				taste[j] = sc.nextInt();
				kal[j] = sc.nextInt();
			}
			// 최고의 맛을 찾기
			for (int j = 0; j < N; j++) {
				happy(0, j, kal[j], taste[j]);
			}
			System.out.printf("#%d %d\n",i,maxHappy);
		}
	}

	private static void happy(int idx, int start, int k, int t) {
		// kal이 제한 칼로리를 넘으면 중지
		if(k > L) return;
		// 제한 칼로리를 안넘었다면
		else {
			// maxhappy와 비교
			maxHappy = Math.max(maxHappy, t);
			// 다음 먹을꺼 찾기
			for (int i = start+1; i < N; i++) {
				happy(idx+1, i, k + kal[i], t + taste[i]);
			}
		}
	}
}