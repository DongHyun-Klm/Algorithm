import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int L = sc.nextInt(), U = sc.nextInt();
			int X = sc.nextInt();
			if (X>U) {
				System.out.printf("#%d -1\n",i);
			}
			else if (X<L) {
				System.out.printf("#%d %d\n",i,L-X);
			}
			else {
				System.out.printf("#%d 0\n",i);
			}
		}
	}
}
