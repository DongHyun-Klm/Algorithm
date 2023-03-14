import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int[] count = new int[101];
			for (int i = 0; i < 3; i++) {
				count[sc.nextInt()]++;
			}
			for (int i = 0; i < count.length; i++) {
				if(count[i] == 1 || count[i] == 3) System.out.printf("#%d %d\n",tc,i);
			}
		}
	}
}