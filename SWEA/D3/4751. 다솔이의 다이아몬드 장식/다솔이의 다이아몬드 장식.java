import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int tc = 1; tc <= N; tc++) {
			char[] arr = sc.next().toCharArray();
			for (int i = 0; i < arr.length; i++) {
				System.out.print("..#.");
			}
			System.out.printf(".\n");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(".#.#");
			}
			System.out.printf(".\n");
			for (int i = 0; i < arr.length; i++) {
				System.out.printf("#.%c.", arr[i]);
			}
			System.out.printf("#\n");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(".#.#");
			}
			System.out.printf(".\n");
			for (int i = 0; i < arr.length; i++) {
				System.out.print("..#.");
			}
			System.out.printf(".\n");
		}
	}
}
