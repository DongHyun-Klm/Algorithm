import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static int[] nums;
	private static int N;
	private static int K;
	private static int ans;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		nums = new int[K];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = sc.nextInt();
		}
		// k 정렬
		Arrays.sort(nums);
		dfs(0);
		System.out.println(ans);
	}

	private static void dfs(int now) {
		if(now>N) return;
		
		if(ans<now) ans=now;
		
		for (int i = K-1; i > -1; i--) {
			dfs(now*10+nums[i]);
		}
	}

}