import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String s = sc.next();
			if((int)(s.charAt(s.length()-1)-'0') % 2 ==1)System.out.printf("#%d Odd\n",tc);
			else System.out.printf("#%d Even\n",tc);
		}
	}
}