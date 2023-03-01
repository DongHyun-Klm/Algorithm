import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt(), R = sc.nextInt();
		int K = sc.nextInt();
		int[][] arr = new int[R][C];
		// 번호, 방향
		int cnt = 1, direction = -1;
		// 시작점
		int r = R - 1, c = 0;
		while (cnt <= R * C) {
			direction++;
			switch (direction % 4) {
			// 위로 가자
			case 0:
				for (int i = R - 1; i >= 0; i--) {
					if (arr[i][c] == 0) {
						arr[i][c] = cnt++;
						r = i;
					}
				}
				break;
			// 우로가자
			case 1:
				for (int i = 0; i < C; i++) {
					if (arr[r][i] == 0) {
						arr[r][i] = cnt++;
						c = i;
					}
				}
				break;
			// 아래로 가자
			case 2:
				for (int i = 0; i < R; i++) {
					if (arr[i][c] == 0) {
						arr[i][c] = cnt++;
						r = i;
					}
				}
				break;
			case 3:
				for (int i = C - 1; i >= 0; i--) {
					if (arr[r][i] == 0) {
						arr[r][i] = cnt++;
						c = i;
					}
				}
				break;
			}
		}
		// k 찾기
		boolean flag = false;
		outer:
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(arr[i][j] ==K) {
					System.out.printf("%d %d",j+1,R-i);
					flag=true;
					break outer; 
				}
			}
		}
		if(!flag)System.out.println(0);
	}
}