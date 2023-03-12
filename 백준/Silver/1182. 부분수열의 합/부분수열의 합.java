import java.util.Scanner;

public class Main {
	static int[] nums, select;
	static int N, S, ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); S = sc.nextInt();
		nums = new int[N+1];
		select = new int[N+1];
		for (int i = 1; i <= N; i++) {
			nums[i] = sc.nextInt();
		}
		dfs(1, 1);
		System.out.println(ans);
	}
	private static void dfs(int d, int start) {
		if(d == N+1) {
			return;
		}
		else {
			for (int i = start; i <= N; i++) {
				select[d] = nums[i];
				anschk();
				dfs(d+1, i+1);
				select[d] = 0;
			}
		}
	}
	private static void anschk() {
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += select[i];
		}
		if(sum==S) ans++;
	}
}