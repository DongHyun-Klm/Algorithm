import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int M = sc.nextInt(), N = sc.nextInt(), x = sc.nextInt()-1, y = sc.nextInt()-1;
			int LCM = M*N/GCD(M,N);
			int n = 0, day = -2;
			for (int i = x; i < LCM; i+=M) {
				if(i%N == y) day = i;
			}
			System.out.println(day+1);
		}
	}
	
	// 최대공약수 구하기
	private static int GCD(int m, int n) {
		if(n==0) {
			return m;
		}
		else return GCD(n, m%n);
	}
}