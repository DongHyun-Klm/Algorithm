import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			System.out.printf("#%d\n",i);
			ArrayList<Character> al = new ArrayList<>();
			int N = sc.nextInt();
			for (int j = 1; j <= N; j++) {
				char c = sc.next().charAt(0);
				int cnt = sc.nextInt();
				for (int k = 0; k < cnt; k++) {
						if (al.size()==10) {
							System.out.println(al.toString().replaceAll("[\\[\\], ]", ""));
							al.clear();
						}
						al.add(c);
				}
			}
			System.out.println(al.toString().replaceAll("[\\[\\], ]", ""));
		}
	}
}
