import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] series;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		series = new int[M+1];
		// NM 함수는  1번째 원소부터 M번째 원소를 조건에 맞는 모든 방법 출력
		NM(1);
		System.out.println(sb.toString());
	}
	static private int NM(int d) {
		// 깊이가 끝에 도달 > 출력
		if(d == M+1) {
			for (int i = 1; i <= M; i++) {
				sb.append(series[i]).append(' ');
			}
			sb.append('\n');
		}
		// 하나씩 경우의 수를 대입하며 다음깊이로 이동
		else {
			for (int i = 1; i <= N; i++) {
				series[d] = i;
				NM(d+1);
			}
		}
		return 0;
	}
}