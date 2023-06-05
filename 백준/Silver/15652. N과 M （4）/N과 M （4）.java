import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] series;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		series = new int[M + 1];
		series[0] = 1;
		// NM 함수는  1번째 원소부터 M번째 원소를 조건에 맞는 모든 방법 출력
		NM(1);
		System.out.println(sb.toString());
	}

	private static void NM(int d) {
		// 깊이의 끝에 도달
		if (d == M + 1) {
			for (int i = 1; i <= M; i++) {
				sb.append(series[i]).append(' ');
			}
			sb.append('\n');
		}
		// 경우의 수 체크해주고 > 다음 깊이로
		// start를 통해 순서 제거
		else {
			int start = series[d-1];
			for (int i = start; i <= N; i++) {
				series[d] = i;
				NM(d + 1);
				series[d] = 0;
			}
		}
		return;
	}
}