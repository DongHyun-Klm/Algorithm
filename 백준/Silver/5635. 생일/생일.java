
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] maxbir = { 31, 12, 2010 };
		String[][] birth = new String[N][4];
		int[][] birnu = new int[N][3];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 4; j++) {
				birth[i][j] = sc.next();
			}
		}
		for (int j = 0; j < N; j++) {
			for (int j2 = 1; j2 < 4; j2++) {
				birnu[j][j2 - 1] = maxbir[j2 - 1] - Integer.parseInt(birth[j][j2]);
			}
		}

		int max1 = -1;
		for (int i = 0; i < N; i++) {
			max1 = max1 > birnu[i][2] ? max1 : birnu[i][2];
		}
		int max2 = -1;
		for (int i = 0; i < N; i++) {
			if (birnu[i][2] == max1)
				max2 = max2 > birnu[i][1] ? max2 : birnu[i][1];
		}
		int max3 = -1;
		for (int i = 0; i < N; i++) {
			if (birnu[i][2] == max1 && birnu[i][1] == max2)
				max3 = max3 > birnu[i][0] ? max3 : birnu[i][0];
		}

		int min1 = 10000;
		for (int i = 0; i < N; i++) {
			min1 = min1 < birnu[i][2] ? min1 : birnu[i][2];
		}
		int min2 = 10000;
		for (int i = 0; i < N; i++) {
			if (birnu[i][2] == min1)
				min2 = min2 < birnu[i][1] ? min2 : birnu[i][1];
		}
		int min3 = 10000;
		for (int i = 0; i < N; i++) {
			if (birnu[i][2] == min1 && birnu[i][1] == min2)
				min3 = min3 < birnu[i][0] ? min3 : birnu[i][0];
		}

		for (int i = 0; i < birnu.length; i++) {
			if (birnu[i][2] == min1 && birnu[i][1] == min2 && birnu[i][0] == min3) {
				System.out.println(birth[i][0]);
			}
		}

		for (int i = 0; i < birnu.length; i++) {
			if (birnu[i][2] == max1 && birnu[i][1] == max2 && birnu[i][0] == max3) {
				System.out.println(birth[i][0]);
			}
		}

	}

}
