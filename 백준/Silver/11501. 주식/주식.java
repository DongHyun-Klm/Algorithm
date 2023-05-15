import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		while (T-->0) {
			int N = sc.nextInt(), max =0;
			long ans = 0;
			int[] arr = new int[N];
			for(int i=0;i<N;i++) arr[i] = sc.nextInt();
			for (int i = N-1; i >= 0; i--) {
				max = Math.max(max, arr[i]);
				ans += max - arr[i];
			}
			sb.append(ans).append('\n');
		}
		System.out.print(sb.toString());
	}
}