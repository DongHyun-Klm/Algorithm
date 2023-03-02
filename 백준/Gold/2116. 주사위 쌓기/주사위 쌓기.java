import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] dice = new int[N][6];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 6; j++) {
				dice[i][j] = sc.nextInt();
			}
		}
		// 6경우 다 구하자;;
		int[] sum = new int[6];
		int max, point = -1;
		int[] idx = { 5, 3, 4, 1, 2, 0 };

		for (int k = 0; k < 6; k++) {
			for (int j = 0; j < N; j++) {
				// 처음에 dice[0][k]가 1번 주사위 밑면일때
				if (j == 0) point = k;
				// 두번째부터는 point의 반대편 숫자가 윗면
				else {
					for (int i = 0; i < 6; i++) {
						if (dice[j][i] == dice[j - 1][idx[point]]) {
							point = i;
							break;
						}
					}
				}
				max = 0;
				switch (point) {
				// AF가 위아래인 경우
				case 0:
				case 5:
					for (int i = 0; i < 6; i++) {
						if (i == 0 || i == 5)
							continue;
						max = Math.max(dice[j][i], max);
					}
					break;
				// BD가 위아래인 경우
				case 1:
				case 3:
					for (int i = 0; i < 6; i++) {
						if (i == 1 || i == 3)
							continue;
						max = Math.max(dice[j][i], max);
					}
					break;
				// CE가 위아래인 경우
				case 2:
				case 4:
					for (int i = 0; i < 6; i++) {
						if (i == 2 || i == 4)
							continue;
						max = Math.max(dice[j][i], max);
					}
					break;
				}
				sum[k] += max;
			}
		}

		
		System.out.println(Arrays.stream(sum).max().getAsInt());
	}
}