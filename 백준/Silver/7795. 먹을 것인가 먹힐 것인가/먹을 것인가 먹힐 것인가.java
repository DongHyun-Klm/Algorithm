import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-->0) {
			int N = sc.nextInt(), M = sc.nextInt(); ans = 0;
			int[] A = new int[N+1];
			int[] B = new int[M+1];
			for(int i=1; i<=N; i++) A[i] = sc.nextInt();
			for(int i=1; i<=M; i++) B[i] = sc.nextInt();
			Arrays.sort(A); Arrays.sort(B);
			for (int i = 1; i < A.length; i++) {
				ans += BinarySearch(1,M,A[i],B);
			}
			System.out.println(ans);
		}
	}
	private static int BinarySearch(int start, int end, int s, int[] b) {
		if(start>end) return end;
		int mid = (start + end) / 2;
		if(b[mid]>=s) return BinarySearch(start, mid-1, s, b);
		else return BinarySearch(mid+1, end, s, b);
	}
}