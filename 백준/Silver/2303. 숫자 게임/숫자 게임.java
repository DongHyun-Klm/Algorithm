import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][5];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 5; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int[] max = new int[N];
		for (int i = 0; i < N; i++) {
			// 3개수 고르기
			for (int j = 0; j < 3; j++) {
				for (int j2 = j+1; j2 < 4; j2++) {
					for (int k = j2+1; k < 5; k++) {
						max[i] = Math.max(max[i], (arr[i][j]+arr[i][j2]+arr[i][k])%10);
					}
				}
			}
		}
		for (int i = N-1; i >= 0; i--) {
			if(max[i]==Arrays.stream(max).max().getAsInt()) {
				System.out.println(i+1);
				break;
			}
		}
	}
}