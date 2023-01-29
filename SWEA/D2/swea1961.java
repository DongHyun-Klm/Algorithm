import java.util.Arrays;
import java.util.Scanner;

public class swea1961 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int[][][] pri = new int[3][N][N];
			int[] numbers = new int[N*N];
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					arr[j][j2] = sc.nextInt();
				}
			}
			
			for (int j = 0, count=0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++,count++) {
					numbers[count] = arr[j][j2];
				}
			}
			
			
			
			for (int j = N-1, count = 0; j >= 0; j--) {
				for (int j2 = 0; j2 < N; j2++, count++) {
					pri[0][j2][j] = numbers[count];
				}
			}
			
			for (int j = N-1 ,count = 0; j >= 0; j--) {
				for (int j2 = N-1; j2 >= 0; j2--, count++) {
					pri[1][j][j2] = numbers[count];
				}
			}
			
			for (int j = 0, count=0; j < N; j++) {
				for (int j2 = N-1; j2 >= 0; j2--, count++) {
					pri[2][j2][j] = numbers[count];
				}
			}
			
			System.out.println("#"+i);
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < 3; j2++) {
					for (int k = 0; k < N; k++) {
						System.out.print(pri[j2][j][k]);
					} System.out.print(" ");
				}
				System.out.println();
			}
			
		}
	}
}
