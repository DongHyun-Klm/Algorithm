import java.util.Scanner;

public class Solution {
	static int N,B,min;
	static int[] clerk;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); B = sc.nextInt();
			clerk = new int[N+1]; min = Integer.MAX_VALUE;
			chk = new boolean[N+1];
			for (int i = 1; i <= N; i++) {
				clerk[i] = sc.nextInt();
			}
			search(1);
			System.out.printf("#%d %d\n",tc,min - B);
		}
	}
	// B 이상인 탑 중에서 차이가 가장 작은 것을 구하는 메서드
	private static void search(int d) {
		if(d == N+1) {
			int sum = 0;
			for (int i = 1; i < chk.length; i++) {
				if(chk[i]) sum += clerk[i];
			}
			if(sum>=B) min = Math.min(min, sum);
		}
		else {
			chk[d] = true;
			search(d+1);
			chk[d] = false;
			search(d+1);
		}
	}
}