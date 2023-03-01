import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 빙고 담을 배열
		int[][] arr = new int[5][5];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		// 빙고 카운트, 몇 번째 수에 빙고 외치는지 카운트
		int cnt = 0, count = 0;

		while (cnt <= 2) {
			cnt = 0;
			count++;
			// 부르는 숫자
			int number = sc.nextInt();
			// 숫자를 찾아서 0으로 만들고 break
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (arr[i][j] == number) {
						arr[i][j] = 0;
						break;
					}
				}
			}
			// 빙고를 찾자
			// 가능한 빙고 수는 12개 > 델타 쓰지 말고 그냥 직접 찾자
			// 다 더해서 0이면 빙고
			int sum;
			// 행 검사
			for (int i = 0; i < arr.length; i++) {
				sum = 0;
				sum = arr[i][0] + arr[i][1] + arr[i][2] + arr[i][3] + arr[i][4];
				if (sum == 0)
					cnt++;
			}
			// 열 검사
			for (int i = 0; i < arr.length; i++) {
				sum = 0;
				sum = arr[0][i] + arr[1][i] + arr[2][i] + arr[3][i] + arr[4][i];
				if (sum == 0)
					cnt++;
			}
			// 좌 대각
			sum = 0;
			sum = arr[0][0] + arr[1][1] + arr[2][2] + arr[3][3] + arr[4][4];
			if (sum == 0)
				cnt++;
			// 우 대각
			sum = 0;
			sum = arr[0][4] + arr[1][3] + arr[2][2] + arr[3][1] + arr[4][0];
			if (sum == 0)
				cnt++;
		}
		System.out.println(count);
	}
}