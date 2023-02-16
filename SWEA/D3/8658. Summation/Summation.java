import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			int max = 0, min = Integer.MAX_VALUE;
			for (int j = 0; j < 10; j++) {
				int sum = 0;
				String s = sc.next();
				char[] arr = new char[s.length()];
				arr = s.toCharArray();
				for (char c : arr) {
					sum += c-48;
				}
				max = Math.max(max, sum);
				min = Math.min(min, sum);
			}
			System.out.printf("#%d %d %d\n",i+1,max,min);
		}
	}
}
