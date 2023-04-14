import java.util.Scanner;

public class Main {
	static int[] select;
	static int[][] hit;
	static boolean[] visited;
	static int cnt, max, N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		select = new int[10];
		visited = new boolean[10];
		hit = new int[N][10];
		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= 9; j++) {
				hit[i][j] = sc.nextInt();
			}
		}
		max = Integer.MIN_VALUE;
		select[4] = 1;
		visited[1] = true;
		BT(1);
		System.out.println(max);
	}

	private static void BT(int d) {
		if (d == 10) {
			// 야구 시작
			cnt = 0;
			play(1, 0);
			max = Math.max(max, cnt);
			return;
		}
		if (d == 4) {
			BT(d + 1);
		} else {
			// 중복x 순열 뽑기
			for (int i = 1; i <= 9; i++) {
				if (visited[i])
					continue;
				select[d] = i;
				visited[i] = true;
				BT(d + 1);
				visited[i] = false;
			}
		}
	}

	private static void play(int hitter, int d) {
		if (d == N) {
			return;
		}
		int out = 0;
		int[] base = new int[3];
		while (out != 3) {
			switch (hit[d][select[hitter]]) {
			case 0:
				out++;
				break;
			case 1:
				if (base[2] == 1) {
					cnt++;
					base[2] = 0;
				}
				if (base[1] == 1) {
					base[2] = 1;
					base[1] = 0;
				}
				if (base[0] == 1) {
					base[1] = 1;
					base[0] = 0;
				}
				base[0] = 1;
				break;
			case 2:
				if (base[2] == 1) {
					cnt++;
					base[2] = 0;
				}
				if (base[1] == 1) {
					cnt++;
					base[1] = 0;
				}
				if (base[0] == 1) {
					base[2] = 1;
					base[0] = 0;
				}
				base[1] = 1;
				break;
			case 3:
				if (base[2] == 1) {
					cnt++;
					base[2] = 0;
				}
				if (base[1] == 1) {
					cnt++;
					base[1] = 0;
				}
				if (base[0] == 1) {
					cnt++;
					base[0] = 0;
				}
				base[2] = 1;
				break;
			case 4:
				if (base[2] == 1) {
					cnt++;
					base[2] = 0;
				}
				if (base[1] == 1) {
					cnt++;
					base[1] = 0;
				}
				if (base[0] == 1) {
					cnt++;
					base[0] = 0;
				}
				cnt++;
				break;
			}
			hitter = (hitter % 9) + 1;
		}
		play(hitter, d + 1);
	}
}