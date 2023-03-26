import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N, ans;
	static int[][] arr;
	static boolean[] chk = new boolean[101];
	static int[] dc = { 1, 1, -1, -1 };
	static int[] dr = { -1, 1, 1, -1 };
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			ans = -1; 
			arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			for (int i = 1; i < N; i++) {
				for (int j = 1; j < N; j++) {
					dessert(i, j);
				}
			}
			System.out.printf("#%d %d\n",tc,ans);
		}
	}
	// rd는 우대각 길이 ld는 좌대각 길이
	private static void dessert(int rd, int ld) {
		if(rd==N || ld==N || rd+ld ==2*N) {
			return;
		}
		// i,j는 출발점 좌표
		o: for (int i = 1; i < arr.length-1; i++) {
			i :for (int j = 0; j < arr.length-2; j++) {
				Arrays.fill(chk, false);
				int r = i; int c = j;
				for (int k = 0; k < 4; k++) {
					// 좌대각
					if(k==1||k==3) {
						for (int k2 = 0; k2 < ld; k2++) {
							r += dr[k];
							c += dc[k];
							if(r == N || c == N || r == -1 || c == -1) continue i;
							if(chk[arr[r][c]]) continue i;
							chk[arr[r][c]] = true;
						}
					}
					// 우대각
					else {
						for (int k2 = 0; k2 < rd; k2++) {
							r += dr[k];
							c += dc[k];
							if(r == N || c == N || r == -1 || c == -1) continue i;
							if(chk[arr[r][c]]) continue i;
							chk[arr[r][c]] = true;
						}
					}
				}
				ans = Math.max(2*rd + 2*ld, ans);
				break o;
			}
		}
	}
}