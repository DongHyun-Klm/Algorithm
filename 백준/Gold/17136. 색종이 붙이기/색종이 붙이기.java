import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] a = new int[10][10];
	static int[] paperCnt = new int[5];
	static int cnt, min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		min = Integer.MAX_VALUE;
		Arrays.fill(paperCnt, 5);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		cnt = 0;
		paper();
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}

	private static void paper() {
		if (chkPaper()) {
			min = Math.min(min, cnt);
			return;
		}
		int r = -1, c = -1;
		o:
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(a[i][j]==1) {
					r = i;
					c = j;
					break o;
				}
			}
		}
		for (int i = 5; i >= 1; i--) {
			if (r + i - 1 >= 10 || c + i - 1 >= 10)
				continue;
			if (paperCnt[i-1] != 0 && chk(r, c, i)) {
				paperCnt[i-1]--;
				cnt++;
				// 0으로 바꾸고
				for (int j = r; j < r + i; j++) {
					for (int j2 = c; j2 < c + i; j2++) {
						a[j][j2] = 0;
					}
				}
				// 다음 깊이 보내고
				paper();
				// 다시 1로 바꾸기
				paperCnt[i-1]++;
				cnt--;
				for (int j = r; j < r + i; j++) {
					for (int j2 = c; j2 < c + i; j2++) {
						a[j][j2] = 1;
					}
				}
			}
		}

	}

	// 10x10 배열의 값이 모두 0인지 확인하는 메서드
	private static boolean chkPaper() {
		boolean flag = true;
		o: for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i][j] == 1) {
					flag = false;
					break o;
				}
			}
		}
		return flag;
	}

	// i, j 좌표를 시작으로 n개의 사각형 검사하는 메서드, 모두 1이면 true
	private static boolean chk(int r, int c, int k) {
		boolean flag = true;
		o: for (int k2 = 0; k2 < k; k2++) {
			for (int l = 0; l < k; l++) {
				if (a[r + k2][c + l] == 0) {
					flag = false;
					break o;
				}
			}
		}
		return flag;
	}
}