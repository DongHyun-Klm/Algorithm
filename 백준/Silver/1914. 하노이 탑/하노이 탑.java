import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		BigInteger n = new BigInteger("1");
		int a = 1;
		if (N <= 20) {
			arr = new int[(N + 1)][][];
			arr[1] = new int[a][2];
			arr[1][0][0] = 1;
			arr[1][0][1] = 3;
		}
		for (int i = 2; i <= N; i++) {
			n = n.multiply(new BigInteger("2"));
			n = n.add(new BigInteger("1"));
			a = 2 * a + 1;
			if(N <= 20)arr[i] = new int[a][2];
		}
		if (N <= 20) {
			hanoi(1);
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < 2; j++) {
					sb.append(arr[N][i][j]).append(' ');
				}
				sb.append('\n');
			}
		}
		System.out.println(n);
		if (N <= 20)
			System.out.println(sb.toString());
	}

	private static void hanoi(int d) {
		if (d == N) {
			return;
		} else {
			// 앞
			for (int i = 0; i < arr[d].length; i++) {
				for (int j = 0; j < 2; j++) {
					if (arr[d][i][j] == 1)
						arr[d + 1][i][j] = 1;
					else if (arr[d][i][j] == 2)
						arr[d + 1][i][j] = 3;
					else
						arr[d + 1][i][j] = 2;
				}
			}
			// 중간
			arr[d + 1][arr[d].length][0] = 1;
			arr[d + 1][arr[d].length][1] = 3;
			// 뒤
			for (int i = arr[d].length + 1; i < 2 * arr[d].length + 1; i++) {
				for (int j = 0; j < 2; j++) {
					if (arr[d][i - (arr[d].length + 1)][j] == 1)
						arr[d + 1][i][j] = 2;
					else if (arr[d][i - (arr[d].length + 1)][j] == 2)
						arr[d + 1][i][j] = 1;
					else
						arr[d + 1][i][j] = 3;
				}
			}
			hanoi(d + 1);
		}
	}
}