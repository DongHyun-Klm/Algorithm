import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class swea2001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt(), M=sc.nextInt();
			int[][] arr = new int[2*N-1][2*N-1];
			
			for (int j = 0; j < N; j++) { //배열 받기
				for (int j2 = 0; j2 < N; j2++) {
					arr[j][j2] = sc.nextInt();
				}
			}
//			for (int j = 0; j < arr.length; j++) {
//				System.out.println(Arrays.toString(arr[j]));
//			}
			
			int max = 0;
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					//j, j2는 시작 좌표 k, k2는 파리채
					int sum = 0;
					for (int k = 0; k < M; k++) {
						for (int k2 = 0; k2 < M; k2++) {
							sum += arr[j+k][j2+k2];
							max = (sum > max) ? sum : max;
						}
					}
				}
			}
			System.out.printf("#%d %d\n",i,max);
		}
	}
}
