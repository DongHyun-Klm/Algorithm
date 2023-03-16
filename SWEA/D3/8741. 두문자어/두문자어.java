import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); sc.nextLine();
		for (int tc = 0; tc < N; tc++) {
			String[] s = sc.nextLine().split(" ");
			StringBuilder sb = new StringBuilder();
			sb.append('#').append(tc+1).append(' ');
			for (int i = 0; i < s.length; i++) {
				sb.append(s[i].charAt(0));
			}
			System.out.println(sb.toString().toUpperCase());
		}
	}
}