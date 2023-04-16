import java.util.Scanner;

public class Main {
	static int N, M, min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt(); min = Integer.MAX_VALUE;
		char[][] arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next().toCharArray();
		}
		
		rec(0,0, arr);
		if(min==Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(min);
	}
	//백트래킹(완탐)
	private static void rec(int d, int finish, char[][] arr) {
		if(d==11) {
			return;
		}
		if(finish>0) {
			if(finish==1) min = Math.min(min, d);
			return;
		}
		for (int i = 0; i < 4; i++) {
			char[][] copy = new char[N][M];
			for (int j = 0; j < N; j++) copy[j] = arr[j].clone();
			int ret = moving(i, copy);
			// 이동전과 후가 같다면 다음 방향으로 넘겨버리기
			if(chk(arr, copy)) continue;
			rec(d+1, ret, copy);
		}
	}
	
	//4가지 방향으로 기울이는 메서드
	private static int moving(int dir, char[][] arr) {
		int red_r = -1, red_c = -1, blue_r = -1, blue_c = -1, ret = 0;
		// 공 좌표 찾기
		for (int i = 1; i < N-1; i++) {
			for (int j = 1; j < M-1; j++) {
				if(arr[i][j]=='R') {
					red_r = i;
					red_c = j;
				}
				else if(arr[i][j]=='B') {
					blue_r = i;
					blue_c = j;
				}
			}
		}
		//왼,오,위,아래 | 0,1,2,3
		switch (dir) {
		case 0:
			int flag1 = 0;
			if(red_r==blue_r) {
				if(red_c<blue_c) flag1 = 1;
				else flag1 = 2;
			}
			while (true) {
				if(arr[red_r][red_c - 1]=='O') {
					swap(red_r,red_c,red_r,red_c-1, arr);
					ret += 1; red_c--;
					break;
				}
				if(arr[red_r][red_c - 1]=='#') break;
				if(arr[red_r][red_c - 1]=='B') blue_c++;
				swap(red_r,red_c,red_r,red_c-1, arr);
				red_c--;
			}
			while (true) {
				if(arr[blue_r][blue_c - 1]=='O') {
					swap(blue_r, blue_c, blue_r, blue_c-1, arr);
					ret += 2; blue_c--;
					break;
				}
				if(arr[blue_r][blue_c - 1]=='#') break;
				if(arr[blue_r][blue_c - 1]=='R') red_c++;
				swap(blue_r, blue_c, blue_r, blue_c-1, arr);
				blue_c--;
			}
			if(flag1>0 && Math.abs(red_c-blue_c) == 1) {
				if(flag1 == 1) {
					if(red_c > blue_c) swap(red_r,red_c,red_r,red_c-1, arr);
				}
				else if(flag1 == 2) {
					if(blue_c > red_c) swap(blue_r, blue_c, blue_r, blue_c-1, arr);
				}
			}
			break;
		case 1:
			int flag2 = 0;
			if(red_r==blue_r) {
				if(red_c<blue_c) flag2 = 1;
				else flag2 = 2;
			}
			while (true) {
				if(arr[red_r][red_c + 1]=='O') {
					swap(red_r,red_c,red_r,red_c+1, arr);
					ret += 1; red_c++;
					break;
				}
				if(arr[red_r][red_c + 1]=='#') break;
				if(arr[red_r][red_c + 1]=='B') blue_c--;
				swap(red_r,red_c,red_r,red_c+1, arr);
				red_c++;
			}
			while (true) {
				if(arr[blue_r][blue_c + 1]=='O') {
					swap(blue_r, blue_c, blue_r, blue_c+1, arr);
					ret += 2; blue_c++;
					break;
				}
				if(arr[blue_r][blue_c + 1]=='#') break;
				if(arr[blue_r][blue_c + 1]=='R') red_c--;
				swap(blue_r, blue_c, blue_r, blue_c+1, arr);
				blue_c++;
			}
			if(flag2>0 && Math.abs(red_c-blue_c) == 1) {
				if(flag2 == 1) {
					if(red_c > blue_c) swap(red_r,red_c,red_r,red_c-1, arr);
				}
				else if(flag2 == 2) {
					if(blue_c > red_c) swap(blue_r, blue_c, blue_r, blue_c-1, arr);
				}
			}
			break;
		case 2:
			int flag3 = 0;
			if(red_c==blue_c) {
				if(red_r<blue_r) flag3 = 1;
				else flag3 = 2;
			}
			while (true) {
				if(arr[red_r - 1][red_c]=='O') {
					ret += 1;
					swap(red_r,red_c,red_r-1,red_c, arr);
					red_r--;
					break;
				}
				if(arr[red_r - 1][red_c]=='#') break;
				if(arr[red_r - 1][red_c]=='B') blue_r++;
				swap(red_r,red_c,red_r-1,red_c, arr);
				red_r--;
			}
			while (true) {
				if(arr[blue_r-1][blue_c]=='O') {
					swap(blue_r, blue_c, blue_r-1, blue_c, arr);
					blue_r--;
					ret += 2;
					break;
				}
				if(arr[blue_r-1][blue_c]=='#') break;
				if(arr[blue_r-1][blue_c]=='R') red_r++;
				swap(blue_r, blue_c, blue_r-1, blue_c, arr);
				blue_r--;
			}
			if(flag3>0 && Math.abs(red_r-blue_r) == 1) {
				if(flag3 == 1) {
					if(red_r > blue_r) swap(red_r,red_c,red_r-1,red_c, arr);
				}
				else if(flag3 == 2) {
					if(blue_r > red_r) swap(blue_r, blue_c, blue_r-1, blue_c, arr);
				}
			}
			break;
		case 3:
			int flag4 = 0;
			if(red_c==blue_c) {
				if(red_r<blue_r) flag4 = 1;
				else flag4 = 2;
			}
			while (true) {
				if(arr[red_r + 1][red_c]=='O') {
					ret += 1;
					swap(red_r,red_c,red_r+1,red_c, arr);
					red_r++;
					break;
				}
				if(arr[red_r + 1][red_c]=='#') break;
				if(arr[red_r + 1][red_c]=='B') blue_r--;
				swap(red_r,red_c,red_r+1,red_c, arr);
				red_r++;
			}
			while (true) {
				if(arr[blue_r+1][blue_c]=='O') {
					ret += 2;
					swap(blue_r, blue_c, blue_r+1, blue_c, arr);
					blue_r++;
					break;
				}
				if(arr[blue_r+1][blue_c]=='#') break;
				if(arr[blue_r+1][blue_c]=='R') red_r--;
				swap(blue_r, blue_c, blue_r+1, blue_c, arr);
				blue_r++;
			}
			if(flag4>0 && Math.abs(red_r-blue_r) == 1) {
				if(flag4 == 1) {
					if(red_r > blue_r) swap(red_r,red_c,red_r-1,red_c, arr);
				}
				else if(flag4 == 2) {
					if(blue_r > red_r) swap(blue_r, blue_c, blue_r-1, blue_c, arr);
				}
			}
			break;
		
		}
		return ret;
	}
	
	private static boolean chk(char[][] arr, char[][] copy) {
		boolean flag = false;
		int red_r = -1, red_c = -1, blue_r = -1, blue_c = -1;
		int red_r2 = -1, red_c2 = -1, blue_r2 = -1, blue_c2 = -1;
		for (int i = 1; i < N-1; i++) {
			for (int j = 1; j < M-1; j++) {
				if(arr[i][j]=='R') {
					red_r = i;
					red_c = j;
				}
				else if(arr[i][j]=='B') {
					blue_r = i;
					blue_c = j;
				}
			}
		}
		for (int i = 1; i < N-1; i++) {
			for (int j = 1; j < M-1; j++) {
				if(copy[i][j]=='R') {
					red_r2 = i;
					red_c2 = j;
				}
				else if(copy[i][j]=='B') {
					blue_r2 = i;
					blue_c2 = j;
				}
			}
		}
		if(red_r==red_r2&&red_c==red_c2&&blue_r==blue_r2&&blue_c==blue_c2) flag = true;
		return flag;
	}
	
	private static void swap(int r1, int c1, int r2, int c2, char[][] arr) {
		char temp = arr[r1][c1];
		arr[r1][c1] = arr[r2][c2];
		arr[r2][c2] = temp;
	}
}