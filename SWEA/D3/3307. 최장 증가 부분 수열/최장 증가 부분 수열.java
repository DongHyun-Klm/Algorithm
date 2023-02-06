import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int[] cnt = new int[N];
			cnt[0] = 1;
			for (int j = 0; j < arr.length; j++) {
				arr[j] = sc.nextInt();
			}

			int lis = 0;
			for (int j = 1; j < arr.length; j++) {
				int max = 0;
				for (int j2 = j - 1; j2 >= 0; j2--) {
					if (arr[j] >= arr[j2]) {
						max = max > cnt[j2] ? max : cnt[j2];
					}
				}
				cnt[j] = max + 1;
				lis = lis > cnt[j] ? lis : cnt[j];
			}
			System.out.printf("#%d %d\n",i,lis);
		}
	}
}
