import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// DP[n]은 자연수 n을 제곱수들의 합으로 나타낸 경우중 최소개수
		int[] DP = new int[100001];
		// 초기값
		for (int i = 1; i <= (int) Math.sqrt(100000); i++) {
			DP[i * i] = 1;
		}
		for (int i = 2; i <= N; i++) {
			if (DP[i] == 0) {
				DP[i] = Integer.MAX_VALUE; // 좋은 방법 아닌거 같은데 다른 방법이 생각이 안남
				for (int j = i-1; j > 0; j--) {
					DP[i] = Math.min(DP[i], DP[j] + DP[i-j]);
				}
			}
		}
		System.out.println(DP[N]);
	}
}
