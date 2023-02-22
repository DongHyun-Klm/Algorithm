import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			sc.nextLine();
			int[][] arr = new int[N][N];
			int sum = 0;
			for (int j = 0; j < arr.length; j++) {
				char[] cr = sc.nextLine().toCharArray();
				for (int j2 = 0; j2 < arr.length; j2++) {
					arr[j][j2] = cr[j2]-'0';
				}
			}
			
			// 첫 줄부터 가운데 줄 까지
			for (int j = 0; j <= N; j++) { // 0 1 2 3 4
				for (int j2 = Math.abs(j-N/2); j2 < Math.abs(j-N/2) + N - 2*Math.abs(j-N/2); j2++) { // Math.abs(j-N/2) : 2 1 0 1 2
					sum += arr[j][j2];      // 5 - 2*Math.abs(j-N/2) : 1 3 5 3 1
				}
			}
			System.out.printf("#%d %d\n",i+1,sum);
		}
	}
}
