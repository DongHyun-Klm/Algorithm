import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int[][] arr = new int[9][9];
			Set<Integer> set = new HashSet<>();
			boolean flag = false;

			// 배열 받기
			for (int j = 0; j < 9; j++) {
				for (int j2 = 0; j2 < 9; j2++) {
					arr[j][j2] = sc.nextInt();
				}
			}

			// 행검사
			for (int j = 0; j < arr.length; j++) {
				for (int j2 = 0; j2 < arr.length; j2++) {
					set.add(arr[j][j2]);
				}
				if (set.size() != 9) {
					flag = true;
					break;
				}
				set.clear();
			}

			// 열검사
			if (flag == false) {
				for (int j = 0; j < arr.length; j++) {
					for (int j2 = 0; j2 < arr.length; j2++) {
						set.add(arr[j2][j]);
					}
					if (set.size() != 9) {
						flag = true;
						break;
					}
					set.clear();
				}
			}

			if (flag == false) {
				// 격자검사
				outer: for (int j = 0; j < 3; j++) {
					for (int j2 = 0; j2 < 3; j2++) {

						for (int k = 3 * j; k < 3 + 3 * j; k++) {
							for (int k2 = 3 * j2; k2 < 3 + 3 * j2; k2++) {
								set.add(arr[k][k2]);
							}
						}
						if (set.size() != 9) {
							flag = true;
							break outer;
						}
						set.clear();
					}
				}
			}

			if (flag) {
				System.out.printf("#%d %d\n",i,0);
			}
			else {
				System.out.printf("#%d %d\n",i,1);
			}
		}
	}
}
