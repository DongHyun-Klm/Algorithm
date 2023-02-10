import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			String s = sc.next();
			int a = 1, b = 1;
			char[] arr = new char[s.length()];
			arr = s.toCharArray();
			for (char c : arr) {
				if (c == 'L')
					b = a + b;
				else if (c == 'R') {
					a = a + b;
				}
			}
			System.out.printf("#%d %d %d\n", i, a, b);
		}
	}
}
