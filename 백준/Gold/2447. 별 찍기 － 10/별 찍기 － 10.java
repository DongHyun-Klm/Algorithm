import java.util.Scanner;

public class Main {
	static char[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		arr = new char[N][N];
		rec(N, 0, 0);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j]=='*')sb.append(arr[i][j]);
				else sb.append(' ');
			}
			sb.append('\n');
		}
		System.out.print(sb.toString());
	}
	private static void rec(int n, int r, int c) {
		if(n==3) {
			for (int i = c; i < c + 3; i++) {
				arr[r][i] = '*';
			}
			for (int i = c; i < c + 3; i++) {
				if(i==c+1) continue;
				arr[r+1][i] = '*';
			}
			for (int i = c; i < c + 3; i++) {
				arr[r+2][i] = '*';
			}
			return;
		}
		for (int i = c; i < c + n; i+=n/3) {
			rec(n/3, r, i);
		}
		for (int i = c; i < c + n; i+=n/3) {
			if(i==c+n/3) continue;
			rec(n/3, r+n/3, i);
		}
		for (int i = c; i < c + n; i+=n/3) {
			rec(n/3, r+2*(n/3), i);
		}
	}
}