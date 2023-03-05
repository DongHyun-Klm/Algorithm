import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] series, numbers;
	static int max;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		series = new int[M + 1];
		numbers = new int[N + 1];
		max = 0;
		for (int i = 1; i <= N; i++) {
			numbers[i] = sc.nextInt();
		}
		max = 0;
		Arrays.sort(numbers);
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
		else {
			for (int i = 1; i <= N; i++) {
				if(d==1) max =numbers[i];
				else {
					if(max>=numbers[i]) continue;
					else max = numbers[i];
				}
				series[d] = numbers[i];
				NM(d + 1);
				max = 0;
			}
		}
	}
}