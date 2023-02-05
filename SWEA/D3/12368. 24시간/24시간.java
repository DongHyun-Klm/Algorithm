import java.util.Scanner;

public class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int A = sc.nextInt(), B = sc.nextInt();
			System.out.printf("#%d %d\n",i,(A+B)%24);
		}
	}
}
