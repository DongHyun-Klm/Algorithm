import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt();
		int GCD = GCD(a, b);
		System.out.println(GCD);
		System.out.println(a*b/GCD);
	}
	static int GCD(int a, int b) {
		if(b==0) return a;
		else {
			return GCD(b, a%b);
		}
	}
}
