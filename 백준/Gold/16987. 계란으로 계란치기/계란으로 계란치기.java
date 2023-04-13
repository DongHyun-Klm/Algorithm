import java.util.Scanner;

public class Main {
	static int[][] egg;
	static int[] select;
	static int max = 0;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		select = new int[2];
		egg = new int[N][2];
		for (int i = 0; i < N; i++) {
			egg[i][0] = sc.nextInt();
			egg[i][1] = sc.nextInt();
		}
		BT(0);
		System.out.println(max);
	}
	private static void BT(int d) {
		if(d==N) {
			int count = 0;
			for (int i = 0; i < egg.length; i++) {
				if(egg[i][0] <= 0) count++;
			}
			max = Math.max(max, count);
			return;
		}
		for (int i = 0; i < egg.length; i++) {
			// 내 계란이 깨져있으면
			if(egg[d][0] <= 0) {
				BT(d+1);
				break;
			}
			// 내 계란 고른경우
			if(i==d) {
				if(i==N-1) BT(d+1);
				continue;
			}
			// 선택한 계란이 깨져있으면
			if(egg[i][0] <= 0) {
				if(i==N-1) BT(d+1);
				continue;
			}
			egg[d][0] -= egg[i][1];
			egg[i][0] -= egg[d][1];
			BT(d+1);
			egg[d][0] += egg[i][1];
			egg[i][0] += egg[d][1];
		}
	}
}