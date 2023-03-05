import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] series;
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		series = new int[M+1];
		check = new boolean[N+1];
		NM(1);
		System.out.println(sb.toString());
	}
	private static void NM(int d) {
		// 깊이의 끝에 도달 
		if(d == M+1) {
			for (int i = 1; i <= M; i++) {
				sb.append(series[i]).append(' ');
			}
			sb.append('\n');
		}
		// 경우의 수 체크해주고 > 다음 깊이로
		else {
			for (int i = 1; i <= N; i++) {
				if(check[i]) continue;
				series[d] = i; check[i] = true;
				NM(d+1);
				check[i] = false;
			}
		}
		return ;
	}
}