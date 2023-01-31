import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
		String s = Integer.toString(i).replaceAll("[369]", "-");
		if(s.contains("-")) {
			List<Character> list = new ArrayList<>();
			char[] S = s.toCharArray();
			for (int j = 0; j < S.length; j++) {
				if(S[j] == '-') {
					list.add('-');
				}
			}
			s = list.toString();
		}
		System.out.print(s.replaceAll("[\\[\\], ]", "") + " ");
		}
	}
}
