import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] nums, select;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt();
		nums = new int[N+1]; select = new int[N+1];
		sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		NM(1);
		System.out.println(sb.toString());
	}
	private static void NM(int d) {
		if(d == M+1) {
			for (int i = 1; i <= M; i++) {
				sb.append(select[i]).append(' ');
			}
			sb.append('\n');
		}
		else {
			int last=0;
			for (int i = 1; i <= N; i++) {
				if(last == nums[i])continue;
				select[d] = nums[i];
				last = nums[i];
				NM(d+1);
			}
		}
	}
	
}