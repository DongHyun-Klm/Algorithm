import java.util.Scanner;

public class Main {
	public static boolean[] prime;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(), N = sc.nextInt();
		prime = new boolean[N+1];
		get_prime();
		
		for (int i = M; i <= N; i++) {
			if(!prime[i])System.out.println(i);
		}
	}
	private static void get_prime() {
		prime[0] = prime[1] = true;
		
		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if(prime[i]) continue;
			for (int j = i*i; j < prime.length; j+=i) {
				prime[j] = true;
			}
		}
	}
}
