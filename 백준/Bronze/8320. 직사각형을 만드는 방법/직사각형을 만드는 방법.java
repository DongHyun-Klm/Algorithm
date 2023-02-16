import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), sum=0;
		for (int i = 1; i <= N; i++) {
			sum += rectangle(i);
		}
		System.out.println(sum);
	}
	static int rectangle(int N) {
		int cnt = 0;
		for (int i = 1; i <= (int)Math.sqrt(N); i++) {
			if(N % i ==0)cnt++;
		}
		return cnt;
	}
}
