import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[] prime;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		prime = new boolean[1000001];
		primef();
		while (true) {
			int even = Integer.parseInt(br.readLine()), odd1 = 0, odd2 = 0;
			boolean flag= false;
			if (even == 0)
				break;
			for (int i = 3; i <= even / 2; i += 2) {
				// i가 소수라면
				if (!prime[i]) {
					// 짝수 - i가 소수라면
					if (!prime[even - i]) {
						odd1 = i;
						odd2 = even - i;
						flag = true;
						break;
					}
				}

			}
			if(flag)sb.append(even + " = " + odd1 + " + " + odd2 + "\n");
			else sb.append("Goldbach's conjecture is wrong.\n");
		}
		System.out.println(sb.toString());
	}

	// 아리토스테네스의 체
	private static void primef() {
		prime[0] = prime[1] = true;
		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (!prime[i]) {
				for (int j = i * i; j < prime.length; j += i) {
					prime[j] = true;
				}
			}
		}
	}
}
