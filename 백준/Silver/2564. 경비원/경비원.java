import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt(), col = sc.nextInt();
		int sum = 2 * row + 2 * col;
		int N = sc.nextInt(), disc = 0;
		int[][] arr = new int[N][2];
		// 1은 블록의 북쪽, 2는 블록의 남쪽, 3은 블록의 서쪽, 4는 블록의 동쪽
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		int dir = sc.nextInt(), dic = sc.nextInt();
		// 하드코딩 이게 맞나;;
		if (dir == 1) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i][0] == 1) {
					disc += Math.abs(arr[i][1] - dic);
				}
				if (arr[i][0] == 2) {
					int temp = col + arr[i][1] + dic;
					if (temp > (sum / 2))
						temp = sum - temp;
					disc += temp;
				}
				if (arr[i][0] == 3) {
					disc += arr[i][1] + dic;
				}
				if (arr[i][0] == 4) {
					disc += arr[i][1] + row - dic;
				}
			}
		}
		if (dir == 2) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i][0] == 1) {
					int temp = col + arr[i][1] + dic;
					if (temp > (sum / 2))
						temp = sum - temp;
					disc += temp;
				}
				if (arr[i][0] == 2) {
					disc += Math.abs(arr[i][1] - dic);
				}
				if (arr[i][0] == 3) {
					disc += col - arr[i][1] + dic;
				}
				if (arr[i][0] == 4) {
					disc += col - arr[i][1] + row - dic;
				}
			}
		}
		if (dir == 3) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i][0] == 1) {
					disc += arr[i][1] + dic;
				}
				if (arr[i][0] == 2) {
					disc += arr[i][1] + col - dic;
				}
				if (arr[i][0] == 3) {
					disc += Math.abs(arr[i][1] - dic);
				}
				if (arr[i][0] == 4) {
					int temp = row + arr[i][1] + dic;
					if (temp > (sum / 2))
						temp = sum - temp;
					disc += temp;
				}
			}
		}
		if (dir == 4) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i][0] == 1) {
					disc += row - arr[i][1] + dic;
				}
				if (arr[i][0] == 2) {
					disc += row - arr[i][1] + col - dic;
				}
				if (arr[i][0] == 3) {
					int temp = row + arr[i][1] + dic;
					if (temp > (sum / 2))
						temp = sum - temp;
					disc += temp;
				}
				if (arr[i][0] == 4) {
					disc += Math.abs(arr[i][1] - dic);

				}
			}
		}
		System.out.println(disc);
	}
}
