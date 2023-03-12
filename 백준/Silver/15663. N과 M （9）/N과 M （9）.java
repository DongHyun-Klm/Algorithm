import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static int N, M;
	static int[] nums, select;
	static boolean chk[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt(); 
		nums = new int[N+1]; select = new int[M+1]; chk = new boolean[N+1];
		for (int i = 1; i <= N; i++) nums[i] = sc.nextInt();
		Arrays.sort(nums);
		dfs(1);
		System.out.println(sb.toString());
	}
	private static void dfs(int d) {
		if(d==M+1) {
			for (int i = 1; i <= M; i++) {
				sb.append(select[i]+" ");
			}
			sb.append('\n');
		}
		else {
			int last = 0;
			for (int i = 1; i <= N; i++) {
				if(chk[i]) continue;
				// 같은 깊이에서는 같은 숫자를 고르지 않겠다
				if(last == nums[i]) continue;
				select[d] = nums[i];
				last = nums[i];
				chk[i] = true;
				dfs(d+1);
				select[d] = 0;
				chk[i] = false;
			}
		}
	}
}