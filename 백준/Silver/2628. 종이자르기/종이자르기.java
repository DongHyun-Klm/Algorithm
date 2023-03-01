import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int colum = sc.nextInt(), row = sc.nextInt();
		int[][] arr = new int[row][colum];
		int n = sc.nextInt();
		int[][] cut = new int[2][];
		cut[0] = new int[row];
		cut[1] = new int[colum];
		for (int i = 0; i < n; i++) {
			cut[sc.nextInt()][sc.nextInt()] = 1;
		}
		// 가로 최대값 구하기
		int max_x = 0, cnt_x=0;
		for (int i = 0; i < colum; i++) {
			if(cut[1][i]==0) {
				cnt_x++;
			}
			else {
				max_x = Math.max(max_x, cnt_x);
				cnt_x = 1;
			}
		}
		max_x = Math.max(max_x, cnt_x);
		// 세로 최대값 구하기
		int max_y = 0, cnt_y=0;
		for (int i = 0; i < row; i++) {
			if(cut[0][i]==0) {
				cnt_y++;
			}
			else {
				max_y = Math.max(max_y, cnt_y);
				cnt_y = 1;
			}
		}
		max_y = Math.max(max_y, cnt_y);
		System.out.println(max_x*max_y);
	}
}