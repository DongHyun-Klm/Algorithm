import java.util.Scanner;

public class Main {
	static long[] f = new long[42];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0; i < t; i++) {
		int N = sc.nextInt();
		if(N ==0) {
			System.out.println(1+" "+0);
		}
		else
		System.out.println(fibo(N-1)+" "+fibo(N));
		}
	}
	private static long fibo(int n){
		f[0] = 0;
		f[1] = 1;
		if(n>1) {
		for (int i = 2; i <= n; i++) {
			f[i] = f[i-1] + f[i-2];
		}
		}
		return f[n];
	}
}


