import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int h1, h2, m1, m2;
		for (int i = 1; i <= T; i++) {
			h1 = sc.nextInt(); m1 = sc.nextInt();
			h2 = sc.nextInt(); m2 = sc.nextInt();
			
			if(m1+m2>=60) {
				h1 += 1;
				m1 -= 60;
			}
			
			if (h1+h2>12) {
				h1 -= 12;
			}
			
			System.out.printf("#%d %d %d\n", i, h1+h2, m1+m2);
		}
				
	}
}
