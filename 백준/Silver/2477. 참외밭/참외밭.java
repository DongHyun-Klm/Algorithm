import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] cnt = new int[5];
		int[][] arr = new int[6][2];
		int big_r = Integer.MIN_VALUE, small_r = Integer.MAX_VALUE, big_c = Integer.MIN_VALUE,
				small_c = Integer.MAX_VALUE;

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < 6; i++) {
			cnt[arr[i][0]]++;
		}

		for (int i = 0; i < 6; i++) {
			if (cnt[arr[i][0]] == 1) {
				if (arr[i][0] < 3)
					big_r = arr[i][1];
				else
					big_c = arr[i][1];
			}
		}

		for (int i = 0; i < 6; i++) {
			if (i == 0) {
				if (cnt[arr[i][0]] == 2) {
					if (arr[5][1] == big_c || arr[5][1] == big_r) {
						if (arr[5][0] < 3) {
							small_c = big_c - arr[i][1];
							small_r = arr[i + 1][1];
						}
						else {
							small_r = big_r - arr[i][1];
							if (i < 5) {
								small_c = arr[i + 1][1];
							} else {
								small_c = arr[0][1];
							}
						}
					}
				}
			}

			else if (cnt[arr[i][0]] == 2) {
				if (arr[i - 1][1] == big_c || arr[i - 1][1] == big_r) {
					if (arr[i - 1][0] < 3) {
						small_c = big_c - arr[i][1];
						if (i < 5) {
							small_r = arr[i + 1][1];
						} else {
							small_r = arr[0][1];
						}
					}
					else {
						small_r = big_r - arr[i][1];
						if (i < 5) {
							small_c = arr[i + 1][1];
						} else {
							small_c = arr[0][1];
						}
					}
				}
			}
		}
//		System.out.printf("%d %d %d %d", big_r, big_c, small_r, small_c);
		System.out.print(N * ((big_r * big_c) - (small_r * small_c)));

	}
}
