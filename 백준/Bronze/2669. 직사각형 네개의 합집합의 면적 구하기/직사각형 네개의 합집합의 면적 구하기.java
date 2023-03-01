import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[100][100];
		for (int t = 0; t < 4; t++) {
			int x1 = sc.nextInt() - 1, y1 = sc.nextInt() - 1;
			int x2 = sc.nextInt() - 1, y2 = sc.nextInt() - 1;
			for (int i = y1; i < y2; i++) {
				for (int j = x1; j < x2; j++) {
					arr[i][j] = 1;
				}
			}
		}
		// 합 구하기
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				sum += arr[i][j];
			}
		}
		System.out.println(sum);
	}
}