import java.util.Scanner;

public class Main {
	static int N, cnt1, cnt2;
	static int[][] arr;
	static boolean[][] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		chk = new boolean[N][N];
		cnt1 = 0; cnt2 = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		dfs(1);
		System.out.println(cnt1);
		System.out.println(cnt2);
	}
	private static void dfs(int d) {
		if(d==2*N) {
			return;
		}
		// N/d는 한번에 탐색할 범위, N=8이라면 8>4>2>1 크기로 탐색
		else {
			int r = 0;
			int c = 0;
			while (r!=N || c!=N) {
				// 이미 카운트한 색종이라면 index 다음으로 이동하고 continue
				if(chk[r][c]) {
					c += N/d;
					if(c == N) {
						r += N/d;
						if(r!=N)c = 0;
					}
					continue;
				}
				int color = arr[r][c];
				boolean flag = true;
				
				// 영역내의 색종이 색이 모두 같은지 확인
				o:for (int i = r; i < r + N/d; i++) {
					for (int j = c; j < c + N/d; j++) {
						if(arr[i][j]!=color) {
							flag = false;
							break o;
						}
					}
				}
				// 같다면 카운트 증가시키고, 영역 내의 색종이 모두 true로 바꾸기
				if(flag) {
					if(color==0) cnt1++;
					else cnt2++;
					for (int i = r; i < r + N/d; i++) {
						for (int j = c; j < c + N/d; j++) {
							chk[i][j] = true;
						}
					}
				}
				// index 다음으로 이동
				c += N/d;
				if(c == N) {
					r += N/d;
					if(r!=N)c = 0;
				}
			}
			// 탐색 다했다면 다음 탐색 크기로 이동
			dfs(d*2);
		}
	}
}