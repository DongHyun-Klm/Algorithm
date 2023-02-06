import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
			}
			int sum = 0;
			for (int j : arr) {
				sum += j;
			}
			double avg = sum/N;
			int cnt=0;
			for (int j : arr) {
				if(j<=avg)cnt++;
			}
			System.out.printf("#%d %d\n",i,cnt);
		}
	}
}
