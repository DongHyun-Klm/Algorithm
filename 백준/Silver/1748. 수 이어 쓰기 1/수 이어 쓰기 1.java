import java.util.Scanner;

public class Main {
	static long count = 0;
	static int N, M, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = Integer.toString(N).length();
		dfs(1);
		System.out.println(ans);
	}

	private static void dfs(int d) {
		if (d == M) {
			ans += ((N - Math.pow(10, d-1)+1)) * d;
		} else {
			ans += 9 * Math.pow(10, d-1) * d;
			dfs(d+1);
		}
	}
}