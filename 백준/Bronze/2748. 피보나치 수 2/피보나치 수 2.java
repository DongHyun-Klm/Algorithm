import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(fibo(N));
	}
	private static long fibo(int n){
		long[] f = new long[n+2];
		f[1] = 1;
		f[2] = 1;
		if(n==1) return 1;
		for (int i = 3; i <= n; i++) {
			f[i] = f[i-1] + f[i-2];
		}
		return f[n];
	
	}
}
