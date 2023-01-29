import java.util.Arrays;
import java.util.Scanner;

public class swea1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt(), count = 1, dir_count=0;
			int[][] arr = new int[N][N];
			int[] dir = {1, 2, 3, 4}; // 방향
			int x=0 , y=0; //마지막 달팽이 좌표. x가 행 y가 열

			while (count!=N*N+1) {
				switch (dir[dir_count%4]) {
				case 1: //오른쪽 이동
					for (int j = 0; j < N; j++) {
						if(arr[x][j] == 0) {
							arr[x][j] = count++;
							y=j;
						}
					}
					dir_count++;
					break;

				case 2: //아래로 이동
					for (int j = 0; j < N; j++) {
						if(arr[j][y] == 0) {
							arr[j][y] = count++;
							x=j;
						}
					}
					dir_count++;
					break;
					
				case 3: //왼쪽 이동
					for (int j = N-1; j >= 0; j--) {
						if(arr[x][j] == 0) {
							arr[x][j] = count++;
							y=j;
						}
					}
					dir_count++;
					break;
					
				case 4: //위로 이동
					for (int j = N-1; j >= 0; j--) {
						if(arr[j][y] == 0) {
							arr[j][y] = count++;
							x=j;
						}
					}
					dir_count++;
					break;
				}
			}
			System.out.printf("#%d\n",i);
			for (int j = 0; j < arr.length; j++) {
				System.out.println(Arrays.toString(arr[j]).replaceAll("[\\[\\],]", ""));
			}
		}
	}
}
