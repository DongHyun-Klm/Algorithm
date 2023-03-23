import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M, max;
	static int[][] arr;
	static boolean[][] chk;
	static boolean flag;
	static int[] select = new int[5];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt();
		arr = new int[N+2][M+2];
		chk = new boolean[N+2][M+2];
		max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		// 모든 좌표 시작점 보내기
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				chk[i][j] = true;
				search(1, i, j);
				chk[i][j] = false;
			}
		}
		System.out.println(max);
	}
	private static void search(int d, int r, int c) {
		// 4개 모두 탐색했다면 종료
		if(d == 5) {
			int sum = 0;
			for (int i = 1; i < 5; i++) {
				sum += select[i];
			}
			max = Math.max(max, sum);
		}
		// 좌표가 배열을 나갔다면 종료
		else if(r>N||c>M||c==0||r==0) {
			return;
		}
		//4방향 탐색
		else {
			if(d==3 && flag);
			else select[d] = arr[r][c];
			// ㅏ 모양 처리하기 위해 d=2일 때 제자리에서 보내기
			if(d==2) {
				if(!chk[r+1][c]) {chk[r+1][c] = true; flag = true; select[3] = arr[r+1][c]; search(d+1, r, c); chk[r+1][c] = false; flag = false;}
				if(!chk[r][c+1]) {chk[r][c+1] = true; flag = true; select[3] = arr[r][c+1]; search(d+1, r, c); chk[r][c+1] = false; flag = false;}
				if(!chk[r-1][c]) {chk[r-1][c] = true; flag = true; select[3] = arr[r-1][c]; search(d+1, r, c); chk[r-1][c] = false; flag = false;}
				if(!chk[r][c-1]) {chk[r][c-1] = true; flag = true; select[3] = arr[r][c-1]; search(d+1, r, c); chk[r][c-1] = false; flag = false;}
			}
			
			
			if(!chk[r+1][c]) {chk[r+1][c] = true; search(d+1, r+1, c); chk[r+1][c] = false;}
			if(!chk[r][c+1]) {chk[r][c+1] = true; search(d+1, r, c+1); chk[r][c+1] = false;}
			if(!chk[r-1][c]) {chk[r-1][c] = true; search(d+1, r-1, c); chk[r-1][c] = false;}
			if(!chk[r][c-1]) {chk[r][c-1] = true; search(d+1, r, c-1); chk[r][c-1] = false;}
		}
	}
}