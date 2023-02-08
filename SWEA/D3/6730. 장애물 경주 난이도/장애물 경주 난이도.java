import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt(), max = 0, min = 0;
			int[] arr = new int[N];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = sc.nextInt();
			}
			for (int j = 0; j < arr.length - 1; j++) {
				int level = arr[j + 1] - arr[j];
				max = max > level ? max : level;
				min = min < level ? min : level;
			}
			System.out.printf("#%d %d %d\n", i, max, Math.abs(min));
		}
	}
}
