import java.util.Scanner;

public class Solution {
	static int[] nums;
	static int N,K, ans;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); K = sc.nextInt(); ans = 0;
			nums = new int[N];
			chk = new boolean[N];
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			search(0);
			System.out.printf("#%d %d\n",tc,ans);
		}
	}
	private static void search(int i) {
		if(i == N) {
			int sum = 0;
			for (int j = 0; j < chk.length; j++) {
				if(chk[j]) sum += nums[j];
			}
			if(sum == K) ans++;
		}
		else {
			chk[i] = true;
			search(i+1);
			chk[i] = false;
			search(i+1);
		}
	}
}