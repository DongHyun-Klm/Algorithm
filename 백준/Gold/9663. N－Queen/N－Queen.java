import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, ans = 0;
	static int[] queen;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		queen = new int[N+1];
		chk = new boolean[N+1];
		dfs(1);
		System.out.println(ans);
	}
	private static void dfs(int d) {
		if(d==N+1) {
//			System.out.println(Arrays.toString(queen));
			if(!attackCan(d-1)) {
				ans++;
			}
		}
		else {
			for (int i = 1; i <= N; i++) {
				if(chk[i]) continue;
				queen[d] = i;
				if(attackCan(d)) continue;
				chk[i] = true;
				dfs(d+1);
				chk[i] = false;
			}
		}
	}
	
	private static boolean attackCan(int d) {
		for (int i = 1; i <= d-1; i++) {
			for (int j = i+1; j <= d; j++) {
				// 오른쪽 아래 대각
				if(i - queen[i] == j - queen[j]) return true;
				// 왼쪽 아래 대각
				if(i + queen[i] == j + queen[j]) return true;
			}
		}
		return false;
	}
}