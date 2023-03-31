import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static boolean[][] chk;
	static int N, min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); min = Integer.MAX_VALUE;
		arr = new int[N][N];
		chk = new boolean[N][N];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		rec(0, 0);
		
		System.out.println(min);
	}
	
	private static void rec(int d, int sum) {
		if(sum >= min) return;
		if (d == 3) {
			min = Math.min(min, sum);
			return;
		}
	
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				if(chk[i][j]) continue;
				if(chk_cross(i,j)) continue;
				int s = hap(i,j);
				chk[i][j] = true;
				for (int k = 0; k < arr.length; k++) {
					for (int j2 = 0; j2 < 4; j2++) {
						int r = i + dir[j2][0];
						int c = j + dir[j2][1];
						chk[r][c] = true;
					}
				}
				rec(d+1, sum + s);
				chk[i][j] = false;
				for (int k = 0; k < arr.length; k++) {
					for (int j2 = 0; j2 < 4; j2++) {
						int r = i + dir[j2][0];
						int c = j + dir[j2][1];
						chk[r][c] = false;
					}
				}
			}
		}
	}
	// i, j의 십자합 반환
	private static int hap(int i, int j) {
		int sum = arr[i][j];
		for (int j2 = 0; j2 < 4; j2++) {
			int r = i + dir[j2][0];
			int c = j + dir[j2][1];
			sum += arr[r][c];
		}
		return sum;
	}

	// i,j의 십자가 visited 확인
	private static boolean chk_cross(int i, int j) {
		for (int j2 = 0; j2 < 4; j2++) {
			int r = i + dir[j2][0];
			int c = j + dir[j2][1];
			if(chk[r][c]) return true;
		}
		return false;
	}
}