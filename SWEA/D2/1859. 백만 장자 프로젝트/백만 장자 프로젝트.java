import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int[] chk = new int[N];
			for (int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
			}
			
			long sum = 0;
			int max = Integer.MIN_VALUE;
			for (int j = arr.length-1; j >=0 ; j--) {
				if (arr[j]>max) max = arr[j];
				else sum += max - arr[j];
			}
			System.out.printf("#%d %d\n",i,sum);
		}
	}
}
