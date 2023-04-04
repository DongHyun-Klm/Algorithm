import java.util.Scanner;

public class Solution {
	static int N, max, cnt;
	static int[][] arr;
	static int[][] dir = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			N = sc.nextInt();
			max = -1;
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			// 시작점과 방향 보내보자
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j]==0) {
						for (int k = 0; k < 4; k++) {
							cnt = 0;
							shot(i,j,k);
							max = Math.max(max, cnt);
						}
					}
				}
			}
			System.out.printf("#%d %d\n",tc+1,max);
		}
	}
	// k : 0좌 1하 2우 3상
	private static void shot(int r, int c, int k) {
		int start_r = r, start_c = c;
		while (true) {
			flag = false; // 웜홀을 위한 flag
			r = r + dir[k][0];
			c = c + dir[k][1];
			k = chk(r,c,k);
			if(k == -1) break;
			if(r == start_r && c == start_c) break;
			// 웜홀 이동
			if(flag) {
				int[] point = worm(r, c);
				r = point[0];
				c = point[1];
			}
		}
	}
	// r,c를 체크하여 다음 방향을 돌려주는 메서드
	private static int chk(int r, int c, int k) {
		// 배열을 나갔다면 반대로 돌려보내기
		if(r<0||c<0||r>=N||c>=N) {
			cnt++;
			return (k + 2) % 4;
		}
		// -1 : 블랙홀
		if(arr[r][c] == -1) return -1;
		// 0 : 방향 그대로
		if(arr[r][c] == 0) return k;
		// 1 ~ 5 : 블록
		if(arr[r][c] == 1) {
			cnt++;
			if(k == 1) return 2;
			if(k == 0) return 3;
			return (k + 2) % 4;
		}
		if(arr[r][c] == 2) {
			cnt++;
			if(k == 0) return 1;
			if(k == 3) return 2;
			return (k + 2) % 4;
		}
		if(arr[r][c] == 3) {
			cnt++;
			if(k == 2) return 1;
			if(k == 3) return 0;
			return (k + 2) % 4;
		}
		if(arr[r][c] == 4) {
			cnt++;
			if(k == 1) return 0;
			if(k == 2) return 3;
			return (k + 2) % 4;
		}
		if(arr[r][c] == 5) {
			cnt++;
			return (k + 2) % 4;
		}
		// 6 ~ 10 : 웜홀
		else {
			flag = true;
			return k;
		}
	}
	// 웜홀의 반대편 좌표를 돌려주는 메서드
	private static int[] worm(int r, int c) {
		int number = arr[r][c];
		int[] point = new int[2];
		o :for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i==r&&c==j) continue;
				if(arr[i][j] == number) {
					point[0] = i;
					point[1] = j;
					break o;
				}
			}
		}
		return point;
	}
}