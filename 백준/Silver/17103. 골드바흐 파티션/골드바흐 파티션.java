import java.util.Scanner;

public class Main {
	static boolean[] prime;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		prime = new boolean[1000001];
		getPrime();
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt(), sum =0;
			for (int j = 2; j <= N/2; j++) {
				if(!prime[j]&&!prime[N-j])sum++;
			}
			System.out.println(sum);
		}
	}
	private static void getPrime() {
		prime[0] = prime[1] = true;
		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if(prime[i])continue;
			else {
				for (int j = i*i; j < prime.length; j+=i) {
					prime[j] = true;
				}
			}
		}
	}
}
