import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[100][100];
		int sum = 0;
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt(), y = sc.nextInt();
			for (int j = x; j < x + 10; j++) {
				for (int j2 = y; j2 < y + 10; j2++) {
					arr[j][j2] = 1;
				}
			}
		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				sum += arr[i][j];
			}
		}
		System.out.println(sum);
	}
}
